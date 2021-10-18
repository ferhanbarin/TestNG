package Tests.practice;

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

public class Q3 {

    WebDriver driver;

/*
     Go to http://demo.guru99.com/test/drag_drop.html URL.
     Drag and drop the BANK button to the Account section in DEBIT SIDE.
     Drag and drop the SALES button to the Account section in CREDIT SIDE.
     Drag and drop the 5000 button to the Amount section in DEBIT SIDE.
     Drag and drop the second 5000 button to the Amount section in CREDIT SIDE.
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

        driver.quit();
    }

    @Test
    public void test() {

        driver.get("http://demo.guru99.com/test/drag_drop.html");

        Actions actions = new Actions(driver);

        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement sales = driver.findElement(By.id("credit1"));
        WebElement num5000 = driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement numsecond5000 = driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));

        WebElement debitAccount = driver.findElement(By.xpath("//ol[@id='bank']"));
        WebElement debitAmount = driver.findElement(By.xpath("//ol[@id='amt7']"));

        WebElement creditAccount = driver.findElement(By.xpath("//ol[@id='loan']"));
        WebElement creditAmount = driver.findElement(By.xpath("//ol[@id='amt8']"));

        actions.dragAndDrop(bank, debitAccount).perform();
        actions.dragAndDrop(sales, creditAccount).perform();
        actions.dragAndDrop(num5000, debitAmount).perform();
        actions.dragAndDrop(numsecond5000, creditAmount).perform();

        System.out.println(driver.findElement(By.linkText("Perfect!")).getText());
    }

}
