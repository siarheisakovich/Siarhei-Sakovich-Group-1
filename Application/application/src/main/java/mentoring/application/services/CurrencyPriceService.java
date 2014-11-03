package mentoring.application.services;

import java.util.List;

import mentoring.application.model.CurrencyOperation;

public interface CurrencyPriceService {
    
    List<CurrencyOperation> listCurrencyOperations();
    
    //TODO
    float getOperation();

}
