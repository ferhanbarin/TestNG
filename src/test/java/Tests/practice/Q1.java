package Tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Q1 {

    WebDriver driver;

/*
    Go to URL : http://demo.guru99.com/popup.php
    Get the first window.
    Clicking on click here button.
    Get all the window in the set.
    Switch to window.
    Input email id (somepne@gmail.com) and type something in that input.
    Clicking on the submit button.
    Verify title as expected.
    Switch to first window.
*/
    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void test() {

        driver.get("http://demo.guru99.com/popup.php");

        String firstPage = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();

        Set <String> allPage = driver.getWindowHandles();
        String secondPage = "";

        for (String each: allPage) {
            if (!each.equals(firstPage)) {
                secondPage = each;
            }
        }

        driver.switchTo().window(secondPage);

        WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
        email.sendKeys("somepne@gmail.com" + Keys.ENTER);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "This access is valid only for 20 days.", "Actual text does not equals expected text.");
        softAssert.assertAll();

        driver.switchTo().window(firstPage);
    }

}
