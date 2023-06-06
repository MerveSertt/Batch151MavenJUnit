package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass methodları static olmak zorundadır
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her class'dan önce BeforeClass Methodu'u 1 kez çalışır.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her class'dan sonra AfterClass Methodu'u 1 kez çalışır.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her method'dan önce Before(setUp) 1 kez çalışır");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her methoddan sonra After(teardown) methodu'u bir kez çalışır");
    }

    @Test
    public void test01() {
        System.out.println("Test01 methodu çalıştı");
    }

    @Test
    public void test02() {
        System.out.println("Test02 methodu çalıştı");
    }

    @Test
    public void test03() {
        System.out.println("Test03 methodu çalıştı");
    }
}
