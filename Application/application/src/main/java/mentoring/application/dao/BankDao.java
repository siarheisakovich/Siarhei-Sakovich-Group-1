package mentoring.application.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

import mentoring.application.model.Bank;

public class BankDao {

    private static final File FILE = new File("./file.xml");
    private static final XStream XSTREAM = Utils.getBankXStream();

    public Bank getBank() {
        Bank bank = (Bank) XSTREAM.fromXML(FILE);
        return bank;
    }

    public void saveBank(Bank bank) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE);
        XSTREAM.toXML(bank, fileWriter);
    }

    public void updateBank(Bank bank) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE);
        XSTREAM.toXML(bank, fileWriter);
    }

}
