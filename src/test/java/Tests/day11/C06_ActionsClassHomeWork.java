package Tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class C06_ActionsClassHomeWork {

    WebDriver driver;

/*
    Yeni Class olusturun ActionsClassHomeWork
    1- "http://webdriveruniversity.com/Actions" sayfasina gidin.
    2- "Hover over Me First" kutusunun üstune gelin.
    3- Link 1" e tiklayin.
    4- Popup mesajini yazdirin.
    5- Popup'i tamam diyerek kapatin.
    6- "Click and hold" kutusuna basili tutun.
    7- "Click and hold" kutusunda cikan yaziyi yazdirin.
    8- "Double click me" butonunu cift tiklayin.
*/

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {

        driver.close();
    }

    @Test
    public void test() {

        driver.get("http://webdriveruniversity.com/Actions");

        Actions actions = new Actions(driver);

        WebElement hoverOverMeFirst = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        WebElement link1 = driver.findElement(By.xpath("(//a[@href='#'])[1]"));

        actions.moveToElement(hoverOverMeFirst).perform();
        link1.click();

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement clickHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickHold).perform();

        System.out.println(driver.findElement(By.xpath("//div[@style='background: rgb(0, 255, 0); font-size: 30px;']")).getText());

        WebElement doubleClickMe = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickMe).perform();
    }
}
