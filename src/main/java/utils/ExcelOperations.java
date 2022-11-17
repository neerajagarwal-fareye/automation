package utils;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelOperations {

    public static void main(String...s){
       System.out.println(getExcelData(1,1, "StudentData"));
        System.out.println(getExcelData(1,1, "empdata"));

    }


    public static File file;

    public static void readJavaFile(){
        try {
            file = new File("TestData.xls");
            FileInputStream inputStream = new FileInputStream(file);

            HSSFWorkbook wb = new HSSFWorkbook(inputStream);
            HSSFSheet sheet=wb.getSheet("empdata");
            HSSFRow row1=sheet.getRow(1);
            System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());

        }catch (Exception e){
            e.printStackTrace();
        }
    }





    public static String getExcelData(int row, int column, String sheetName){
        String value=null;
        try {
            file = new File(System.getProperty("user.dir") + File.separator + "resources" + File.separator + "testdata" + File.separator + "TestData.xls");
            FileInputStream inputStream = new FileInputStream(file);
            HSSFWorkbook wb = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = wb.getSheet(sheetName);
            value = sheet.getRow(row).getCell(column).getStringCellValue();
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    public static void setExcelData(int row, int column, String sheetName){
        //https://javarevisited.blogspot.com/2015/06/how-to-read-write-excel-file-java-poi-example.html#axzz7jDMQWvlH
    }
}
