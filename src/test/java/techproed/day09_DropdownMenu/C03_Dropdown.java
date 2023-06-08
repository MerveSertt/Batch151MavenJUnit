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

public class C03_Dropdown {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
        //programming languages ddm'den istediğiniz 4 seçeneği seçiniz.
        WebElement diller = driver.findElement(By.xpath("(//select)[6]"));
        Select select = new Select(diller);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        //sadece seçili olan option'ları yazdırmak istersek;
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));//Lambda ile yazdırdık

        System.out.println("*************** FOREACH ILE YAZDIR ****************");

        for (WebElement w: select.getAllSelectedOptions()) {
            System.out.println(w.getText());
        }

        //Seçeneklerden 4 tane seçtiğimizi doğrulayalım
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        //Seçtiğimiz seçeneklerden ilkini yazdıralım, ilk seçeneğin Java olduğunu doğrulayalım
        System.out.println("**********************************************");
        System.out.println("Seçilen seçeneklerden ilki : "+select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java",select.getFirstSelectedOption().getText());
        bekle(3);

        //Seçtiğimiz seçeneklerin hepsini kaldıralım
        select.deselectAll();

        //sendKeys() methodu ile istedigimiz bir secenegi gonderelim
        //diller.sendKeys("C#");

        //visibleText olarak secim yapacagimiz bir method olusturup programming languages ddm'den bir secenek secelim
        selectVisibleText(diller,"Java");
        bekle(2);

        //Index olarak secim yapacagimiz bir method olusturup programming languages ddm'den bir secenek secelim
        selectIndex(diller,2);
        bekle(2);

        //Value olarak secim yapacagimiz bir method olusturup programming languages ddm'den bir secenek secelim
        selectValue(diller,"js");
        bekle(2);

    }

    @After
    public void tearDown() throws Exception {
        bekle(3);
        driver.close();
    }

    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    public void selectIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
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

/*
                    ODEV-3
       1.http://zero.webappsecurity.com/ Adresine gidin
       2.Sign in butonuna basin
       3.Login kutusuna “username” yazin
       4.Password kutusuna “password.” yazin
       5.Sign in tusuna basin(not: navigate.Back yapınız)
       6.Pay Bills sayfasina gidin
       7.“Purchase Foreign Currency” tusuna basin
       8.“Currency” drop down menusunden Eurozone’u secin
       9.“amount” kutusuna bir sayi girin
       10.“US Dollars” in secilmedigini test edin
       11.“Selected currency” butonunu secin
       12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
       “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
 */
