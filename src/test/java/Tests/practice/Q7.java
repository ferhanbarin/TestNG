package Tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Q7 extends TestBase {

/*
    1) "http://automationpractice.com/" adresine gidin.
    2) 2. URUNUN UZERiNE GELiP Add to chart YAPIN.
    3) 4. URUNUN UZERiNE GELiP Add to chart YAPIN.
    4) 5. URUNUN UZERiNE GELiP Add to chart YAPIN.
    5) CHART a gelin 3 ürün olduğunu doğrulayın.
    6) CHART'A GELiP Chek out TIKLAYIN.
    7) Toplam alışveriş miktarının 108.97 olduğunu doğrula.
*/

    @Test
    public void test() {

        driver.get("http://automationpractice.com/");

        Actions actions = new Actions(driver);

        WebElement birinciUrun = driver.findElement(By.xpath("(//img[@title='Blouse'])[1]"));
        actions.moveToElement(birinciUrun).perform();
        driver.findElement(By.xpath("(//a[@title='Add to cart'])[2]")).click();
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();

        WebElement dorduncuUrun = driver.findElement(By.xpath("(//img[@title='Printed Dress'])[2]"));
        actions.moveToElement(dorduncuUrun).perform();
        driver.findElement(By.xpath("(//a[@title='Add to cart'])[4]")).click();
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();

        WebElement besinciUrun = driver.findElement(By.xpath("(//img[@title='Printed Summer Dress'])[1]"));
        actions.moveToElement(besinciUrun).perform();
        driver.findElement(By.xpath("(//a[@title='Add to cart'])[5]")).click();
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();

        WebElement cart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        actions.moveToElement(cart).perform();
        WebElement total = driver.findElement(By.xpath("(//span[text()='$108.97'])[1]"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(total.isDisplayed(), "Toplam alişveriş miktari 108.97 degil.");
        softAssert.assertAll();
    }
}
