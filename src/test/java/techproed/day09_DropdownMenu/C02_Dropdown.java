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
import java.util.List;

public class C02_Dropdown {
    /*

                DROPDOWN --> Alt başlıkların olduğu açılır menü listesidir.
                Dropdown'u handle (automate) etmek için ;
                    1-Dropdown menüyü ilk olarak locate ederiz.
                    2-Select objesi oluştururuz.
                    3-Select objesinin dropdown menü web elementinin içeriğine ve seçeneklerine erişim sağlaması için
                    SELECT sınıfına argüman olarak locate ettiğimiz webelementi koyarız.
                    SYNTAX:
                            Select select = new Select(ddm webelementi)
                    4-Select class'ı sadece <select> tag'i ile oluşturulmuş dropdown menülere uygulanabilir.
                    5-Select objesi dropdown menüyü handle edebilmek için 3 method kullanır.
                        -selectByVisibleText() -> Dropdown menüdeki (ddm) elemente görünür metin ile ulaşmak için kullanılır.
                        -selectByIndex() -> index ile ulaşmak için kullanılır(index 0 'dan başlar.)
                        -selectByValue() -> Elementin değeri ile ulaşmak için kullanılır(option tag'larındaki değer(value) ile)
                    6-getOptions() -> Locate ettiğimiz ddm'deki tüm seçenekleri bize verir.(List'e atıp loop ile yazdırabiliriz.)
                    7-getFirstSelectedOption -> Dropdown menüdeki seçili kalan seçeneği bize verir. Birden fazla seçenek seçildiyse,
                    bu seçilenlerin ilkini verir.
                    8-dropdownmenu'ye sendKeys() methodu ile de dropdown menudeki seçeneklerden birini kullanarak gönderebiliriz.

     */

    /*
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */
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
        // 1.Method:
        //        a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("//select[@id='year']"));

        WebElement ay = driver.findElement(By.xpath("(//select)[3]"));

        WebElement gun = driver.findElement(By.xpath("(//select)[4]"));

        //        b. Select objesi olustur
        Select select = new Select(yil);

        //        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        select.selectByIndex(5);    //index 0'dan başlar 2018'i seçer.
        Select select1 = new Select(ay);
        select1.selectByValue("6");//July

        Select select2 = new Select(gun);
        select2.selectByVisibleText("15");
    }

    @Test
    public void test02() {
        //2.Method: Tüm eyalet isimlerini yazdıralım (Select ile)
        WebElement eyaletler = driver.findElement(By.xpath("(//select) [5]"));
        Select select = new Select(eyaletler);
        //select.getOptions().forEach(w-> System.out.println(w.getText()));
        //getOptions() ile tüm seçenekleri yazdırdık.

        List<WebElement> eyaletlerList = select.getOptions();
        for (WebElement w: eyaletlerList) {
            System.out.println(w.getText());
        }

        //2.Yol
       // System.out.println("**************FINDELEMENTS İLE*****************");
       // List<WebElement> eyaletlerr = driver.findElements(By.xpath("(//select) [5]"));
       // eyaletlerr.forEach(w-> System.out.println(w.getText()));

    }

    @Test
    public void test03() {
    //a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletler = driver.findElement(By.xpath("(//select) [5]"));
        Select select = new Select(eyaletler);
        String seciliOlanSecenek = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",seciliOlanSecenek);
        Assert.assertTrue(seciliOlanSecenek.equals("Select a State"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
