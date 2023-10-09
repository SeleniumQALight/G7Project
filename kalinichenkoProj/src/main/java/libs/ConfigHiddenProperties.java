package libs;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:./src/main/resources/hiddenConfig.properties")
public interface ConfigHiddenProperties extends Config {
    String login();
    String password();
    String login_Api();
    String password_Api();
    String login_Api_book();
    String password_Api_book();


}
