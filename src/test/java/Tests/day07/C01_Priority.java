package Tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_Priority {

    WebDriver driver;

/*
     3 test method'u olusturun.
     1- Amazon ana sayfasina,
     2- Ebay ana sayfasina,
     3- Facebook ana sayfasina gitsin.
     Ve sayfa title'larini yazdirin.
 */
    // Priority yazmadigimiz method'larin (priority = 0) kabul eder. Priority olmayanlari kendi icinde siralayip olanlarin priority degerlerine uygun siralamada calistirir.
    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }

    @Test (priority = 2)
    public void amazonTest() {

        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
    }

    @Test (priority = 3)
    public void ebayTest() {

        driver.get("https://www.ebay.com/");
        System.out.println(driver.getTitle());
    }

    @Test (priority = 1)
    public void facebookTest() {

        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
    }
}
