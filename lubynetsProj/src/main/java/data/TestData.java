package data;

import libs.ConfigProvider;

public class TestData {
    public final static String LOGIN_DEFAULT = System.getProperty("defaultLogin", ConfigProvider.configHiddenProperties.login());
    public final static String PASSWORD_DEFAULT = "123456qwerty";
    public final static String LOGIN_INVALID = "invalidLogin";
    public final static String PASSWORD_INVALID = "invalidPassword";
    public final static String SHORT_USER_NAME = "tr";
    public final static String INVALID_EMAIL = "@inv@Email";
    public final static String PASSWORD_INVALID_SHORT = "1";
    public final static String LOGIN_DEFAULT1 = "qaauto";

    public final static String LOGIN_API_DEFAULT = "vladqaauto";
    public final static String PASSWORD_API_DEFAULT = "vladqaautovladqaauto";

}