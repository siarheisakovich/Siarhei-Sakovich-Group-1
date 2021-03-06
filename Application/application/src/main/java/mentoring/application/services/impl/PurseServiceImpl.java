package mentoring.application.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import mentoring.application.dao.BankDao;
import mentoring.application.exception.ServiceException;
import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.Purse;
import mentoring.application.services.AccountService;
import mentoring.application.services.PurseService;

public class PurseServiceImpl implements PurseService {

    private BankDao bankDao;
    
    public PurseServiceImpl(BankDao bankDao) {
        this.bankDao = bankDao;
    }
    
    @Override
    public List<Purse> getAllPurses(String accountId) {
        Bank bank = bankDao.getBank();
        List<Account> accounts = bank.getAccounts();
        if(accounts != null ){
            for (Account account : accounts) {
                if(StringUtils.equals(accountId, account.getId())){
                    return account.getPurses();
                }
            }
            
        }
        return new ArrayList<Purse>();
    }

    @Override
    public void addPurse(String accountId, Purse purse) throws IOException, ServiceException {
        AccountService accountService = new AccountServiceImpl(bankDao);
        Account account = accountService.getAccountById(accountId);
        List<Purse> purses = account.getPurses();
        if(purses != null){
            for (Purse purseItem : purses) {
                if(StringUtils.equals(purseItem.getName(), purse.getName())){
                    throw new ServiceException("Purse already assigned to Account id: " + account.getId());
                }
            }
            purses.add(purse);
        } else {
            List<Purse> newPurses = new ArrayList<Purse>();
            newPurses.add(purse);
            account.setPurses(newPurses);
        }
        accountService.updateAccount(account);
    }

    @Override
    public void removePurse(Account account, Purse purse) throws IOException {
        Bank bank = bankDao.getBank();
        List<Account> accounts = bank.getAccounts();
        if(accounts != null && accounts.contains(account)){
            List<Purse> purses = account.getPurses();
            if(purses != null && purses.contains(purse)){
                purses.remove(purse);
                bankDao.saveBank(bank);
            }
        }
    }
    
    

}
