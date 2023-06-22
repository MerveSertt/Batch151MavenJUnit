package techproed.day17_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_NullPointerException extends TestBase {

    /*
       NULL_POINTER_EXCEPTION
        Obje ya da degisken olusturup bunlara atama yapmadigimiz zaman direk olusturmus oldugumuz
        obje ya da degiskeni kullanmak istersek NullPointerException hatasi aliriz

     */
    WebDriver driver;
    Faker faker;
    Actions actions;
    int sayi;
    String name;
    @Test
    public void test01() {
        /*driver = new ChromeDriver(); normalde bu atamayi yapmamiz gerekir. Bu atamayi yapmadigimiz taktirde ya da
        unuttugumuz zaman NullPointerException hatasi aliriz
         */

        driver.get("https://amazon.com");//NullPointerException
    }

    @Test
    public void test02() {
        //exception almamak için öncesinde faker = new Faker(); ataması yapmalıydık
        System.out.println(faker.name().fullName()); //NullPointerException
    }

    @Test
    public void test03() {
        actions.doubleClick().perform();//NullPointerException
    }
}
