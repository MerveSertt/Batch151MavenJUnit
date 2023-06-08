package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Odev_01 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    /*
                    ODEV-1
         ●https://the-internet.herokuapp.com/dropdown adresine gidin.
        1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        4.Tüm dropdown değerleri(value) yazdırın
        5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        False yazdırın.
 */

    @Test
    public void test01() {
        WebElement secenekler = driver.findElement(By.xpath("//select"));
        Select select = new Select(secenekler);
        select.selectByIndex(1);
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));


        select.selectByValue("2");
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));



        select.selectByVisibleText("Option 1");
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));

        select.getOptions().forEach(w-> System.out.println(w.getText()));

        Assert.assertEquals(4,select.getOptions().size());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
