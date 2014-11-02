package mentoring.application.services;

import mentoring.application.model.Purse;

public interface ExchangeService {
    
    void exchange(Purse fromPurse, Purse toPurse, long amount);
}
