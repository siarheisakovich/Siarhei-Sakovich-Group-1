package mentoring.application.services;

import java.io.IOException;
import java.util.List;

import mentoring.application.exception.ServiceException;
import mentoring.application.model.Account;
import mentoring.application.model.Purse;

public interface PurseService {
    
    List<Purse> getAllPurses(String accountId);
    
    void addPurse(String accountId, Purse purse) throws IOException, ServiceException;
    
    void removePurse(Account account, Purse purse) throws IOException;
}
