package helper;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class TestBase {

    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    public static void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("browserName", config.browserName());
        capabilities.setCapability("browserVersion", config.browserVersion());

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        String formatURL = String.format("https://%s:%s@%s",
                config.login(), config.password(), config.urlSelenoid());
        System.out.println(formatURL);
        Configuration.remote = formatURL;

    }

//    @AfterEach
//    public void tearDown() {
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//        Attach.addVideo();
//    }
}
