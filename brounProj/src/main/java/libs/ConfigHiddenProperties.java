package libs;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:C:\\Java_Workspace\\G7_TAF_1\\G7Project\\brounProj\\src\\main\\resources\\hiddenConfig.properties")
public interface ConfigHiddenProperties extends Config {
    String login();
    String password();

}
