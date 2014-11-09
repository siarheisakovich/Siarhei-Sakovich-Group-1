package mentoring.application.services;

import java.io.IOException;
import java.util.List;

import mentoring.application.exception.ServiceException;
import mentoring.application.model.Account;
import mentoring.application.model.Person;
import mentoring.application.model.Purse;

public interface AccountService {

    void createAccount(Account account) throws IOException, ServiceException;

    void assignPerson(Account account, Person person) throws IOException,
            ServiceException;

    void updateAccount(Account account) throws IOException, ServiceException;

    Account getAccountById(String accountId) throws ServiceException;

    List<Purse> getAccountPurses(String accountId);
}
