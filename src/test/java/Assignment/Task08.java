package Assignment;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

import java.util.List;
import java.util.Random;

public class Task08 extends TestBase {
    @Test
    public void test01() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        Random random = new Random();
        List<WebElement> sayilar = driver.findElements(By.xpath("//span[@class='btn btn-outline-primary']"));
        List<WebElement> islemler = driver.findElements(By.xpath("//span[@class='operator btn btn-outline-success']"));

        int sayiIndex=0;
        for (int i = 0; i < 2; i++) {
                sayiIndex = random.nextInt(sayilar.size());
                sayilar.get(sayiIndex).click();
        }

        bekle(3);

        int isaretIndex = 0;

        for (int i = 0; i < 4; i++) {
            isaretIndex = random.nextInt(islemler.size());
            islemler.get(isaretIndex).click();
        }

        bekle(3);

        int sayiIndex2=0;
        for (int i = 0; i < 2; i++) {
            sayiIndex2 = random.nextInt(sayilar.size());
            sayilar.get(sayiIndex2).click();
        }

        bekle(3);

        driver.findElement(By.xpath("//span[@class='btn btn-outline-warning']")).click();
        bekle(5);

        //Sonucu konsola yazdırıp
        System.out.println(driver.findElement(By.xpath("//div[@class='screen']")).getText());

        //Sonucun doğrulamasını yapalım


    }
}
