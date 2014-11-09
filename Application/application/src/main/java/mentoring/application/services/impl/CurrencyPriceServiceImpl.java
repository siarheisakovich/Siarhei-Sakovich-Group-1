package mentoring.application.services.impl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import mentoring.application.dao.CurrencyDao;
import mentoring.application.model.CurrencyOperation;
import mentoring.application.services.CurrencyPriceService;

public class CurrencyPriceServiceImpl implements CurrencyPriceService{

    private CurrencyDao currencyDao;
    
    public CurrencyPriceServiceImpl(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    @Override
    public List<CurrencyOperation> listCurrencyOperations() {
        return currencyDao.getCurrencyOperationsList();
    }

    @Override
    public CurrencyOperation getOperation(String fromCurrency, String toCurrency) {
        List<CurrencyOperation> currencyOperations = currencyDao.getCurrencyOperationsList();
        for (CurrencyOperation currencyOperation : currencyOperations) {
            if(StringUtils.equals(fromCurrency, currencyOperation.getFromCurrency()) && StringUtils.equals(toCurrency, currencyOperation.getToCurrency())){
                return currencyOperation;
            }
        }
        return null;
    }
    
    @Override
    public void updateCurrencyOperations(List<CurrencyOperation> currencyOperations) throws IOException {
        currencyDao.saveCurrencyOperations(currencyOperations);
    }
    
}
