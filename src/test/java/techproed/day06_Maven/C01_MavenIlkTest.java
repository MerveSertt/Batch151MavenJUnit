package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        https://www.amazon.com/ sayfasina gidelim
        arama kutusunu locate edelim
        “Samsung headphones” ile arama yapalim
        Bulunan sonuc sayisini yazdiralim
        Ilk urunu tiklayalim
        Sayfadaki tum basliklari yazdiralim

         */

        driver.get("https://www.amazon.com/");

        WebElement aramaKutusu = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));

        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner']) [1]"));

        String[] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("Sonuç Sayisi: " + sonucSayisi[2]);

        WebElement ilkUrun = driver.findElement(By.xpath("(//h2//a) [1]"));
        ilkUrun.click();

        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1 | //h2"));
        sayfaBasliklari.forEach(t-> System.out.println(t.getText())); //Lambda ile yazdırdık


    }
}
