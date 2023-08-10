package libs;

import org.aeonbits.owner.Config;

    @Config.Sources(value = "file:/Users/ivan-o/Desktop/WorkSpace/G7_TAF/G7Project/osipovProj/src/main/resources/hiddenConfig.properties")
    public interface ConfigHiddenProperties extends Config {
        String login();
        String password();

    }

