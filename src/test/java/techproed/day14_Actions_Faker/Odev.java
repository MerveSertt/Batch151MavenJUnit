package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class Odev extends TestBase {
    @Test
    public void test01() {
        Actions actions = new Actions(driver);
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over  Me First" kutusunun ustune gelin
        WebElement hoverOver = driver.findElement(By.xpath("//div[@class='dropdown hover']"));
        actions.moveToElement(hoverOver).perform();

        // 3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

        // 4- Popup mesajini yazdirin
        System.out.println("Popup Mesajı: "+driver.switchTo().alert().getText());

        // 5- Popup'i tamam diyerek kapatin
        acceptAlert();

        // 6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHold).perform();

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());

        // 8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doubleClick = driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClick).perform();

        WebElement doubleClick2 = driver.findElement(By.xpath("//div[@class='div-double-click double']"));

        Assert.assertTrue(doubleClick2.isDisplayed());
    }
}
