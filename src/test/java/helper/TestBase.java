package helper;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
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
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "91.0");

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        String formatURL = String.format("https://$s:$s@selenoid.autotests.cloud/wd/hub/",
                config.login(), config.password());
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
