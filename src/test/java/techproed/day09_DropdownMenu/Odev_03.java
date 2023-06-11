package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.Duration;

public class Odev_03 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //  1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
    }

    @Test
    public void test01() {
        //  2.Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //  3.Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password",Keys.ENTER);
        driver.navigate().back();

        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        driver.findElement(By.xpath("(//li[@class='ui-state-default ui-corner-top']) [2]")).click();

        WebElement currency = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(currency);
        select.selectByValue("EUR");

        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("500");

        WebElement usRadioButton = driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertTrue(!usRadioButton.isSelected());

        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();

        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();

        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();

        String sonucYazisi = driver.findElement(By.xpath("//div[@id='alert_content']")).getText();

        Assert.assertTrue(sonucYazisi.equals("Foreign currency cash was successfully purchased."));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    // ODEV-3
    //  1.http://zero.webappsecurity.com/ Adresine gidin
    //  2.Sign in butonuna basin
    //  3.Login kutusuna “username” yazin
    //  4.Password kutusuna “password.” yazin
    //  5.Sign in tusuna basin(not: navigate.Back yapınız)
    //  6.Pay Bills sayfasina gidin
    //  7.“Purchase Foreign Currency” tusuna basin
    //  8.“Currency” drop down menusunden Eurozone’u secin
    //  9.“amount” kutusuna bir sayi girin
    //  10.“US Dollars” in secilmedigini test edin
    //  11.“Selected currency” butonunu secin
    //  12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //  “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin

}
