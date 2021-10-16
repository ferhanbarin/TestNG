package Tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_WaitTest extends TestBase {

/*
    1. Bir class olusturun : C01_WaitTest
    2. Iki tane metod olusturun : implicitWait() , explicitWait()
    Iki metod icin de asagidaki adimlari test edin.
    3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    4. Remove butonuna basin.
    5. "It’s gone!" mesajinin goruntulendigini dogrulayin.
    6. Add buttonuna basin.
    7. It’s back mesajinin gorundugunu test edin.
*/

    @Test
    public void implicitlyWaitTest() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@type='button']")).click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());

        driver.findElement(By.xpath("//button[@type='button']")).click();
        softAssert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void explicitlyWaitTest() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@type='button']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        // ExplicitlyWait'i istersek locate islemi ile birlikte tek satirda yapabiliriz.
        WebElement yaziLocateIleBirlikte = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(yaziLocateIleBirlikte.isDisplayed());


        // Veya önce locate edip uygun method kullanarak beklemeyi yaptirabiliriz.
        // Ancak bu test icin önce WebElement'i olusturmak anlamsiz olur. Cünkü biz wait islemini zaten o WebElement olussun diye yapiyoruz.
        // Wait olmadan o element olmaz. O element olmadan da sectigimiz method calismaz.
        WebElement sonucYazisi = driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(sonucYazisi));
        Assert.assertTrue(sonucYazisi.isDisplayed());

        driver.findElement(By.xpath("//button[@type='button']")).click();
        WebElement itsBackLocateIle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsBackLocateIle.isDisplayed());
    }
}
