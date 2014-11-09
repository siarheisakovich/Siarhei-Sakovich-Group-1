package mentoring.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import mentoring.application.dao.CurrencyDao;
import mentoring.application.model.CurrencyOperation;

public class CurrencyOperationsUpdater implements Runnable{

    static final Logger logger = Logger.getLogger(CurrencyOperationsUpdater.class);
    
    private CurrencyDao currencyDao;
    
    public CurrencyOperationsUpdater(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }
    
    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            double coef = random.nextDouble();
            double rub = 40d + coef * 5d;
            List<CurrencyOperation> currencyOperations = new ArrayList<CurrencyOperation>();
            CurrencyOperation usdToRub = new CurrencyOperation();
            usdToRub.setFromCurrency("USD");
            usdToRub.setToCurrency("RUB");
            usdToRub.setCoefficent(rub);
            
            CurrencyOperation rubToUsd = new CurrencyOperation();
            rubToUsd.setFromCurrency("RUB");
            rubToUsd.setToCurrency("USD");
            rubToUsd.setCoefficent(1d/rub);
            currencyOperations.add(rubToUsd);
            currencyOperations.add(usdToRub);
            try {
                currencyDao.saveCurrencyOperations(currencyOperations);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

}
