package mentoring.application.dao;

import mentoring.application.model.Account;
import mentoring.application.model.Bank;
import mentoring.application.model.Person;
import mentoring.application.model.Purse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Utils {

    public static XStream getBankXStream(){
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("person", Person.class);
        xstream.alias("bank", Bank.class);
        xstream.alias("account", Account.class);
        xstream.alias("purse", Purse.class);
        return xstream;
    }
}
