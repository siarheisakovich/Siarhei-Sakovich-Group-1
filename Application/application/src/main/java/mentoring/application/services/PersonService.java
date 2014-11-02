package mentoring.application.services;

import java.util.List;

import mentoring.application.model.Account;
import mentoring.application.model.Person;

public interface PersonService {

    List<Account> getPersonAccounts(Person person);
    
}
