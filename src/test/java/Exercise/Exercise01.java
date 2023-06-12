package Exercise;

import org.junit.Test;
import techproed.utilities.TestBase;

public class Exercise01 extends TestBase {
    /*
     // ...Exercise1...
    // Create a new class under Q1 create main method
    // Set Path
    // Create chrome driver
    // Maximize the window
    // Open google home page https://www.google.com/.
    // On the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google
    // Navigate forward to amazon
    // Refresh the page
    // Close/Quit the browser
    // And last step : print "all ok" on console
    /*Exercise1... Q1 altında yeni bir sınıf oluştur ana yöntemi oluştur
    Yolu Ayarla Krom sürücüsü oluştur Pencereyi büyüt Google ana sayfasını aç
     https:www.google.com. Aynı sınıfta, Amazon ana sayfasına gidin
     https:www.amazon.com Google'a geri gidin Amazon'a ilerleyin Sayfayı yenileyin
     Kapat Tarayıcıdan çıkın Ve son adım: konsolda "tamam" yazdırın
    */

    @Test
    public void test01() {
        driver.get("https:www.google.com");
        driver.get("https:www.amazon.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }
}
