package Tests.day09;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C04_WindowHandle extends TestBase {

/*
    ● Tests package’inda yeni bir class olusturun: C04_WindowHandle
    ● https://the-internet.herokuapp.com/windows adresine gidin.
    ● Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
    ● Sayfa başlığının (title) "The Internet" olduğunu doğrulayın.
    ● Click Here butonuna basın.
    ● Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
    ● Sayfadaki textin "New Window" olduğunu doğrulayın.
    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
 */

    @Test
    public void test() {

        driver.get("https://the-internet.herokuapp.com/windows");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.tagName("h3")).getText().equals("Opening a new window"), "Text istendigi gibi degil.");
        softAssert.assertTrue(driver.getTitle().contains("The Internet"), "1. sayfanin title istenen degerden farkli.");

        driver.switchTo().window("");

        driver.findElement(By.linkText("Click Here")).click();

        softAssert.assertTrue(driver.getTitle().equals("New Window"), "2. sayfanin title istenen degerden farkli.");










        softAssert.assertAll();



    }

}
