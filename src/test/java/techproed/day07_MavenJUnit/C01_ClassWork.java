package techproed.day07_MavenJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_ClassWork {
    /*
    1.http://zero.webappsecurity.com sayfasina gidin
2.Signin buttonuna tiklayin
3.Login alanine “username” yazdirin
4.Password alanine “password” yazdirin
5.Sign in buttonuna tiklayin
6.Online Banking altında Pay Bills sayfasina gidin
7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
8.tarih kismina “2020-09-10” yazdirin
9.Pay buttonuna tiklayin
10.“The payment was successfully submitted.” mesajinin ciktigini control edin
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        WebElement signButton = driver.findElement(By.xpath("//*[@class='icon-signin']"));
        signButton.click();

        //3.Login alanine “username” yazdirin
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='user_login']")); //CSS ile almak istersek: input#user_login
        loginButton.sendKeys("username");
        //2.Way
       //   WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
       //   login.sendKeys("username",Keys.TAB,"password",Keys.ENTER);


        //4.Password alanine “password” yazdirin
        WebElement passwordButton = driver.findElement(with(By.tagName("input")).below(loginButton));
        passwordButton.sendKeys("password",Keys.ENTER);

        driver.navigate().back();

        //6.Online Banking altında Pay Bills sayfasina gidin
        WebElement onlineBanking = driver.findElement(By.xpath("//li[@id='onlineBankingMenu']"));
        onlineBanking.click();

        //text ile almak isersek: (//*[text()=.]) [11] bütün textlerden 11.sini kullanmış olduk
        //Bu şekilde text ile aldığımız bir xpath'de text değişse bile biz o webelementi handle edebiliriz. Metin şeklinde girilseydi
        // dev tarafından değiştirildiğinde locate doğru ulaşamazdı. Böyle index ile alındığında değişiklik olsa dahi locate'e ulaşılabilir.

        WebElement payBills = driver.findElement(By.xpath("//span[@id='pay_bills_link']"));
        payBills.click();

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("500");

        //8.tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");

        //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Pay']")).click();
        //2.Yol
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("500", Keys.TAB,"2020-09-10", Keys.TAB,Keys.TAB,Keys.ENTER);

        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement successfully = driver.findElement(By.xpath("//div[@id='alert_content']"));
        String actualText = successfully.getText();
        String expectedText = "The payment was successfully submitted.";

        if (actualText.equals(expectedText)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        //2.Yol: Webelementin görünür olup olmadığını doğrulamak için yaptık
        if (successfully.isDisplayed()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        driver.close();




    }
}
