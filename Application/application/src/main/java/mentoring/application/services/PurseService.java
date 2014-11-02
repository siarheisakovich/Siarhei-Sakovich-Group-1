package mentoring.application.services;

import java.io.IOException;
import java.util.List;

import mentoring.application.model.Account;
import mentoring.application.model.Purse;

public interface PurseService {
    
    List<Purse> getAllPurses(Account account);
    
    void addPurse(Account account, Purse purse) throws IOException;
    
    void removePurse(Account account, Purse purse) throws IOException;
}
