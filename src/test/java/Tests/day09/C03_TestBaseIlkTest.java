package Tests.day09;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBaseIlkTest extends TestBase {

    @Test
    public void test() {

        driver.get("https://www.amazon.com/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }
}
