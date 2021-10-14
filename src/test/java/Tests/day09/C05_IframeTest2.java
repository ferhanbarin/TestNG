package Tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
    - Bir class olusturun: IframeTest02
    1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz.
    2) Sayfadaki iframe sayısını bulunuz.
    3) Ilk iframe'deki (Youtube) play butonuna tıklayınız.
    4) Ilk iframe'den çıkıp ana sayfaya dönünüz.
    5) Ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live seleniumproject.html) tıklayınız.
 */

public class C05_IframeTest2 {

    WebDriver driver;

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {

        driver.close();
    }

    @Test
    public void test() {

        driver.get("http://demo.guru99.com/test/guru99home/");

        List <WebElement> iFrame = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayisi : " + iFrame.size());

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
    }
}
