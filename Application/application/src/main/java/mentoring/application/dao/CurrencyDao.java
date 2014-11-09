package mentoring.application.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import mentoring.application.model.CurrencyOperation;

import com.thoughtworks.xstream.XStream;

public class CurrencyDao {

    private static final File FILE = new File("./currencyOperations.xml");
    private static final XStream XSTREAM = Utils.getBankXStream();

    public synchronized List<CurrencyOperation> getCurrencyOperationsList() {
        List<CurrencyOperation> currencyOperations = (List<CurrencyOperation>) XSTREAM.fromXML(FILE);
        return currencyOperations;
    }

    public synchronized void saveCurrencyOperations(List<CurrencyOperation> currencyOperations) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE);
        XSTREAM.toXML(currencyOperations, fileWriter);
    }
}
