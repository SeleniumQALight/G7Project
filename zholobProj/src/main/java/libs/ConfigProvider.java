package libs;

import org.aeonbits.owner.ConfigFactory;



public class ConfigProvider {
    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    //створюємо об'єкт класу ConfigProperties з парами ключів і значень
    public static ConfigHiddenProperties configHiddenProperties = ConfigFactory.create(ConfigHiddenProperties.class);
    //створюємо об'єкт класу ConfigHiddenProperties з парами ключів і значень
}