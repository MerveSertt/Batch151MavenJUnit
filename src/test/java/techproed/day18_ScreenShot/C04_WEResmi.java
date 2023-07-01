package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WEResmi extends TestBase {
    /*
       Bir we'in resmini aratmak için önce WebElementi locate edip bir we'e assign ederiz.
       Bu we'i direkt getScreenShotAs() methodunu kullanarak resmini belirttiğimiz dosyaya kaydederiz.
        */
    @Test
    public void test01() throws IOException {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);
        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //çıkan sonucun resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/ElementResmi/WEscreenShot" + tarih + ".jpeg";

        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }
}
