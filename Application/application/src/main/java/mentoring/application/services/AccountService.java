package mentoring.application.services;

import java.io.IOException;
import java.util.List;

import mentoring.application.model.Account;
import mentoring.application.model.Person;
import mentoring.application.model.Purse;

public interface AccountService {

    void createAccount(Account account) throws IOException;
    
    void assignPerson(Account account, Person person) throws IOException;
    
    List<Purse> getAccountPurses(String accountId);
}
