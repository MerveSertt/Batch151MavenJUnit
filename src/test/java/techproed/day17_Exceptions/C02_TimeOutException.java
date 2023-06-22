package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
    TIME OUT EXCEPTION
        -Explicit wait kullanırken yanlış method ya da yanlış max. bekleme süresi gibi durumlarda org.openqa.selenium.TimeoutException
        hatası alırız.
     */

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
                driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
                WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        //Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
                wait.until(ExpectedConditions.visibilityOf(helloWorldText));
                /*
                org.openqa.selenium.TimeoutException: normalde helloworlText webelementi 5-6 saniye civarında
                etkileşime girerken biz max bekleme süresini 2 sn verdiğimiz için bu hatayı aldık.
                Dolayısıyla
        bu exception'ı handle edebilmek için doğru süreyi ve doğru methodu kullanmamız gerekir.
                 */
        //visibilityOf() methoduyla görünür olana kadar bekler

        Assert.assertEquals("Hello World!",helloWorldText.getText());
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        //WebElement helloWorldText = driver.findElement(By.xpath("yanlis locate"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("yanlisLocate")));

        //Bu örnekte max süreyi doğru vermemize rağmenyanlış locate aldığımız için yine org.openqa.selenium.TimeoutException
        // hatası alırız. Dolasıysıyla bu exception'ı handle edebilmek için locate'i doğru almalıyız.
    }

    @Test
    public void test03() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //CheckBox yazan buttona tıklayalım
        driver.findElement(By.xpath("//*[@id='checkbox']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='ch']")));
        /*
        org.openqa.selenium.TimeoutException: yanlis method kullandigimiz icin bu hatayi aldik.
         */

        //checkBox'ın seçili olduğunu doğrulayalım (Checkbox'ı locate etmeliyiz)
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='ch']"));
        Assert.assertFalse(checkBox.isSelected());

    }
}
