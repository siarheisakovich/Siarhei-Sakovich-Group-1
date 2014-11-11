package mentoring.application.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mentoring.application.dao.BankDao;
import mentoring.application.dao.CurrencyDao;
import mentoring.application.exception.ServiceException;
import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.CurrencyOperation;
import mentoring.application.model.Purse;
import mentoring.application.services.impl.ExchangeServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeServiceTest {
    
    @Mock BankDao bankDao;
    
    @Mock CurrencyDao currencyDao;
    
    private final static  double USD_EXCHANGE_COEFF = 40d;
    
    private final static  double RUB_EXCHANGE_COEFF = 1d/USD_EXCHANGE_COEFF;
    
    private final static String ACCOUNT_ID = "accountId";
    
    private final static String FROM_PURSE_NAME = "purse1";
    
    private final static String TO_PURSEN_NAME = "purse2";
    
    private final static double FROM_PURSE_AMOUNT = 500d;
    
    private final static double TO_PURSE_AMOUNT = 500d;
    
    @Before
    public void init(){
        Bank bank = new Bank();
        List<Account> accounts = new ArrayList<Account>();
        Account account = new Account();
        account.setId(ACCOUNT_ID);
        List<Purse> purses = new ArrayList<Purse>();
        Purse purse = new Purse();
        purse.setName(FROM_PURSE_NAME);
        purse.setCurrency("USD");
        purse.setAmount(FROM_PURSE_AMOUNT);
        purses.add(purse);
        Purse purse1 = new Purse();
        purse1.setName(TO_PURSEN_NAME);
        purse1.setCurrency("RUB");
        purse1.setAmount(TO_PURSE_AMOUNT);
        purses.add(purse1);
        account.setPurses(purses);
        accounts.add(account);
        bank.setAccounts(accounts);
        when(bankDao.getBank()).thenReturn(bank);
        
        List<CurrencyOperation> currencyOperations = new ArrayList<CurrencyOperation>();
        CurrencyOperation usdToRub = new CurrencyOperation();
        usdToRub.setFromCurrency("USD");
        usdToRub.setToCurrency("RUB");
        usdToRub.setCoefficent(USD_EXCHANGE_COEFF);
        
        CurrencyOperation rubToUsd = new CurrencyOperation();
        rubToUsd.setFromCurrency("RUB");
        rubToUsd.setToCurrency("USD");
        rubToUsd.setCoefficent(RUB_EXCHANGE_COEFF);
        currencyOperations.add(rubToUsd);
        currencyOperations.add(usdToRub);
        
        when(currencyDao.getCurrencyOperationsList()).thenReturn(currencyOperations);
    }
    
    @Test
    public void exchangeTest() throws IOException, ServiceException{
        ExchangeService exchangeService = new ExchangeServiceImpl(bankDao, currencyDao);
        exchangeService.exchange(ACCOUNT_ID, FROM_PURSE_NAME, TO_PURSEN_NAME, FROM_PURSE_AMOUNT);
    }
    
    @Test(expected=ServiceException.class)
    public void imposibleExchangeTest() throws IOException, ServiceException{
        ExchangeService exchangeService = new ExchangeServiceImpl(bankDao, currencyDao);
        exchangeService.exchange(ACCOUNT_ID, FROM_PURSE_NAME, TO_PURSEN_NAME, FROM_PURSE_AMOUNT + 1);
    }
    
    @Test(expected=ServiceException.class)
    public void notExistingPursesTest() throws IOException, ServiceException{
        ExchangeService exchangeService = new ExchangeServiceImpl(bankDao, currencyDao);
        exchangeService.exchange(ACCOUNT_ID, FROM_PURSE_NAME + "a", TO_PURSEN_NAME, FROM_PURSE_AMOUNT);
    }
    
    @Test(expected=ServiceException.class)
    public void notExistingPurses1Test() throws IOException, ServiceException{
        ExchangeService exchangeService = new ExchangeServiceImpl(bankDao, currencyDao);
        exchangeService.exchange(ACCOUNT_ID, FROM_PURSE_NAME, TO_PURSEN_NAME + "a", FROM_PURSE_AMOUNT);
    }
}
