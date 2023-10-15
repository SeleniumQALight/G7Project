package data;

import libs.ConfigProperties;
import libs.ConfigProvider;

public class TestData {
    public final static String LOGIN_DEFAULT = System.getProperty("defaultLogin", ConfigProvider.configHiddenProperties.login());
    // "qaauto";
    public final static String LOGIN_INVALID = "qaauto1";
    public final static String PASSWORD_DEFAULT = "123456qwerty";

    public final static String LOGIN_API_DEFAULT = "marisun".toLowerCase();
    public final static String PASSWORD_API_DEFAULT = "123456789012";

    //Параметри для збереження курсів валют ПриватБанку
    public static String curs_buy_ui;
    public static String curs_sale_ui;

    public static String curs_buy_api;
    public static String curs_sale_api;
}
