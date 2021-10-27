package Tests.practice;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public class Q6 {

    // "http://automationpractice.com/" adresine gidiniz ve üye olunuz.

    WebDriver driver;

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void test() {

        driver.get("http://automationpractice.com/");

        Faker faker = new Faker();
        Actions actions = new Actions(driver);

        driver.findElement(By.partialLinkText("Sign in")).click();
        WebElement emailCreate = driver.findElement(By.id("email_create"));
        emailCreate.sendKeys(faker.internet().emailAddress() + Keys.ENTER);

        WebElement title = driver.findElement(By.xpath("//label[@for='id_gender1']"));
        actions.click(title).sendKeys(Keys.TAB)
                .sendKeys(faker.name().name()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1, 31))).sendKeys(Keys.TAB)
                .sendKeys("Februaray").sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1960, 2002))).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.name().name()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(faker.company().name()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(10000, 99999))).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        WebElement myAccount = driver.findElement(By.className("info-account"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myAccount.isDisplayed(), "Kayit yapilamadi.");
        softAssert.assertAll();
    }
}
