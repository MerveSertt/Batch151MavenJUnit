package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists extends TestBase {

    @Test
    public void test01() {
        /*
        Bir websitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
        kontrol etmek, varlığını doğrulamak için ya da bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulayabilmek için;
        Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
        dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosya yolu))
        Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene assign ederiz.

        Windows10 sürümlerinden önceki sürümler için pratik olarak dosya yolu olmak istersek, yolunu almak istediğimiz
        dosyanın üzerine gelip shift+sağclick tuşuna basarak yol olarak kopyala seçeneği ile dosya yolunu kopyalayabiliriz.
         */

        String dosyaYolu = "C:/Users/merve/OneDrive/Masaüstü/sen.txt";

        System.out.println(Files.exists(Paths.get(dosyaYolu))); //->Dosya varsa true yoksa false döner

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

    @Test
    public void test02() {

        String dosyaYolu = "C:/Users/merve/OneDrive/Masaüstü/QA Test"; //--> "C"den önce ve en sondaki çift tırnaktan önce /" olmayacak
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }


    @Test
    public void test03() {
        /*
        Bir server'da farklı işletim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman daha dinamik
        olması açısından System.getProperty("as.name") bu şekilde işletim sistemini alır
        her işletim sisteminin kullanıcı yolu farklı olacağından System.getProperty("user.home") ile bilgisayarımızdaki
        kullanıcı yolunu bu şekilde String bir değişkene farklıYol ismiyle System.getProperty("user.home") atayarak her seferinde
         farklı yolları almayla uğraşmamış oluruz. Dosya diyelimki masaüstünde ve her işletim sisteminde bize aynı yolu vereceği için
         bunu da ortak yol olarak bir String'e assign ederiz.
         */
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name"); // -->İşletim sistemimizin adını verir.
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home")); // --> Bilgisayarımızdaki kullanıcı yolunu verir.

        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");
        } else if (isletimSistemiAdi.contains("Mac")) {
            farkliYol = "/Users/aycaza";
        }
        String ortakYol = "/OneDrive/Masaüstü/sen.txt";
        String dosyaYolu = farkliYol+ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        try {
            Files.delete(Paths.get(dosyaYolu)); //-> Bu şekilde belirtmiş olduğumuz dosyayı sileriz.
        } catch (IOException e) {
            System.out.println("Dosya bulunamadı");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));

        //Sildiğimiz dosya isminde yeni bir dosya oluşturalım
        try {
            Files.createFile(Paths.get(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
    Her seferinde test ettigimiz sayfada download islemi yapiliyorsa gereksiz dosya kalabaligini onlemek icin
    yukardaki delete islemini kullanabiliriz
 */
    }

    @Test
    public void test04() {

        /*
    Yukaridaki methodlarda bilgisayarimizdaki dosya yolunun varligini Files.exists() methodu ile test etmistik.
    Ayni islemi asagidaki ornekteki gibi File class'indan obje olusturarak da yapabiliriz
 */
        // System.out.println(new File(dosyaYolu).exists()); // --> 2.yol
        String dosyaYolu = "C:/Users/merve/OneDrive/Masaüstü/QA Test";
       File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();


    }
}
