package data;

import libs.ConfigProvider;
import libs.Util;


public class TestData {
    public final static String LOGIN_DEFAULT = System.getProperty("defaultLogin", ConfigProvider.configHiddenProperties.login());
    public final static String PASSWORD_DEFAULT = "123456qwerty";
    public final static String LOGIN_INVALID = "123456qwerty";
    public final static String PASSWORD_INVALID = "qaauto";
    public final static String POST_TITLE = "TC01 - New Post Ivan" + Util.getDateAndTimeFormatted();
    public final static String POST_BODY = "Body Of New Post Ivan";
    public final static String CHECK_CHECKBOX = "check";
    public final static String UNCHECK_CHECKBOX = "uncheck";

    public final static String LOGIN_API_DEFAULT = "testg7o";
    public final static String PASSWORD_API_DEFAULT = "123456qwerty";

    public final static String LOGIN_DEMOQA_API_DEFAULT = "test-g7-o";
    public final static String PASSWORD_DEMOQA_API_DEFAULT = "!23456qwertY";

    public static Double[] apiCurrencyBuySaleRates = new Double[10];
    public static Double[] uiCurrencyBuySaleRates = new Double[10];
}
