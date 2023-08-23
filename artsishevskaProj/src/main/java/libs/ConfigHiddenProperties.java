package libs;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:C:/ART_folder/WorkSpace/G7_TAF/G7Project/artsishevskaProj/src/main/resources/hiddenConfig.properties")
public interface ConfigHiddenProperties extends Config {
    String login();
    String password();

}
