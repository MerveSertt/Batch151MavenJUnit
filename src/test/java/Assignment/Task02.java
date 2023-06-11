package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {
    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
   static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() throws Exception {
        //Before methodunda http://www.google.com adresine gidin
        driver.get("http://www.google.com");
    }

    //Üç farklı test methodu ile;


    @Test
    public void test01() {
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("The God Father", Keys.ENTER);
        WebElement fatherSonuc = driver.findElement(By.xpath("//body[@id='gsr']"));
        String[] sonucSayisiFather = fatherSonuc.getText().split(" ");
        System.out.println("The God Father Çıkan Sonuç Sayısı" + sonucSayisiFather[1]);

    }

    @Test
    public void test02() {
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Lord of the Rings", Keys.ENTER);
        driver.navigate().refresh();
        WebElement lordSonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String[] lordSonucSayisi = lordSonuc.getText().split(" ");
        System.out.println("Lord of the Ring Çıkan Sonuç Sayısı: " + lordSonucSayisi[1]);
    }

    @Test
    public void test03() {
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Kill Bill", Keys.ENTER);
        driver.navigate().refresh();
        WebElement killBillSonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String[] killBillSonucSayisi = killBillSonuc.getText().split(" ");
        System.out.println("Kill Bill Çıkan Sonuç Sayısı: " + killBillSonucSayisi[1]);
    }

    //After method'u ile başlıkları yazdırınız

   @After
   public void tearDown() throws Exception {
       System.out.println(driver.getTitle());
   }

   //AfterClass ile browser'ı kapatınız
   @AfterClass
   public static void afterClass() throws Exception {
       driver.close();
    }

}
