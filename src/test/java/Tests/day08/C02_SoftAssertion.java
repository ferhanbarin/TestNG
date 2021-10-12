package Tests.day08;

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

import java.util.concurrent.TimeUnit;

public class C02_SoftAssertion {

    WebDriver driver;

/*
       1- Amazon sayfasina gidin.
       2- URL'in "amazon" icerdigini test edin.
       3- Title'in "Amazon" icerdigini test edin.
       4- "Java" kelimesini aratin ve ilk listedeki ilk ürünün "Java" kelimesi icerdigini test edin.
       5- Testleri Soft Asssertion ile yapin.
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

        SoftAssert softAssert = new SoftAssert();

        driver.get("https://www.amazon.com/");

        softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"), "URL 'amazon' icermiyor.");
        softAssert.assertTrue(driver.getTitle().contains("Amazon"), "Title 'Amazon' icermiyor.");
        System.out.println("Assertion failed oldugu halde bu satir calisir.");

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("JAVA" + Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        softAssert.assertTrue(result.getText().contains("Java"), "Listeki ilk ürün 'Java' icermiyor.");

        softAssert.assertAll();

        // Soft Assertion'da assertAll'a kadar tüm satirlar calisir. Assertion'lar pass olsada, olmasa da asssertAll'a kadar tüm satirlar calisir.
        // Eger testlerden bir tanesi bile failed ise assertAll'dan sonra execution stops.

        System.out.println("Assertion failed oldugunda bu satir calismaz.");
    }
}
