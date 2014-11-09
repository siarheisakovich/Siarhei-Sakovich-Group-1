package mentoring.application.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import mentoring.application.dao.BankDao;
import mentoring.application.exception.ServiceException;
import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.Person;
import mentoring.application.model.Purse;
import mentoring.application.services.AccountService;

public class AccountServiceImpl implements AccountService {

    private BankDao bankDao;

    public AccountServiceImpl(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    @Override
    public void createAccount(Account account) throws IOException, ServiceException {
        Bank bank = bankDao.getBank();
        List<Account> accounts = bank.getAccounts();
        for (Account accountItem : accounts) {
            if(StringUtils.equals(accountItem.getId(), account.getId())){
                throw new ServiceException("Account already exist. Account id: " + account.getId());
            }
        }
        accounts.add(account);
        bankDao.saveBank(bank);
    }

    @Override
    public void assignPerson(Account account, Person person) throws IOException, ServiceException {
        Bank bank = bankDao.getBank();
        List<Account> accounts = bank.getAccounts();
        if (accounts != null && accounts.contains(account)) {
            List<Person> persons = account.getPersons();
            if (persons != null) {
                if(!persons.contains(person)){
                    persons.add(person);
                } else {
                    throw new ServiceException("Person already assigned to Account id: " + account.getId());
                }
            } else {
                persons = new ArrayList<Person>();
                persons.add(person);
                account.setPersons(persons);
            }
        } else {
            throw new ServiceException("Account doesn't exist. Account id: " + account.getId());
        }
        bankDao.saveBank(bank);
    }

    @Override
    public List<Purse> getAccountPurses(String accountId) {
        Bank bank = bankDao.getBank();
        List<Account> accounts = bank.getAccounts();
        if (accounts != null) {
            for (Account account : accounts) {
                if (StringUtils.equals(accountId, account.getId())) {
                    return account.getPurses();
                }
            }
        }
        return null;
    }

    @Override
    public Account getAccountById(String accountId) throws ServiceException {
        Bank bank = bankDao.getBank();
        List<Account> accounts = bank.getAccounts();
        if (accounts != null) {
            for (Account account : accounts) {
                if (StringUtils.equals(accountId, account.getId())) {
                    return account;
                }
            }
            throw new ServiceException("Account doesn't exist. Account id: " + accountId);
        } else{
            throw new ServiceException("Account doesn't exist. Account id: " + accountId);
        }
    }

    @Override
    public void updateAccount(Account account) throws IOException,
            ServiceException {
        Bank bank = bankDao.getBank();
        List<Account> accounts = bank.getAccounts();
        for (Account accountItem : accounts) {
            if(StringUtils.equals(accountItem.getId(), account.getId())){
                accountItem.setPurses(account.getPurses());
                accountItem.setPersons(account.getPersons());
            }
        }
        bankDao.saveBank(bank);
    }

}
