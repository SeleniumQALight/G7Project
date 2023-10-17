package data;

import libs.ConfigProvider;

public class TestData {
    public final static String LOGIN_DEFAULT =System.getProperty("defaultLogin",ConfigProvider.configHiddenProperties.login());
    public final static String PASSWORD_DEFAULT = "123456qwerty";
    public final static String LOGIN_API_DEFAULT = "mart".toLowerCase();
    public final static String PASSWORD_API_DEFAULT = "123456qazwsx";
    public static String rateBuyAPI;
    public static String rateSaleAPI;
    public static String rateBuyUI;
    public static String rateSaleUI;

}
