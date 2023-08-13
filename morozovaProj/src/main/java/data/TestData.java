package data;

import libs.ConfigProperties;
import libs.ConfigProvider;

public class TestData {
    public final static String LOGIN_DEFAULT = System.getProperty("defaultLogin",ConfigProvider.configHiddenProperties.login()); //
    // "qaauto";
    public final static String LOGIN_INVALID = "qaauto1";
    public final static String PASSWORD_DEFAULT = "123456qwerty";
}
