package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandles extends TestBase {
    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfa = driver.getWindowHandle();
        System.out.println("İlk Sayfa Handle Değeri: "+ilkSayfa);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click(); //--> Yeni sekme açıldı

        //Bir butona click yaptığımızda kontrolümüz dışında yeni bir sekme ya da pencere açılırsa (kontrol dışında açıldığı
        // için driver önceki pencerede kaldı onu da çekmek için bu yöntemi kullanıyoruz) direkt
        // yeni açılan pencerenin handle değerini bilmediği için normal getWindowHandle ile driver 'ımı
        // yeni pencereye geçiremem. Bunu getWindowHandles() methoduyla açılan tüm pencereleri bir Set'e assign edip
        // ilk açtığımız pencere değilse ikinci açılan yeni penceredir mantığıyla bir loop içinde çözebiliriz.

        Set<String> pencereler = driver.getWindowHandles();
        for (String w:pencereler) {
            System.out.println(w);
            if (!w.equals(ilkSayfa)){ //BF6F84F2FCAEEE887DECA9AEF0A5C051 ilk sayfa handle değeri
                driver.switchTo().window(w); //A0FC634978CC7920250DD6EFD5F5ABF3
            }
        }

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String actualTitleNewwindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewwindow);
        String ikinciSayfaHandle = driver.getWindowHandle();
        System.out.println("İkinci Sayfa Handle Değeri: " + ikinciSayfaHandle);

        /*
            getWindowHandles() methodunu kullanarak acilan tum pencerelerin handle degerlerini bir arraylist' e atadaik
        Index 0(sifir)'dan basladigi icin kontrolum disinda acilan pencere 1. index de oldugundan
         driver.switchTo().window(pencereler.get(1)); ile yeni acilan pencereye gecis yaptik
         */


        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfa);
        String ilkSayfaactualTitle = driver.getTitle();
        String ilkSayfaexpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaexpectedTitle,ilkSayfaactualTitle);


        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandle);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfa);


    }

    @Test
    public void test02() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click(); //--> Yeni sekme açıldı

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));


        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));
    }

    @Test
    public void test03() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
    /*
        getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
    Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
     driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
     */

        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        bekle(2);
    }

    @Test
    public void test04() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        switchToWindow(1);

    /*
    Set ve ArrayList kullanmadan switchTo().window() methodu içine argüman olarak driver.getWindowHandles()
    methodunu ile bütün açılan pencereli bir array olarak alıp index belirterek isteğim pencereye geçiş yapabilirim.
     */
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);
    /*
        getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
    Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
     driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
     */

        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        switchToWindow(0);
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle, ilkSayfaActualTitle);

        //  ikinci sayfaya tekrar geçin.
        switchToWindow(1);
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        switchToWindow(0);
        bekle(2);
    }


}
