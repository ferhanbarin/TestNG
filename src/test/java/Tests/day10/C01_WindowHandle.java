package Tests.day10;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle extends TestBase {

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

        // 1) windowHandle ederken ilk adim, 1 sayfa acikken o sayafanin handle degerini alip bir String'e atamak.
        String ilkSayfaHandle = driver.getWindowHandle();

        // Bu satirda 2. window acildi.
        driver.findElement(By.linkText("Click Here")).click();

        // 2) 2 sayfa acildiginda her iki sayfanin handle degerlerini koymak icin bir Set olusturup getWindowHandles method'u ile bu degerleri elde etmek.
        Set <String> tümWindowHandle = driver.getWindowHandles();

        // 3) Set icerisinde birinci sayfanin handle degerine esit olmayan handle degerini bulup bir String degiskene atamak.
        String ikinciWindowHandle = "";
        for (String each: tümWindowHandle) {
            if (!each.equals(ilkSayfaHandle)) {
                ikinciWindowHandle = each;
            }
        }
        // Bu satira geldigimizde elimizde 2. sayfanin handle degeri var olacak.

        driver.switchTo().window(ikinciWindowHandle);
        // switchTo() ile window degistireceksek gidecegimiz window'un window handle degerine ihtiyacimiz var.

        softAssert.assertTrue(driver.getTitle().equals("New Window"), "2. sayfanin title istenen degerden farkli.");

        softAssert.assertTrue(driver.findElement(By.tagName("h3")).getText().equals("New Window"));

        driver.switchTo().window(ilkSayfaHandle);

        softAssert.assertTrue(driver.getTitle().contains("The Internet"), "1. sayfanin title istenen degerden farkli.");

        softAssert.assertAll();
    }
}
