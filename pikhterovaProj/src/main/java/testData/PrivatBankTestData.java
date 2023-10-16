package testData;

import bdd.helpers.privatbank.CourseTypeProvider;
import bdd.helpers.privatbank.CurrencyStorage;
import org.apache.log4j.Logger;

public class PrivatBankTestData {

    public static final Logger logger = Logger.getLogger(PrivatBankTestData.class);

    public static final CourseTypeProvider courseTypeProvider = new CourseTypeProvider();
    public static final CurrencyStorage currencyStorage = new CurrencyStorage();

}
