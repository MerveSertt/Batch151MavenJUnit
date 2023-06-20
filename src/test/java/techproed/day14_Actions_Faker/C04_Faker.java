package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C04_Faker {

    @Test
    public void faker() {
        /*
        Faker Class'ından sahte verileri kullanabilmek için obje oluşturmamız gerekir.
         */
        Faker faker = new Faker();

        //faket objesini kullanarak bir isim yazdırınız.
        System.out.println("İsim: "+faker.name().firstName());

        //faker objesini kullanarak bir lastName yazdiralim
        System.out.println("Soyisim: "+faker.name().lastName());

        //faker objesini kullanarak bir fullName yazdiralim
        System.out.println("İsim-Soyisim: "+faker.name().fullName());

        //faker objesini kullanarak bir adress yazdiralim
        System.out.println("Adres: "+faker.address().fullAddress());

        //faker objesini kullanarak bir tel_no yazdiralim
        System.out.println("Cep No: "+faker.phoneNumber().cellPhone());
        System.out.println("Tel No: "+faker.phoneNumber().phoneNumber());

        //Rastgele 15 haneli bir numara yazdıralım
        System.out.println("Rastgele 15 haneli bir numara"+faker.number().digits(15));
    }
}
