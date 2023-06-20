package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {

        //Google ana sayfasına git
        driver.get("https://google.com");
        //arama kutusunda shift tuşuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.id("APjFqb"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu,Keys.SHIFT). //--> arama kutusunda shift tuşuna bastık.
                            sendKeys("selenium").//-->selenium metnini shift tuşuna basılı kaldığı için büyük yazdı
                            keyUp(Keys.SHIFT).//-->shift tuşunu serbest bıraktık
                            sendKeys("-java",Keys.ENTER).//--> bu kismi shift'i serbest bıraktığımız için küçük yazdı
                            perform();
    }

    @Test
    public void test02() {
        //Google ana sayfasına git
        driver.get("https://google.com");
        //arama kutusunda shift tuşuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.id("APjFqb"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java");

          /*
    Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
     */

    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");

        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.id("APjFqb"));
        aramaKutusu.sendKeys("Selenium",Keys.ENTER);

        // Sayfayı bekleyin
        bekle(4);

        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.id("APjFqb")).////-->Sayfa yenilendigi icin tekrar locate aldik
                sendKeys(Keys.CONTROL,"a"); //-->Metni kesebilmemiz için önce ctrl+a ile seçmemiz gerekir

        driver.findElement(By.id("APjFqb")).
                sendKeys(Keys.CONTROL,"x");//Seçilen metni ctrl+x ile kestik

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.id("APjFqb")).sendKeys(Keys.CONTROL,"v",Keys.ENTER); //-->Kestiğimiz metni ctrl+v tusu ile tekrar arama kutusuna yapıştırdık ve arattık

    }
}
