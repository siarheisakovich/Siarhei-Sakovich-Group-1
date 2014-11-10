package mentoring.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import mentoring.application.dao.BankDao;
import mentoring.application.dao.CurrencyDao;
import mentoring.application.exception.ServiceException;
import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.CurrencyOperation;
import mentoring.application.model.Person;
import mentoring.application.model.Purse;
import mentoring.application.services.AccountService;
import mentoring.application.services.CurrencyPriceService;
import mentoring.application.services.ExchangeService;
import mentoring.application.services.PurseService;
import mentoring.application.services.impl.AccountServiceImpl;
import mentoring.application.services.impl.CurrencyPriceServiceImpl;
import mentoring.application.services.impl.ExchangeServiceImpl;
import mentoring.application.services.impl.PersonServiceImpl;
import mentoring.application.services.impl.PurseServiceImpl;

public class App {

    public static void main(String[] args) throws IOException {
        BankDao bankDao = new BankDao("./file.xml");
        CurrencyDao currencyDao = new CurrencyDao("./currencyOperations.xml");
        if (args != null && args.length > 0 && "initData".equals(args[0])) {
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
         
            bankDao.saveBank(bank);
        }
        
        Thread thread = new Thread(new CurrencyOperationsUpdater(currencyDao));
        thread.start();
        
        
        Person person = new Person();
        person.setName("Andrei");
        boolean exit = false;
        
        System.out.println("Possible commands");
        System.out.println("accountList");
        System.out.println("exchangeOperationsList");       
        System.out.println("pursesList accountId");
        System.out.println("addAccount accountId");
        System.out.println("addPurse accountId purseName amount(Number) currency");
        System.out.println("exchange accountId fromPurseName toPurseName amount(Number)");
        while (exit != true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if ("accountList".equals(command)) {
                PersonServiceImpl personService = new PersonServiceImpl(bankDao);
                List<Account> accounts = personService.getPersonAccounts(person);
                for (Account account : accounts) {
                    System.out.println(account.getId());
                }
            } else if ("exchangeOperationsList".equals(command)){
                CurrencyPriceService currencyPriceService = new CurrencyPriceServiceImpl(currencyDao);
                List<CurrencyOperation> currencyOperations1 = currencyPriceService.listCurrencyOperations();
                for (CurrencyOperation currencyOperation : currencyOperations1) {
                    System.out.println(currencyOperation);
                }
            } else if (StringUtils.startsWith(command, "pursesList")) {
                AccountService accountService = new AccountServiceImpl(bankDao);
                String accountId = command.split(" ")[1];
                if (StringUtils.isNotEmpty(accountId)) {
                    Account account;
                    try {
                        account = accountService.getAccountById(accountId);
                        List<Purse> purses = account.getPurses();
                        if(purses != null){
                            for (Purse purse : purses) {
                                System.out.println(purse.toString());
                            }
                        } else {
                            System.out.println("Empty purses");
                        }
                    } catch (ServiceException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Missing accountId parameter");
                }
            } else if (StringUtils.startsWith(command, "addAccount")) {
                AccountService accountService = new AccountServiceImpl(
                        bankDao);
                String accountId = command.split(" ")[1];
                if (StringUtils.isNotEmpty(accountId)) {
                    List<Person> persons = new ArrayList<Person>();
                    persons.add(person);
                    Account account = new Account();
                    account.setId(accountId);
                    account.setPersons(persons);
                    try {
                        accountService.createAccount(account);
                        System.out.println(account + " added");
                    } catch (ServiceException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Missing accountId parameter");
                }
            } else if (StringUtils.startsWith(command, "addPurse")) { 
                PurseService purseService = new PurseServiceImpl(bankDao);
                String[] params = command.split(" ");
                String accountId = params[1];
                String purseName = params[2];
                String amount = params[3];
                String currency = params[4];
                if (StringUtils.isNotEmpty(accountId)
                        && StringUtils.isNotEmpty(purseName)
                        && StringUtils.isNotEmpty(amount)
                        && StringUtils.isNotEmpty(currency)) {
                    try {
                        Purse purse = new Purse();
                        purse.setName(purseName);
                        purse.setCurrency(currency);

                        purse.setAmount(Double.parseDouble(amount));
                        purseService.addPurse(accountId, purse);
                        System.out.println(purse + " added to " + accountId);
                    } catch (ServiceException e) {
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Invalid params. Please enter params in the following order: accountId, purseName, amount(Number), currency");
                }
            } else if (StringUtils.startsWith(command, "exchange")) { 
                ExchangeService exchangeService = new ExchangeServiceImpl(bankDao, currencyDao);
                String[] params = command.split(" ");
                String accountId = params[1];
                String fromPurseName = params[2];
                String toPurseName = params[3];
                String amount = params[4];
                if (StringUtils.isNotEmpty(accountId)
                        && StringUtils.isNotEmpty(fromPurseName)
                        && StringUtils.isNotEmpty(toPurseName)
                        && StringUtils.isNotEmpty(amount)) {
                    try {
                        exchangeService.exchange(accountId, fromPurseName, toPurseName, Double.parseDouble(amount));
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    } catch (ServiceException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Invalid params. Please enter params in the following order: accountId, fromPurseName, toPurseName, amount(Number)");
                }
                
            } else if ("exit".equals(command)) {
                scanner.close();
                exit = true;
            } else {
                System.out.println("Incorrect command");
                System.out.println("Possible commands");
                System.out.println("accountList");
                System.out.println("exchangeOperationsList");       
                System.out.println("pursesList accountId");
                System.out.println("addAccount accountId");
                System.out.println("addPurse accountId purseName amount(Number) currency");
                System.out.println("exchange accountId fromPurseName toPurseName amount(Number)");
            }
        }
    }

}
