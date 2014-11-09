package mentoring.application.services;

import java.io.IOException;
import java.util.List;

import mentoring.application.model.CurrencyOperation;

public interface CurrencyPriceService {
    
    List<CurrencyOperation> listCurrencyOperations();
    
    CurrencyOperation getOperation(String fromCurrency, String toCurrency);

    void updateCurrencyOperations(List<CurrencyOperation> currencyOperations) throws IOException;

}
