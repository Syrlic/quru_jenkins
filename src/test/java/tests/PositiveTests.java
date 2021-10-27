package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("without_browser")
public class PositiveTests {

    @Test
    void test01(){
        assertTrue(true);
    }
    @Test
    void test02(){
        assertTrue(true);
    }
    @Test
    void test03(){
        assertTrue(true);
    }
}
