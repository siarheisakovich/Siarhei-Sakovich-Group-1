package mentoring.application.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mentoring.application.dao.BankDao;
import mentoring.application.dao.CurrencyDao;
import mentoring.application.exception.ServiceException;
import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.CurrencyOperation;
import mentoring.application.services.impl.AccountServiceImpl;
import mentoring.application.services.impl.CurrencyPriceServiceImpl;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyPriceServiceTest {

    @Mock CurrencyDao currencyDao;
    
    List<CurrencyOperation> currencyOperations;
    
    @Before
    public void init(){
        currencyOperations = new ArrayList<CurrencyOperation>();
        CurrencyOperation usdToRub = new CurrencyOperation();
        usdToRub.setFromCurrency("USD");
        usdToRub.setToCurrency("RUB");
        usdToRub.setCoefficent(40d);
        
        CurrencyOperation rubToUsd = new CurrencyOperation();
        rubToUsd.setFromCurrency("RUB");
        rubToUsd.setToCurrency("USD");
        rubToUsd.setCoefficent(1d/40d);
        currencyOperations.add(rubToUsd);
        currencyOperations.add(usdToRub);
        
        when(currencyDao.getCurrencyOperationsList()).thenReturn(currencyOperations);
    }
    
    @Test
    public void listCurrencyOperationsTest() {
        CurrencyPriceService accountService = new CurrencyPriceServiceImpl(currencyDao);
        Assert.assertArrayEquals(currencyOperations.toArray(), accountService.listCurrencyOperations().toArray());
    }
    
    @Test
    public void getOperationTest() {
        CurrencyPriceService accountService = new CurrencyPriceServiceImpl(currencyDao);
        CurrencyOperation currencyOperation = accountService.getOperation("USD", "RUB");
        Assert.assertEquals(currencyOperation.getFromCurrency(), "USD");
        Assert.assertEquals(currencyOperation.getToCurrency(), "RUB");
    }
    
    @Test
    public void updateOperationListTest() throws IOException {
        CurrencyPriceService accountService = new CurrencyPriceServiceImpl(currencyDao);
        currencyOperations.add(new CurrencyOperation());
        accountService.updateCurrencyOperations(currencyOperations);
        Assert.assertArrayEquals(currencyOperations.toArray(), accountService.listCurrencyOperations().toArray());
    }
}
