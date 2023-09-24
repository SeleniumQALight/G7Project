package dataDemoQA;

import libs.ConfigProvider;

public class TestDataDemoQA {
    public final static String LOGIN_DEFAULT = "KNtest";
    public final static String PASSWORD_DEFAULT = System.getProperty("defaultPassword", ConfigProvider.configHiddenProperties.password());

}
