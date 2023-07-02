package Exercise;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercise03 extends TestBase {
    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet1");

        //5.satır 1.sütunda Turkey olduğunu doğrula
        String satir5sutun1 = sheet.getRow(4).getCell(0).toString();
        Assert.assertEquals("Turkey",satir5sutun1);

        //Toplam satır sayısının 10 olduğunu doğrula
        int satirSayisiint = sheet.getLastRowNum();
        String satirSayisi = String.valueOf(sheet.getLastRowNum());
        Assert.assertEquals("10",satirSayisi);


        //Son satır 2. sütunda oslo olduğunu doğrula
        String sonsatirsutun2 = sheet.getRow(satirSayisiint).getCell(1).toString();
        Assert.assertEquals("Oslo",sonsatirsutun2);


    }
}
