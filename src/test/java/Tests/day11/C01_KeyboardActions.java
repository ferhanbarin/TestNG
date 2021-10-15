package Tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {

/*
    1- Bir Class olusturalim C01_KeyboardActions
    2- https://www.amazon.com sayfasina gidelim.
    3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin.
    4- Aramanin gerceklestigini test edin.
*/

    @Test
    public void amazonTest() {

        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions = new Actions(driver);

        actions.click(searchBox).perform();
        actions.sendKeys("Samsung ").perform();
        actions.keyDown(Keys.SHIFT).perform();
        actions.sendKeys("A").perform();
        actions.keyUp(Keys.SHIFT).perform();
        actions.sendKeys("71").perform();
        actions.sendKeys(Keys.ENTER).perform();


        // Simdiye kadar önce locate edip o WebElement üzerinden sendKeys yapiyorduk.
        // searchBox.sendKeys("Samsung A71");

        actions.click(searchBox).perform();
        actions.sendKeys("Samsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("A")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();

        // Aramanin gerceklestigini test edelim.

        Assert.assertTrue(driver.getTitle().contains("Samsung A71"));
    }
}
