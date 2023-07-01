package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_TumSayfaResmi extends TestBase {

    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım

        tumSayfaResmi();
    }
}
