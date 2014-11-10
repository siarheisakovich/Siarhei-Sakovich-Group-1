package mentoring.application.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import mentoring.application.model.CurrencyOperation;

import com.thoughtworks.xstream.XStream;

public class CurrencyDao {

    private static final XStream XSTREAM = Utils.getBankXStream();

    private File file;
    
    public CurrencyDao(String filePath) {
        file = new File(filePath);
    }
    public synchronized List<CurrencyOperation> getCurrencyOperationsList() {
        List<CurrencyOperation> currencyOperations = (List<CurrencyOperation>) XSTREAM.fromXML(file);
        return currencyOperations;
    }

    public synchronized void saveCurrencyOperations(List<CurrencyOperation> currencyOperations) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        XSTREAM.toXML(currencyOperations, fileWriter);
    }
}
