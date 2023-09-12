package data;

import libs.ConfigProvider;

public class TestData {
    public final static String LOGIN_DEFOULT = System.getProperty("defoltLogin", ConfigProvider.configHiddenProperties.login());
    public final static String PASSWORD_DEFOULT = "123456qwerty";
    public final static String LOGIN_invalid = "daria";
    public final static String PASSWORD_invalid = "123456qwert";

    public final static String USER_NAME_API = "dariak".toLowerCase();
    public final static String PASSWORD_API = "123456qwerty";
}
