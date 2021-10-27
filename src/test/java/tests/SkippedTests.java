package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@Tag("without_browser")
public class SkippedTests {
    @Test
    @Disabled
    void test01(){
        assertTrue(true);
    }

    @Test
    @Disabled
    void test02(){
        assertTrue(true);
    }

    @Test
    @Disabled
    void test03(){
        assertTrue(true);
    }
}
