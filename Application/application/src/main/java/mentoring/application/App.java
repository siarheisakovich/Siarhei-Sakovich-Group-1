package mentoring.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import mentoring.application.dao.BankDao;
import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.Currency;
import mentoring.application.model.Person;
import mentoring.application.model.Purse;
import mentoring.application.services.AccountService;
import mentoring.application.services.impl.AccountServiceImpl;
import mentoring.application.services.impl.PersonServiceImpl;

public class App {
    
    public static void main(String[] args) throws IOException {
        if(args != null && args.length > 0 && "initData".equals(args[0])){
            Bank bank = new Bank();

            List<Account> accounts = new ArrayList<Account>();
            Account account = new Account();
            account.setId("AccountId");

            List<Person> persons = new ArrayList<Person>();
            Person person = new Person();
            person.setName("Andrei");
            persons.add(person);

            account.setPersons(persons);

            List<Purse> purses = new ArrayList<Purse>();
            Purse purse = new Purse();
            Currency currency = new Currency();
            currency.setName("USD");
            purse.setName("USDPurse");
            purse.setCurrency(currency);
            purses.add(purse);

            account.setPurses(purses);

            accounts.add(account);
            bank.setAccounts(accounts);
            
            BankDao bankDao = new BankDao();
            bankDao.saveBank(bank);
        }
        
        Person person = new Person();
        person.setName("Andrei");
        boolean exit = false;
        while (exit != true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if("accountList".equals(command)){
                PersonServiceImpl personService = new PersonServiceImpl(new BankDao());
                List<Account> accounts = personService.getPersonAccounts(person);
                for (Account account : accounts) {
                    System.out.print(account.getId());
                }
            } else if(StringUtils.startsWith(command, "pursesList ")){
                AccountService accountService = new AccountServiceImpl(new BankDao());
                String accountId = command.split(" ")[1];
                if(StringUtils.isNotEmpty(accountId)){
                    List<Purse> purses = accountService.getAccountPurses(accountId);
                    for (Purse purse : purses) {
                        System.out.print(purse.toString());
                    }
                }
            } else if(StringUtils.equals("addAccount", command)){ // should have account name (id)
                //TODO
            } else if(StringUtils.equals("addPurse", command)){ // should have purse name, account, amount, currency
                //TODO                
            } else if(StringUtils.equals("assignAccount", command)){ // should have account
                //TODO
            } else if(StringUtils.equals("exchange", command)) { // should have 1 purse name, 2 purse name, amount.
                //TODO
            } else if("exit".equals(command)){
                exit = true;
            }
        }
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
