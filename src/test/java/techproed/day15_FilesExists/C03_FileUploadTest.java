package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_FileUploadTest extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        String dosyaYolu = "C:/Users/merve/OneDrive/Masaüstü/sen.txt";
        //dosyaSeç butonuna basalim
         /*
        Eğer dosyaSeç butonuna basmamız istenirse ve otomasyon ile bu butona click yapmak istediğimizde
        exception alıyorsak direkt upload yapmak istediğimiz dosya yolunu alıp sendKeys methodu ile dosyayı
        sayfaya upload yapabiliriz.

         Eger upload ya da dosyaSec butonuna tikladiginizda windows penceresi aciliyorsa , o webelemente sendKeys() methodu
    ile dosya gonderemeyebilirsiniz. Boyle bir durumla karsilasirsaniz Romot class'indan obje ile methodlar kullanarak
    bunu asabilirsiniz
         */

        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
       // dosyaSec.click(); --> hata aldık click yapmadı

        //Yuklemek istediginiz dosyayi secelim.
        dosyaSec.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}
