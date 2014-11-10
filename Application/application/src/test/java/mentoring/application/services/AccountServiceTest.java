package mentoring.application.services;

import java.io.IOException;
import java.util.ArrayList;

import mentoring.application.dao.BankDao;
import mentoring.application.exception.ServiceException;
import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.Person;
import mentoring.application.model.Purse;
import mentoring.application.services.impl.AccountServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Assert;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
    
    @Mock BankDao bankDao;
    
    @Before
    public void init(){
        Bank bank = new Bank();
        when(bankDao.getBank()).thenReturn(bank);
    }
    
    @Test
    public void createAccountTest() throws IOException, ServiceException{
        AccountService accountService = new AccountServiceImpl(bankDao);
        Account account = new Account();
        account.setId("newOne");
        accountService.createAccount(account);
        Assert.assertNotNull(accountService.getAccountById("newOne"));
    }
    
    @Test(expected=ServiceException.class)
    public void createAccountWithExistingIdTest() throws IOException, ServiceException{
        AccountService accountService = new AccountServiceImpl(bankDao);
        Account account = new Account();
        account.setId("newOne");
        accountService.createAccount(account);
        account.setId("newOne");
        accountService.createAccount(account);
    }
    
    @Test
    public void getAccountByIdTest() throws IOException, ServiceException{
        AccountService accountService = new AccountServiceImpl(bankDao);
        Account account = new Account();
        account.setId("newOne");
        accountService.createAccount(account);
        Assert.assertNotNull(accountService.getAccountById("newOne"));
    }
    
    @Test(expected=ServiceException.class)
    public void updateNotExistingAccountTest() throws IOException, ServiceException{
        AccountService accountService = new AccountServiceImpl(bankDao);
        Account account = new Account();
        account.setId("newOne");        
        accountService.updateAccount(account);       
    }
    
    @Test
    public void updateExistingAccountTest() throws IOException, ServiceException{
        AccountService accountService = new AccountServiceImpl(bankDao);
        Account account = new Account();
        account.setId("newOne");
        accountService.createAccount(account);
        account.setPurses(new ArrayList<Purse>());
        account.setPersons(new ArrayList<Person>());
        accountService.updateAccount(account);    
        Assert.assertNotNull(accountService.getAccountById("newOne").getPersons());
        Assert.assertNotNull(accountService.getAccountById("newOne").getPurses());
    }
}
