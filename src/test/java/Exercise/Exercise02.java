package Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class Exercise02 extends TestBase {
    @Test
    public void test01() {
        //https://artoftesting.com/sampleSiteForSelenium adresine gidin
        driver.get("https://artoftesting.com/sampleSiteForSelenium");

        //Radio button'dan cinsiyetinizi seçin, diğerinin seçili olmadığını doğrulayın
        driver.findElement(By.id("female")).click();
        Assert.assertTrue(!driver.findElement(By.id("male")).isSelected());

        //Checkbox'tan hangi testi yaptığınızı seçin
        driver.findElement(By.xpath("(//input[@type='checkbox']) [1]")).click();

        //Dropdown menüden Automation Testing seçeneğini seçin
        WebElement ddm = driver.findElement(By.id("testingDropdown"));
        Select select = new Select(ddm);
        select.selectByIndex(0);

        //Click below button to generate Alert box altındaki butona tıklayın ve alert'ü handle edin
        driver.findElement(By.xpath("//button[@onclick='generateAlertBox()']")).click();
        acceptAlert();
        //Click below button to generate Confirm box altındaki butona gtıklayın ve aleri cancel edin."You pressed Cancel!" yazısı aldığıonızı doğrulayın
        driver.findElement(By.xpath("//button[@onclick='generateConfirmBox()']")).click();
        dissmissAlert();
        String cancelResult = driver.findElement(By.id("demo")).getText();
        Assert.assertTrue(cancelResult.contains("You pressed Cancel!"));
    }

}
