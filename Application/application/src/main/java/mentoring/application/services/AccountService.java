package mentoring.application.services;

import java.io.IOException;

import mentoring.application.exception.ServiceException;
import mentoring.application.model.Account;

public interface AccountService {

    void createAccount(Account account) throws IOException, ServiceException;

    void updateAccount(Account account) throws IOException, ServiceException;

    Account getAccountById(String accountId) throws ServiceException;
}
