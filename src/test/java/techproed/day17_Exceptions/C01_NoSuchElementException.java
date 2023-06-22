package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test01() {
        /*
        NO SUCH ELEMENT EXCEPTION
            -Bir webelementin locate'ini yanlış aldığımızda elementi bulamayacağı için bu exception'ı alırız.
         */

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='ssearch']"));

       /*
        org.openqa.selenium.NoSuchElementException:
          normal locatimiz //*[@type='search'] bu şekilde iken nosuchelementexception alabilmek için locate'i bozduk
        //*[@type='ssearch'] ve exception'ı aldığımızı gördük. Dolayısıyla bu hatayı handle edebilmek için
        düzgün locate almamız gerekiyor. Webelement bir iframe içinde olabilir, bir buttona tıkladığımızda yeni bir
        pencere açılabilir yada alert çıkabilir bu gibi durumlarda da nosuchelementexception alırız
         */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));


    }


    @Test
    public void test02() {
        /*
        NO SUCH ELEMENT EXCEPTION
            -Bir webelementin locate'ini yanlış aldığımızda elementi bulamayacağı için bu exception'ı alırız.
         */

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.cssSelector("//*[@type='ssearch']"));

        /*
        InvalidSelectorException: xpath ile aldığımız bir we'in locate'ini cssselector locater ile kullanırsak bu eception'ı alırız.
         Dolayısıyla bunu handle etmek için
    doğru locator'ı kullanmamız gerekir.
         */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));


    }
}


