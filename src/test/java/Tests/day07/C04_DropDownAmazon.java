package Tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C04_DropDownAmazon {

    WebDriver driver;

/*
    ● Bir class oluşturun: C3_DropDownAmazon
    ● https://www.amazon.com/ adresine gidin.
    - Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin.
    -Test 2
    1. Kategori menusunden Books secenegini secin.
    2. Arama kutusuna Java yazin ve aratin.
    3. Bulunan sonuc sayisini yazdirin.
    4. Sonucun Java kelimesini icerdigini test edin.
 */

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public void tearDown() {

        driver.close();
    }

    @Test
    public void test1() {

        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        List <WebElement> category = select.getOptions();

        if (category.size() == 45) {
            System.out.println("Amazon kategori sayisi 45'dir.");
        } else {
            System.out.println("Amazon kategori sayisi 45 degildir.\nAmazon kategori sayisi : " + category.size());
        }
    }


    @Test
    public void test2() {

        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Books");

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("JAVA" + Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());

        Assert.assertTrue(result.getText().contains("JAVA"), "Sonuc 'JAVA' kelimesi icermiyor.");
    }
}
