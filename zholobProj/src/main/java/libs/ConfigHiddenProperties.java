package libs;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:C:\\111TESTIROVCHIK\\TTR\\G7_TAF\\G7Project\\zholobProj\\src\\main\\resources\\hiddenConfig.properties")
public interface ConfigHiddenProperties extends Config {
    String login();
    String password();

}
