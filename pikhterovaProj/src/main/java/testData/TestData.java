package testData;

import libs.ConfigProvider;

public class TestData {
    public final static String LOGIN_DEFAULT = System.getProperty("defaultLogin",ConfigProvider.configHiddenProperties.login());
    public final static String PASSWORD_DEFAULT = "123456qwerty";


    public final static String LOGIN_API_DEFAULT = "pyuliia";
    public final static String PASSWORD_API_DEFAULT = "PIHTERsmart365_";
}
