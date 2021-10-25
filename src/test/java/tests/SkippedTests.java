package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
