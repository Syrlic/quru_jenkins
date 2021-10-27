package helper;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface CredentialsConfig extends Config {
    String login();
    String password();
    String URL();
    String repository();
    String urlSelenoid();
}
