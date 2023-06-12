package Assignment;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class Task03 extends TestBase {
    /*
    -Amazon sayfasına gidelim
    -Arama Kutusundaki Dropdown menuyu yazdıralım
    -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
    Not: Select Class'ı kullanalım
     */

    @Test
    public void test01() {
        driver.get("https://amazon.com");
        for (int i = 0; i < 5; i++) {
            WebElement ddm = driver.findElement(By.xpath("//select[@name='url']"));
            Select select = new Select(ddm);
            select.selectByIndex(i);
            driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
            driver.navigate().back();
            System.out.println(driver.getTitle());
        }
    }
}
