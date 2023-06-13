package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowHandle() {
        /*
        Eğer sayfaya gittikten sonra yeni sekme ya da yeni bir pencereyle başka bir sayfaya gittikten sonra tekrar ilk
        açtığınız sayfaya dönmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra String bir değişkene
        handle değerini assign ederseniz tekrar ilk açılan sayfaya dönmek istediğinizde driver.switchTo().window(ilk sayfa handle değeri);
        ile geçiş yapabilirsiniz.
         */

        /*
        WindowType.WINDOW ile de WindowType.TAB ile de driver' i her halukarda tasimiz oluruz.
        Birinde yeni pencerede acilirken digerinde yeni sekmede acilir
         */


        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedhandle = driver.getWindowHandle();
        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);
        //Window 2'de(yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);  //yeni bir pencereye driver'ı taşır
        //WindowType.TAB --> yeni bir sekme açar
        driver.get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();

        //Window 3'te yeni bir pencerede https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproedhandle);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeHandle);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);

    }

    @Test
    public void test02() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedhandle = driver.getWindowHandle();
        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);
        //Window 2'de(yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);  //yeni bir pencereye driver'ı taşır
        //WindowType.TAB --> yeni bir sekme açar
        driver.get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();

        //Window 3'te yeni bir pencerede https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();
        bekle(3);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproedhandle);
        bekle(3);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeHandle);
        bekle(3);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);
        bekle(3);

    }
}
