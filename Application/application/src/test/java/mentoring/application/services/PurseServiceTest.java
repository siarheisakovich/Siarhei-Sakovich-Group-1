package mentoring.application.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mentoring.application.dao.BankDao;
import mentoring.application.exception.ServiceException;
import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.Purse;
import mentoring.application.services.impl.PurseServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Assert;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PurseServiceTest {
    
    @Mock BankDao bankDao;
    
    private final static String ACCOUNT_ID = "accountId";
    
    private final static String FROM_PURSE_NAME = "purse1";
    
    private final static String TO_PURSEN_NAME = "purse2";
    
    @Before
    public void init(){
        Bank bank = new Bank();
        List<Account> accounts = new ArrayList<Account>();
        Account account = new Account();
        account.setId(ACCOUNT_ID);
        List<Purse> purses = new ArrayList<Purse>();
        Purse purse = new Purse();
        purse.setName(FROM_PURSE_NAME);
        purses.add(purse);
        Purse purse1 = new Purse();
        purse1.setName(TO_PURSEN_NAME);
        purses.add(purse1);
        account.setPurses(purses);
        accounts.add(account);
        bank.setAccounts(accounts);
        
        when(bankDao.getBank()).thenReturn(bank);
    }
    
    @Test
    public void pursesList() {
        PurseService purseService = new PurseServiceImpl(bankDao);
        List<Purse> purses = purseService.getAllPurses(ACCOUNT_ID);
        Assert.assertEquals(purses.size(), 2);
    }
    
    @Test
    public void addPurseTest() throws IOException, ServiceException{
        PurseService purseService = new PurseServiceImpl(bankDao);
        Purse purse = new Purse();
        purseService.addPurse(ACCOUNT_ID, purse);
        List<Purse> purses = purseService.getAllPurses(ACCOUNT_ID);
        Assert.assertEquals(purses.size(), 3);
    }
    
    @Test(expected=ServiceException.class)
    public void addPurseToNotExistingAccountTest() throws IOException, ServiceException{
        PurseService purseService = new PurseServiceImpl(bankDao);
        Purse purse = new Purse();
        purse.setName(FROM_PURSE_NAME);
        purseService.addPurse(ACCOUNT_ID + 1, purse);    
    }
    
    @Test(expected=ServiceException.class)
    public void addPurseWithExistingNameTest() throws IOException, ServiceException{
        PurseService purseService = new PurseServiceImpl(bankDao);
        Purse purse = new Purse();
        purse.setName(FROM_PURSE_NAME);
        purseService.addPurse(ACCOUNT_ID, purse);    
    }
}
