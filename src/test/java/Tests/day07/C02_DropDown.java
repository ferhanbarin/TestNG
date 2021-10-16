package Tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {

    WebDriver driver;

/*
    Bir class oluşturun: DropDown
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    1. Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
    2. Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın.
    3. Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
    4. Tüm dropdown değerleri(value) yazdırın.
    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
*/
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

    @Test
    public void test() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(2000);

        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.

        // 1. adim dropDown'i locate et.
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        // 2. adim Select Class'ini kullanarak bir obje olustur ve parametre olarak locate ettigimiz WebElement'i yaz.
        Select select = new Select(dropDown);
        // Istedigin Option'i kullanarak Select objesi kullanarak sec.
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın.

        Thread.sleep(2000);
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.

        Thread.sleep(2000);
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // 4.Tüm dropdown değerleri(value) yazdırın.

        List <WebElement> tümOpsiyonlar = select.getOptions();
        System.out.println("Tüm Opsiyonlar Listesi");

        tümOpsiyonlar.stream().forEach(t-> System.out.println(t.getText()));

        for (WebElement each: tümOpsiyonlar) {
            System.out.println(each.getText());
        }

        // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

        System.out.println(tümOpsiyonlar.size());

        if (tümOpsiyonlar.size() == 4) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
