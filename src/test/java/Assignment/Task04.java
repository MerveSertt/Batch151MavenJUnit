package Assignment;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class Task04 extends TestBase {
    @Test
    public void test01() {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();

        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Merve");
        driver.switchTo().alert().accept();

        //-Çıkan mesajı konsola yazdırınız
        System.out.println(driver.findElement(By.xpath("//p[@id='demo1']")).getText());

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        String actualText = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        String expectedText = ("Hello Merve How are you today");
        Assert.assertEquals(expectedText,actualText);
    }
}
