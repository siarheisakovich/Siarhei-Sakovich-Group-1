package mentoring.application.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mentoring.application.TestUtils;
import mentoring.application.model.Bank;
import mentoring.application.model.CurrencyOperation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CurrencyDaoTest {

    private CurrencyDao currencyDao;
    
    @Before
    public void setup(){
        currencyDao = new CurrencyDao("./testCurrencyDao");
    }
    
    @Test
    public void saveReadDaoTest() throws IOException{
        List<CurrencyOperation> currencyOperations = new ArrayList<CurrencyOperation>();
        CurrencyOperation usdToRub = new CurrencyOperation();
        usdToRub.setFromCurrency("USD");
        usdToRub.setToCurrency("RUB");
        usdToRub.setCoefficent(40d);
        
        CurrencyOperation rubToUsd = new CurrencyOperation();
        rubToUsd.setFromCurrency("RUB");
        rubToUsd.setToCurrency("USD");
        rubToUsd.setCoefficent(1d/40d);
        currencyOperations.add(usdToRub);
        currencyOperations.add(rubToUsd);
        
        currencyDao.saveCurrencyOperations(currencyOperations);
        
        List<CurrencyOperation> savedCurrencyOperations = currencyDao.getCurrencyOperationsList();
        
        Assert.assertNotNull(savedCurrencyOperations);
        
        Assert.assertEquals(savedCurrencyOperations.get(0).getCoefficent(), usdToRub.getCoefficent(), 0.0001);
        Assert.assertEquals(savedCurrencyOperations.get(0).getFromCurrency(), usdToRub.getFromCurrency());
        Assert.assertEquals(savedCurrencyOperations.get(0).getToCurrency(), usdToRub.getToCurrency());
        
        Assert.assertEquals(savedCurrencyOperations.get(1).getCoefficent(), rubToUsd.getCoefficent(), 0.0001);
        Assert.assertEquals(savedCurrencyOperations.get(1).getFromCurrency(), rubToUsd.getFromCurrency());
        Assert.assertEquals(savedCurrencyOperations.get(1).getToCurrency(), rubToUsd.getToCurrency());
        
    }
}
