package Tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Q5 {

    WebDriver driver;

    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void test1() {

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement oslo = driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement stockholm = driver.findElement(By.xpath("//div[@id='box2']"));
        WebElement washington = driver.findElement(By.xpath("//div[@id='box3']"));
        WebElement copenhagen = driver.findElement(By.xpath("//div[@id='box4']"));
        WebElement seoul = driver.findElement(By.xpath("//div[@id='box5']"));
        WebElement rome = driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement madrid = driver.findElement(By.xpath("//div[@id='box7']"));

        WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
        WebElement spain = driver.findElement(By.xpath("//div[@id='box107']"));
        WebElement norway = driver.findElement(By.xpath("//div[@id='box101']"));
        WebElement denmark = driver.findElement(By.xpath("//div[@id='box104']"));
        WebElement southKorea = driver.findElement(By.xpath("//div[@id='box105']"));
        WebElement sweden = driver.findElement(By.xpath("//div[@id='box102']"));
        WebElement unitedStates = driver.findElement(By.xpath("//div[@id='box103']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(oslo, norway)
                .dragAndDrop(stockholm, sweden)
                .dragAndDrop(washington, unitedStates)
                .dragAndDrop(copenhagen, denmark)
                .dragAndDrop(seoul, southKorea)
                .dragAndDrop(rome, italy)
                .dragAndDrop(madrid, spain).perform();

    }

    @Test
    public void test2() {

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        Actions actions = new Actions(driver);

        List <WebElement> myList = driver.findElements(By.xpath("//div[contains(@id, 'box')]"));

        for (int i=0; i<myList.size(); i++) {
            actions.dragAndDrop(myList.get(0), myList.get(9))
                    .dragAndDrop(myList.get(1), myList.get(12))
                    .dragAndDrop(myList.get(2), myList.get(13))
                    .dragAndDrop(myList.get(3), myList.get(10))
                    .dragAndDrop(myList.get(4), myList.get(11))
                    .dragAndDrop(myList.get(5), myList.get(7))
                    .dragAndDrop(myList.get(6), myList.get(8)).perform();

            break;
        }
    }
}
