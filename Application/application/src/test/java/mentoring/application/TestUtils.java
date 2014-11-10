package mentoring.application;

import java.util.ArrayList;
import java.util.List;

import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.Person;
import mentoring.application.model.Purse;

public class TestUtils {

    public static Bank createBankModel(){
        Bank bank = new Bank();

        List<Account> accounts = new ArrayList<Account>();
        Account account = new Account();
        account.setId("accountId");

        List<Person> persons = new ArrayList<Person>();
        Person person = new Person();
        person.setName("Andrei");
        persons.add(person);

        account.setPersons(persons);

        List<Purse> purses = new ArrayList<Purse>();
        Purse purse = new Purse();
        purse.setName("fromPurseName");
        purse.setCurrency("USD");
        purse.setAmount(500d);
        purses.add(purse);
        
        Purse purse1 = new Purse();
        purse1.setName("toPurseName");
        purse1.setCurrency("RUB");
        purse.setAmount(500d);
        purses.add(purse1);

        account.setPurses(purses);

        accounts.add(account);
        bank.setAccounts(accounts);
        return bank;
    }
}
