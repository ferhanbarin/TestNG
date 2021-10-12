package Tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_HardAssertion {

    WebDriver driver;

/*
        1- Amazon sayfasina gidin.
        2- URL'in "amazon" icerdigini test edin.
        3- Title'in "Amazon" icerdigini test edin.
        4- "Java" kelimesini aratin ve ilk listedeki ilk ürünün "Java" kelimesi icerdigini test edin.
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

        driver.close();
    }

    @Test
    public void amazonTest() {

        driver.get("https://www.amazon.com/");

        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        // Hard assert oldugu icin ilk failed olan assertion'da execution stops. Ancak buradaki hata düzelirse test calismaya devam eder.
        System.out.println("Assertion failed oldugunda bu satir calismaz.");

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("JAVA" + Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        Assert.assertTrue(result.getText().contains("Java"));
    }
}
