package data;

import libs.ConfigProvider;

public class TestData {
    public static final String LOGIN_DEFAULT = System.getProperty("defaultLogin", ConfigProvider.configHiddenProperties.login());//"qaauto";
    public static final String PASSWORD_DEFAULT = System.getProperty("defaultPassword", ConfigProvider.configHiddenProperties.password());

    public static final String LOGIN_API_DEFAULT = "tartarusr";
    public static final String PASSWORD_API_DEFAULT = "TarTar20232023";

}
