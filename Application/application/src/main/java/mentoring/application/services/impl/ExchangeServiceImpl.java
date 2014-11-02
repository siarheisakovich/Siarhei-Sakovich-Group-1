package mentoring.application.services.impl;

import mentoring.application.dao.BankDao;
import mentoring.application.model.Bank;
import mentoring.application.model.Purse;
import mentoring.application.services.ExchangeService;

public class ExchangeServiceImpl implements ExchangeService{

    private BankDao bankDao; 
    
    public ExchangeServiceImpl(BankDao bankDao) {
        this.bankDao = bankDao;
    }
    
    @Override
    public void exchange(Purse fromPurse, Purse toPurse, long amount) {
        Bank bank = bankDao.getBank();
    }

}
