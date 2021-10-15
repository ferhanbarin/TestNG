package Tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_KeyboardActions extends TestBase {

/*
    1- Bir Class olusturalim D14_KeyboardActions2
    2- https://html.com/tags/iframe/ sayfasina gidelim.
    3- Video’yu gorecek kadar asagi inin.
    4- Videoyu izlemek icin Play tusuna basin.
    5- Videoyu calistirdiginizi test edin.
*/

    @Test
    public void test() {

        driver.get("https://html.com/tags/iframe/");

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform(); // Videoyu görecek kadar asagi in.

        WebElement iFrame = driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(iFrame);
        WebElement play = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        actions.click(play).perform();


        // Videonun calistigini test edelim.

        Assert.assertFalse(play.isDisplayed());
    }
}
