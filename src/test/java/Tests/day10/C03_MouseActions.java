package Tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.util.Set;


public class C03_MouseActions extends TestBase {

/*
    1- Yeni bir class olusturalim: C03_MouseActions1
    2- https://the-internet.herokuapp.com/context_menu sitesine gidelim.
    3- Cizili alan uzerinde sag click yapalim.
    4- Alert’te cikan yazinin "You selected a context menu" oldugunu test edelim.
    5- Tamam diyerek alert’I kapatalim.
    6- Elemental Selenium linkine tiklayalim.
    7- Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim.
 */

    @Test
    public void test() {

        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();

        Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu", "Alert yazisi beklenenden farkli.");
        driver.switchTo().alert().accept();

        String firsPageHandle = driver.getWindowHandle();

        driver.findElement(By.linkText("Elemental Selenium")).click();

        Set <String> allWindowsHandles = driver.getWindowHandles();
        String secondPageHandle = "";

        for (String each: allWindowsHandles) {
            if (!each.equals(firsPageHandle)) {
                secondPageHandle = each;
            }
        }

        driver.switchTo().window(secondPageHandle);

        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), ("Elemental Selenium"), "Ikinci sayfadaki yazi istenenden farkli.");
    }
}
