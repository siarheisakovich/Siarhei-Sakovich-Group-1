package mentoring.application.services;

import java.io.IOException;

import mentoring.application.model.Account;
import mentoring.application.model.Person;

public interface AccountService {

    void createAccount(Account account) throws IOException;
    
    void assignPerson(Account account, Person person) throws IOException;
}
