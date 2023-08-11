package pages;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends ActionsWithElements{
    String env = System.getProperty("env","aqa"); // зчитуємо змінну середовища
    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class); // створюємо об'єкт класу ConfigProperties з парами ключів і значень

 String BASE_URL; // final - це константа, яку не можна змінити

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        BASE_URL = configProperties.base_url().replace("[env]", env) ;// отримуємо значення з конфіга
    }

    public void openPage(String url) { // метод для відкриття сторінки
        try {
            webDriver.get(url);
            logger.info("Page was opened " + url);
        } catch (Exception e) {
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }

    abstract protected String getRelativeUrl(); //абстрактний метод, який буде реалізований в кожный пейджі

    //check Url
    // https://aqa-complexapp.onrender.com/== BASE_URL + "/" --> true
    protected void checkUrl(String relativeUrl) { //точне порівняння з поточним Url
                   Assert.assertEquals("Url is not expected", BASE_URL + relativeUrl, webDriver.getCurrentUrl());
        }

    protected void checkUrl() {
        checkUrl(getRelativeUrl());
    }

      //https://aqa-complexapp.onrender.com/post/64d21e84903640003414c338
    // regex for 64d21e84903640003414c338 - регулярні вирази
    // [0-9a-f]{24} - 24 символи, які можуть бути від 0 до 9 та від a до f
        // https://aqa-complexapp.onrender.com/post/[0-9a-fA-Z]
    protected void checkUrlWithPattern(String relativeUrl) { //порівняння з поточним Url за допомогою регулярних виразів
        Assert.assertTrue("Url is not expected \n"
                        + "Expected result: " + BASE_URL + relativeUrl + "\n"
                        + "Actual result: " + webDriver.getCurrentUrl()
                , webDriver.getCurrentUrl().matches(BASE_URL + relativeUrl));
    }
    protected void checkUrlWithPattern() {
        checkUrlWithPattern(getRelativeUrl());
    }
}
