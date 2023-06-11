package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task01 {
    //- Before methodu ile drive'i olusturup ayarlamalari yapiniz
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        //- ebay sayfasına gidiniz
        driver.get("https://www.ebay.com");

        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//li[@class='hl-cat-nav__js-tab'])[1]")).click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        List<WebElement> resimler = driver.findElements(By.xpath("//img[@width='225'] | //img[@height='225']"));
        for (int i = 0; i < resimler.size(); i++) {
            resimler = driver.findElements(By.xpath("//img[@width='225'] | //img[@height='225']"));
            resimler.get(i).click();
            Thread.sleep(1500);
            driver.navigate().back();
            //- Her sayfanın sayfa başlığını yazdıralım
            System.out.println(driver.getTitle());
        }
    }

    @After
    public void tearDown() throws Exception {
        //- After methodu ile sayfayı kapatalım
        driver.close();
    }


}

