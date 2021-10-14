package Tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    // Amazon anasayfasina gidin ve "Nutella" icin arama yapin ve 9. ürüne tiklayin.

    @Test
    public void amazonTest() {

        driver.get("https://www.amazon.com/");

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Nutella" + Keys.ENTER);

        driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base a-text-normal'])[9]")).click();
    }
}

