package Tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_IframeTest {

    WebDriver driver;

/*
    ● Bir class olusturun: C02_IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
    ○ Text Box’a “Merhaba Dunya!” yazin.
    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
 */

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @AfterClass
    public void tearDown() {

        driver.close();
    }

    @Test
    public void iframeTest() {

        WebElement baslikYaziElement = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(baslikYaziElement.isEnabled(), "Baslik yazisi erisilebilir degil.");
        System.out.println("'An IFrame containing' texti erisilebilir.");

        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));

        textBox.clear();
        textBox.sendKeys("Merhaba Dünya!");

        // Bir iFrame'e gecis yaptiktan sonra yeniden ana sayfa ile ilgili islem yapmak isterseniz, gecis yaptigimiz iFrame'den geri dönmeliyiz.

        driver.switchTo().defaultContent(); // iFrame kapatmak icin kullanilir.

        WebElement text = driver.findElement(By.linkText("Elemental Selenium"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(text.isDisplayed());
        softAssert.assertAll();

        System.out.println(text.getText());
    }
}
