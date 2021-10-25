package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class WithAllureDemo {
    public static final String URL = "https://github.com";
    public static final String REPOSITORY = "Syrlic/guru_allure";
    public static final String NUMBER = "1";

    @BeforeAll
    public static void setup(){
        Configuration.startMaximized = true;
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
