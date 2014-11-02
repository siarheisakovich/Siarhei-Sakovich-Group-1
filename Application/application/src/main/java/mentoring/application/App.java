package mentoring.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.Currency;
import mentoring.application.model.Person;
import mentoring.application.model.Purse;

/**
 * Hello world!
 *
 */
public class App {
    
    private static final File FILE = new File("./file.xml");
    
    public static void main(String[] args) throws IOException {

        Bank bank = new Bank();

        List<Account> accounts = new ArrayList<Account>();
        Account account = new Account();

        List<Person> persons = new ArrayList<Person>();
        Person person = new Person();
        person.setName("Andrei");
        persons.add(person);

        account.setPersons(persons);

        List<Purse> purses = new ArrayList<Purse>();
        Purse purse = new Purse();
        Currency currency = new Currency();
        currency.setName("USD");
        purse.setName("USD Purse");
        purse.setCurrency(currency);
        purses.add(purse);

        account.setPurses(purses);

        accounts.add(account);
        bank.setAccounts(accounts);

        XStream xstream = new XStream(new DomDriver());
        xstream.alias("person", Person.class);
        xstream.alias("bank", Bank.class);
        xstream.alias("account", Account.class);
        
        FileWriter fileWriter = new FileWriter(FILE);
        xstream.toXML(bank, fileWriter);
        
        Bank bank1 = (Bank)xstream.fromXML(FILE);
        bank1.getAccounts();
        
        
//        ConsoleController consoleController = new ConsoleController();
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//            String command = scanner.nextLine();
//            ResultBean resultBean = consoleController.process(command);
//            System.out.println(resultBean.getMessage());
//            scanner.close();
//        }

    }

}
