package techproed.day07_MavenJUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
         /*
        Notasyonlara sahip methodlar oluşturabilmek için "mouse + sağ tık + generate" veya kısayolu "alt + inser" şeklinde
        after methodu için teardown'u seçeriz before methodu için setup'ı seçeriz
        test methodu için de test'i seçeriz
        Junit framework'unda testlerimizi sıralama yapabilmek için ekstra bir notasyon yoktur.
        Test methodların sıralamsı alfabetik ya da sayısal olarak sıralamaya göre çalışır.
         */

    @After
    public void tearDown(){
        System.out.println("Her test methodundan sonra bir kez çalışır");
    }

    @Before
    public void setUp(){
        System.out.println("Her test methodundan önce bir kez çalışır");
    }

    @Test
    public void test1() {
        System.out.println("Test1 methodu çalıştı");
    }

    @Test
    public void test2() {
        System.out.println("Test2 methodu çalıştı");
    }

    @Test
    public void test3() {
        System.out.println("Test3 methodu çalıştı");
    }
}
