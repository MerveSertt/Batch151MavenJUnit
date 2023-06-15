package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test01() {

        //Aşağıdaki bilgileri kullanarak authentication yapınız:

        //Url: https://the-internet.herokuapp.com/basic_auth
        //Username: admin
        //Password: admin

        //Başarılı girişi doğrulayın.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);
        //Congratulations! yazısının çıktığını doğrulayın
        String actualtext = driver.findElement(By.xpath("//p")).getText();
        String expectedText = "Congratulations!";
        Assert.assertTrue(actualtext.contains(expectedText));

        //Elemental Selenium yazısına tıklayalım
        driver.findElement(By.xpath("(//a)[2]")).click();

        //Başlığın Elemental Selenium olduğunu doğrulayın
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Elemental Selenium";
        Assert.assertNotEquals(expectedTitle,actualTitle);

        //Dropdown menuden Java seçelim
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        select.selectByIndex(2);

        //

    }
}
