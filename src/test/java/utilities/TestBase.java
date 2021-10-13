package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    // Abstract yaparak bu class'dan obje olusturulmasinin önüne geceriz.

    protected WebDriver driver;
    // Biz TestBase class'i sadece extends ile inherit ederek kullanacagiz. Dolayisiyla olusturdugumuz driver variable'i icin protected acces modifier seciyoruz.

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
}
