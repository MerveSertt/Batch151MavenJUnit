package Assignment;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class Task05 extends TestBase {
    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        WebElement frame = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // İkinci emoji öğelerini yazdırınız
        WebElement emoji = driver.findElement(By.xpath("//div[@id='nature']"));
        System.out.println(emoji.getText());

        // Parent iframe e geri donun
        driver.switchTo().parentFrame();

        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("ankara", Keys.TAB,"Ankara",Keys.TAB,"ankara", Keys.TAB,"Ankara",Keys.TAB,"Ankara");

        // Apply button a basiniz
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }
}
