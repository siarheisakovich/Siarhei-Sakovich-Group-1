package mentoring.application.services.impl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import mentoring.application.dao.BankDao;
import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.Person;
import mentoring.application.model.Purse;
import mentoring.application.services.AccountService;

public class AccountServiceImpl implements AccountService{
    
    private BankDao bankDao;
    
    public AccountServiceImpl(BankDao bankDao) {
        this.bankDao = bankDao;
    }
    
    @Override
    public void createAccount(Account account) throws IOException {
        Bank bank = bankDao.getBank();
        bank.getAccounts().add(account);
        bankDao.saveBank(bank);
    }

    @Override
    public void assignPerson(Account account, Person person) throws IOException {
        Bank bank = bankDao.getBank();
        List<Account> accounts = bank.getAccounts();
        if(accounts != null && accounts.contains(account)){
            List<Person> persons = account.getPersons();
            if(persons != null && !persons.contains(person)){
                persons.add(person);
            }
        }
        bankDao.saveBank(bank);
    }

    @Override
    public List<Purse> getAccountPurses(String accountId) {
        Bank bank = bankDao.getBank();
        List<Account> accounts = bank.getAccounts();
        if(accounts != null){
            for (Account account : accounts) {
                if(StringUtils.equals(accountId, account.getId())){
                    return account.getPurses();
                }
            }
        }
        return null;
    }
    
    
    
}
