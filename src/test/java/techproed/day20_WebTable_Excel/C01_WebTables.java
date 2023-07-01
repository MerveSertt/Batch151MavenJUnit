package techproed.day20_WebTable_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    /*
    WEBTABLE;
        <table> tagı ile başlar
            <thead> başlıklar için bu tag ile devam eder.
                <tr> table row(başlıkların satırı)
                <th> table head
                    ve
                        <td>    başlıktaki veriler
                <tbody> başlıklar altındaki verileri temsil eder.
                    <tr> table row(satır)
                        <td> table data (tablodaki veri)
     */
    @Test
    public void test01() {
        extentReport("Chrome", "WebTable");
        extentTest = extentReports.createTest("WebTable","Test Raporu");

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Sayfaya gidildi.");

        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo1");
        System.out.println(table1.getText());
        extentTest.info("Tablo1 yazdırıldı.");

        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println();
        System.out.println(ucuncuSatir.getText());
        extentTest.info("3.satır verileri yazdırıldı.");

        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
                                                                        //last() --> istenilene göre son satır ya da sütun bilgilerini verir.
        System.out.println("1.Tablo Son Satır Bilgileri: " + sonSatir.getText());
        extentTest.info("Son satır verileri yazdırıdı.");

        //    Task 4 : 5. Sütun verilerini yazdırın
        WebElement besinciBaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println(besinciBaslik.getText()); // --> 5.Sütun başlığını yazdıracak
        extentTest.info("%. sütun verileri yazdırıldı.");

       List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
       besinciSutun.forEach(t-> System.out.println(t.getText()));

        //    Task 5 : 3. Satırdaki 1. ve 2. sütun bilgilerini yazdırınız
        WebElement ucuncuBaslik = driver.findElement(By.xpath("(//thead)[1]//th[3]"));
        System.out.println(ucuncuBaslik.getText()); // --> 5.Sütun başlığını yazdıracak
        extentTest.info("3. Satırdaki 1. ve 2. sütun bilgileri yazdırıldı");

        List<WebElement> ucuncuSatir1 = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
        ucuncuSatir1.forEach(t-> System.out.println(t.getText() + "\t"));


        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        printData(2,3);
        extentTest.info("2.satır 3. sütun bilgileri yazdırıldı");

        //3. satır 2. sütunbilgisinin Jack olup olmadığını doğrulayın
        String actualData = printData(3,4);
        String expectedData = "Jack";
        Assert.assertNotEquals(expectedData,actualData);
        extentTest.fail("3. satır 2. sütun bilgisinin Jason olduğu görüldü");
        extentTest.pass("Sayfa kapatıldı");
        extentReports.flush();

    }

    private String printData(int satir, int sutun){
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+ satir +"]//td["+sutun+"]"));
        return satirSutun.getText();
    }

         //ÖDEV
         //C03_WebTables class'ı için aldığımız rapora gidelim
         //NOT:driver.get("testOutput/extentReports/extentReport_09_53_35_26062023.html")
         //Başlığın Extent Report olduğunu test edelim
         //Rapor temasını dark yapalım
         //Dashboard bölümüne gidip tabloyu yazdırınız
         //Tester'ın "isminiz" olduğunu doğrulayalım
         //Sayfayı kapatalım
}
