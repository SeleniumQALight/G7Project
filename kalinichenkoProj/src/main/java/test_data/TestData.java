package test_data;

import libs.ConfigHiddenProperties;
import libs.ConfigProvider;

public class TestData {
    public final static String LOGIN_DEFAULT = System.getProperty("default login" ,ConfigProvider.configHiddenProperties.login());
    public final static String PASSWORD_DEFAULT = System.getProperty("default password", ConfigProvider.configHiddenProperties.password());

    public final static String LOGIN_INVALID = "qaauto1";

    public final static String PASSWORD_INVALID = "123456qwer";
}
