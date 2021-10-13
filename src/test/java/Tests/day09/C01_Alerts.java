package Tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C01_Alerts {

    // Her Alert JS Allert degildir. Allert ciktiginda sag click yapip incele diyebiliyorsak bu bir HTML alert'dir.
    // HTML alert'ler siradan WebElement'ler olarak locate edilip kullanilabilir. Sag click yapamiyorsak alert bir JS Allert'dir ve switchTo() kullanilarak handle edilebilir.

    WebDriver driver;

/*
    ● Bir class olusturun: C01_Alerts
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir metod olusturun: acceptAlert
        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
    ● Bir metod olusturun: dismissAlert
        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
    ● Bir metod olusturun: sendKeysAlert
        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
 */

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public void tearDown() {

        driver.close();
    }

    @Test
    public void acceptAlert() {

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.findElement(By.id("result")).getText().equals("You successfully clicked an alert"));
    }

    @Test
    public void dismissAlert() {

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();

        Assert.assertFalse(driver.findElement(By.id("result")).getText().contains("result"));
    }

    @Test
    public void sendKeysAlert() {

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Ferhan");
        driver.switchTo().alert().accept();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.id("result")).getText().contains("Ferhan"));
        softAssert.assertAll();
    }
}
