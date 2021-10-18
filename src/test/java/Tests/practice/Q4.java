package Tests.practice;

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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Q4 {

    WebDriver driver;

/*
    Go to URL : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    Maximize the website.
    Click on second emoji.
    Click all second emoji's element.
    Go back parent iframe.
    Fill out the form. (Fill the form with the texts you want)
    Click on apply button.
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

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        driver.switchTo().frame(1);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        List <WebElement> allEmoojis = driver.findElements(By.xpath("//div[@id='nature']/div/img"));

        for (WebElement each: allEmoojis) {
            each.click();
        }

        driver.switchTo().defaultContent();

        WebElement text = driver.findElement(By.xpath("(//input[@class='mdl-textfield__input'])[1]"));

        Actions actions = new Actions(driver);

        actions.click(text)
                .sendKeys("Hello!").sendKeys(Keys.TAB)
                .sendKeys("Happy").sendKeys(Keys.TAB)
                .sendKeys("Autumn").sendKeys(Keys.TAB)
                .sendKeys("Pizza").sendKeys(Keys.TAB)
                .sendKeys("Coding").sendKeys(Keys.TAB)
                .sendKeys("Finland").sendKeys(Keys.TAB)
                .sendKeys("Keyboard").sendKeys(Keys.TAB)
                .sendKeys("Heart").sendKeys(Keys.TAB)
                .sendKeys("Blue Cross Flag").sendKeys(Keys.TAB)
                .sendKeys("Sad").sendKeys(Keys.TAB)
                .sendKeys("Smile").sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }
}
