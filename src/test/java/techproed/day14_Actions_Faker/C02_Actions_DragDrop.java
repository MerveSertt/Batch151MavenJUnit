package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {

    @Test
    public void test01() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here
        // (Drag me to my target webelementini Drop here webelementi üzerine bıkalım)

        driver.switchTo().frame(0); //hareket etmesi istenen we'ler iframe içinde olduğu için iframe'e geçiş yapmalıyız.
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        //Eğer bir haraketli webelementi tutup başka bir webelementin üzerine bırakmak istersek sürüklemek istediğimiz
        // bw'tin locatini alıp üzerine bırakacağımız we'tin locate'ini de alarak dragAndDrop(kaynak,hedef) methodu ile işlemi gerçekleştirebiliriz.


    }

    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag). //--> bu method ile webelemente mouse ile basılı tuttuk.
                moveToElement(drop). //--> bu method ile basılı tuttuğumuz we'i diğer we üzerine götürdük
                release(). //--> bu method ile basılı tuttuğumuz we'i serbest bıraktık.
                perform(); //--> işlemi sonlandırdık.

    }

    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(84,28).//-->belirtmiş olduğumuz koordinatlara we'i taşır.
                release().perform();

    }
}
