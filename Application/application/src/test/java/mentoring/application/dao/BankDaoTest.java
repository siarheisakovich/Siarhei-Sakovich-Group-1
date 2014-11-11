package mentoring.application.dao;

import java.io.IOException;

import mentoring.application.TestUtils;
import mentoring.application.model.Bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankDaoTest {

    private BankDao bankDao;
    
    @Before
    public void setup(){
        bankDao = new BankDao("./testDao");
    }
    
    @Test
    public void saveReadDaoTest() throws IOException{
        Bank bank = TestUtils.createBankModel();
        bankDao.saveBank(bank);
        Bank savedBank = bankDao.getBank();
        Assert.assertNotNull(savedBank);
        Assert.assertEquals(bank.getAccounts().get(0).getId(), savedBank.getAccounts().get(0).getId());
        Assert.assertEquals(bank.getAccounts().get(0).getPersons().get(0)
                .getName(), savedBank.getAccounts().get(0).getPersons().get(0)
                .getName());
        Assert.assertEquals(bank.getAccounts().get(0).getPurses().get(0)
                .getName(), savedBank.getAccounts().get(0).getPurses().get(0)
                .getName());
    }
}
