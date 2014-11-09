package mentoring.application.services.impl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import mentoring.application.dao.BankDao;
import mentoring.application.dao.CurrencyDao;
import mentoring.application.exception.ServiceException;
import mentoring.application.model.Account;
import mentoring.application.model.CurrencyOperation;
import mentoring.application.model.ExchangeResult;
import mentoring.application.model.Purse;
import mentoring.application.services.AccountService;
import mentoring.application.services.CurrencyPriceService;
import mentoring.application.services.ExchangeService;

public class ExchangeServiceImpl implements ExchangeService{

    private BankDao bankDao;
    
    private CurrencyDao currencyDao;
    
    public ExchangeServiceImpl(BankDao bankDao, CurrencyDao currencyDao) {
        this.bankDao = bankDao;
        this.currencyDao = currencyDao;
    }
    
    @Override
    public ExchangeResult exchange(String accountId, String fromPurseName, String toPurseName, double amount) throws ServiceException, IOException {
        AccountService accountService = new AccountServiceImpl(bankDao);
        Account account = accountService.getAccountById(accountId);
        List<Purse> purses = account.getPurses();
        if(purses != null){
            Purse fromPurse = null;
            Purse toPurse = null;
            for (Purse purse : purses) {
                if(StringUtils.equals(purse.getName(), fromPurseName)){
                    fromPurse = purse;
                } else if (StringUtils.equals(purse.getName(), toPurseName)) {
                    toPurse = purse;
                }
            }
            if(fromPurse == null || toPurse == null){
                throw new ServiceException("This Account (" + accountId
                        + ") doesn't contains Purse (" + fromPurseName
                        + ") or Purse (" + toPurseName + ")");
            } else {
                CurrencyPriceService currencyPriceService = new CurrencyPriceServiceImpl(currencyDao);
                CurrencyOperation currencyOperation = currencyPriceService
                        .getOperation(fromPurse.getCurrency(),
                                toPurse.getCurrency());
                if(currencyOperation == null){
                    throw new ServiceException("Currency operation "+ fromPurse.getCurrency() + " to " + toPurse.getCurrency() + " not supported");
                }
                if(fromPurse.getAmount() < amount){
                    throw new ServiceException("Not enough money on "+ fromPurse.getName());
                }
                
                double exchangeCoeff = currencyOperation.getCoefficent();
                double newFromPurseAmount = fromPurse.getAmount() - amount;
                double newToPurseAmount = toPurse.getAmount() + amount * exchangeCoeff;
                fromPurse.setAmount(newFromPurseAmount);
                toPurse.setAmount(newToPurseAmount);
                
                accountService.updateAccount(account);
                ExchangeResult exchangeResult = new ExchangeResult();
                return exchangeResult;
            }
        } else {
            throw new ServiceException("This Account (" + accountId
                    + ") doesn't contains any Purses");
        }
    }

}
