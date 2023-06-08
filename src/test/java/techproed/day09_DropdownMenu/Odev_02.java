package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Odev_02 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    /*
                    ODEV-2
           ●https://www.amazon.com/ adresine gidin.
            -Test 1
            Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
            oldugunu test edin
            -Test 2
            1.Kategori menusunden Books secenegini secin
            2.Arama kutusuna Java yazin ve aratin
            3.Bulunan sonuc sayisini yazdirin
            4.Sonucun Java kelimesini icerdigini test edin
 */

    @Test
    public void test1() {
        WebElement kategori = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(kategori);
        Assert.assertEquals(45,select.getOptions().size());
    }

    @Test
    public void test2() {
        WebElement kategori = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(kategori);
        select.selectByIndex(5);
        WebElement aramaButonu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaButonu.sendKeys("Java", Keys.ENTER);

        String sonucYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        String[] sonuclar = sonucYazisi.split(" ");
        System.out.println("Sonuç: "+ sonuclar[2]);

        Assert.assertEquals("Java",sonucYazisi);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
