package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class WithAllureDemo {
    public static final String URL = "https://github.com";
    public static final String REPOSITORY = "Syrlic/guru_allure";
    public static final String NUMBER = "1";

    @BeforeAll
    public static void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "91.0");
//        RemoteWebDriver driver = new RemoteWebDriver(
//                URI.create("http://selenoid:4444/wd/hub").toURL(),
//                capabilities
//        );
        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";

    }

    @Test
    public void  testIssuePresentInRepoLambda(){
        step("Open URL", ()-> {
            open(URL);
        });
        step("Search for Repository", ()-> {
            $("input[name='q']").click();
            $("input[name='q']").sendKeys(REPOSITORY);
            $("input[name='q']").submit();
        });
        step("Step into Repository", (s)-> {
            s.parameter("repository", REPOSITORY);
            $(byAttribute("href", "/"+REPOSITORY)).click();
        });
        step("Switch to Issues tab", ()-> {
            $("span[data-content='Issues']").click();
        });
        step("Find issue"+ NUMBER, ()-> {
            $("#issue_1").shouldHave(Condition.text("#"+NUMBER));
            makeScreenshot();
        });
    }

    private void makeScreenshot(){
        InputStream stream = new ByteArrayInputStream(screenshot(OutputType.BYTES));
        Allure.attachment("attachment", stream);
    }
}
