package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {

    @Test
    public void test01() {
        String filePath ="C:/Users/merve/Downloads/b10 all test cases, code.docx";
        try {
            Files.delete(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Dosya bulunamadı");
        }
        //Dosyayı daha önce indirdiğimiz için ve tekrar testi çalıştırdığımızda yine aynı dosyayı indireceği için
        //burada dosyayı sildik

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//*[text()=.])[6]")).click();
        bekle(3);

        /*
        İndirmemizi istediği dosyayı locate edip tıkladık ve dosyamız indirilenler klasörüne indi
         */

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:/Users/merve/Downloads/b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
