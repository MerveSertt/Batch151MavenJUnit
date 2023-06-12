package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C02_Alerts extends TestBase {

    @Test
    public void acceptAlert() {
        /*
        Eğer bir sayfadaki bir butona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan pencereye
        sağ tık yapıp locate alamıyorsak, bu bir Java Script Alert(js Alert)tür.
        js Alert'ü handle edebilmek için driver'ımızı o pencereye geçirmemiz gerekir. Bunun için;
        driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js Alert'e geçiş yapmış oluruz.
        accept() ya da dismiss() methodlarıyla js Alert'ü onaylar ya da iptal ederek kapatırız.
         */
        //        Bir metod olusturun: acceptAlert
        //        https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
                        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[1]")).click();
        bekle(3);
        driver.switchTo().//geçmek için kullanılan method
                alert().//alert'e geçiş yapar
                accept();//çıkan alert'te ok ya da tamam butonuna tıklar.
        bekle(2);


        //        “You successfully clicked an alert” oldugunu test edin.
        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualText.equals("You successfully clicked an alert"));

    }

    @Test
    public void dismissAlert() {
        //        Bir metod olusturun: dismissAlert
        //        https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//button[2]")).click();
        bekle(3);
        driver.switchTo().
                alert().
                dismiss();//js Alert'teki iptal butonuna basar


        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertFalse(actualText.contains("successfuly"));
        bekle(2);

    }

    @Test @Ignore //Çalışmasını istemediğimiz test notasyonundan sonra @Ignore notasyonu kullanırız.
    public void sendKeysAlert() {
        //        Bir metod olusturun: sendKeysAlert
        //        https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        driver.findElement(By.xpath("//button[3]")).click();
        bekle(3);
        driver.switchTo().alert().sendKeys("Beyza");
        bekle(3);
        driver.switchTo().alert().accept();
        bekle(2);

        //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualText.contains("Beyza"));
    }
}
