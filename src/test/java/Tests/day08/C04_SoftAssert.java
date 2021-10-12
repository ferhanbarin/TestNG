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

public class C04_SoftAssert {

    WebDriver driver;

/*
    Yeni bir Class Olusturun : D11_SoftAssert1
    1."https://www.hepsiburada.com/" Adresine gidin.
    2. Basliginin "Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin.
    3. Search kutusuna araba yazip arattirin.
    4. Bulunan sonuc sayisini yazdirin.
    5. Sonuc yazisinin "araba" icerdigini dogrulayin.
    6. Sonuc yazisinin "oto" kelimesi icermedigini dogrulayin.
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
    public void testHepsiBurada() {

        driver.get("https://www.hepsiburada.com/");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getTitle().contains("Türkiye'nin En Büyük Online Alışveriş Sitesi"), "Title istenen cümleyi icermiyor.");

        WebElement search = driver.findElement(By.className("desktopOldAutosuggestTheme-input"));
        search.sendKeys("Araba" + Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("//div[@class='category-suggestion-title']"));
        System.out.println(result.getText());

        softAssert.assertTrue(result.getText().contains("Araba"), "Sonuc yazisi 'Araba' icermiyor");
        softAssert.assertFalse(result.getText().contains("oto"), "Sonuc yazisi 'oto' iceriyor.");

        softAssert.assertAll();
    }
}
