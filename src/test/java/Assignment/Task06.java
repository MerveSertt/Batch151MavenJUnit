package Assignment;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class Task06 extends TestBase {
    @Test
    public void test01() {

        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement bosAlan = driver.findElement(By.xpath("//div[@class='signature-pad--body']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(bosAlan).sendKeys(Keys.PAGE_DOWN,Keys.ARROW_LEFT,Keys.ARROW_LEFT).perform();
        bekle(2);

        //- Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

        //- Sayfayi kapatiniz
    }
}
