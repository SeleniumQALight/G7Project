package data;

import libs.ConfigProvider;

public class TestData {
    public final static String LOGIN_DEFAULT = System.getProperty("defaultLogin", ConfigProvider.configHiddenProperties.login());
    public final static String PASSWORD_DEFAULT = "123456qwerty";

    public final static String LOGIN_INVALID = "qaauto1";
    public final static String PASSWORD_INVALID = "testtesttetesttesttetesttesttetesttesttetesttesttet";
    public final static String ERROR_MESSAGE = "Invalid username / pasword";

}
