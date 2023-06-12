package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C03_Alert extends TestBase {
    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();
        //Çıkan alertte You Clicked a button yazısının çıktığını doğrulayalım
        System.out.println(getTextAlert());
        Assert.assertEquals("You clicked a button",getTextAlert());

        //Ve alert'ü kapatalım
        acceptAlert();
    }

    @Test
    public void test02() {
        driver.get("https://demoqa.com/alerts");
        //On button click, confirm box will appear karşısındaki buttona basalım
        driver.findElement(By.xpath("(//button)[4]")).click();
        //Çıkan allertte iptal'e basalım
        dissmissAlert();
        //Sonuç yazısında You selected Cancel yazdığını doğrulayalım
        String sonucYAzisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel", sonucYAzisi);

    }

    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");
        //On button click, prompt box will appear karşısındaki buttona basalım
        driver.findElement(By.xpath("(//button)[5]")).click();
        //Çıkan allert'e ismimizi girelim
        sendKeysAlert("Beyza");
        acceptAlert();
        //İsmi girdiğimizi doğrulayalım
        String sonucYazisi = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("Beyza"));
    }
}
