package mentoring.application.services;

import java.io.IOException;

import mentoring.application.exception.ServiceException;
import mentoring.application.model.ExchangeResult;

public interface ExchangeService {
    
    ExchangeResult exchange(String accountId, String fromPurseName, String toPurseName, double amount) throws ServiceException, IOException;
}
