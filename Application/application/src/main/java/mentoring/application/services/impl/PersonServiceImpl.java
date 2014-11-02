package mentoring.application.services.impl;

import java.util.ArrayList;
import java.util.List;

import mentoring.application.dao.BankDao;
import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.Person;
import mentoring.application.services.PersonService;

public class PersonServiceImpl implements PersonService{

    private BankDao bankDao;
    
    public PersonServiceImpl(BankDao bankDao) {
        this.bankDao = bankDao;
    }
    
    @Override
    public List<Account> getPersonAccounts(Person person) {
        Bank bank = bankDao.getBank();
        List<Account> accounts = bank.getAccounts();
        List<Account> personAccounts = new ArrayList<Account>();
        if(accounts != null){
            for (Account account : accounts) {
                List<Person> persons = account.getPersons();
                if(persons != null && persons.contains(person)){
                    personAccounts.add(account);
                }
            }
        }
        return personAccounts;
    }

}
