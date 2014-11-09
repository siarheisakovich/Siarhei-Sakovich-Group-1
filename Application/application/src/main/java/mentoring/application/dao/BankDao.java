package mentoring.application.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;

import mentoring.application.model.Bank;

public class BankDao {

    static final Logger logger = Logger.getLogger(BankDao.class);
    
    private static final File FILE = new File("./file.xml");
    private static final XStream XSTREAM = Utils.getBankXStream();

    public Bank getBank() {
        logger.debug("getBank");
        Bank bank = (Bank) XSTREAM.fromXML(FILE);
        return bank;
    }

    public void saveBank(Bank bank) throws IOException {
        logger.debug("saveBank");
        FileWriter fileWriter = new FileWriter(FILE);
        XSTREAM.toXML(bank, fileWriter);
        
    }

    public void updateBank(Bank bank) throws IOException {
        logger.debug("updateBank");
        FileWriter fileWriter = new FileWriter(FILE);
        XSTREAM.toXML(bank, fileWriter);
    }

}
