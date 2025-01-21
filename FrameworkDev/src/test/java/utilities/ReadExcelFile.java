package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReadExcelFile {

	
	  public ArrayList<String> readingExcel() throws IOException {
	      int k;
	      int l;

	      // identify location of .xlsx file
	      File f = new File("./TestData/Data.xlsx");
	      FileInputStream i = new FileInputStream(f);

	      // instance of XSSFWorkbook
	      XSSFWorkbook w = new XSSFWorkbook(i);

	      // create sheet in XSSFWorkbook with name Details1
	      XSSFSheet s = w.getSheet("Details1");

	      // get row and column numbers
	      int r = s.getLastRowNum() + 1;
	      int c = s.getRow(0).getLastCellNum();

	      ArrayList<String> names = new ArrayList<>();

	      // iterating through rows
	      for (k = 1; k < r; k++) {
	         Row rw = s.getRow(k);
	         String name = "";
	         
	         // iterating through columns
	         for (l = 0; l < c; l++) {
	            Cell cell = rw.getCell(l);
	            if("" != name){
	               name += "," + cell.getStringCellValue();
	            } else {
	               name += cell.getStringCellValue();
	            }
	         }
			 
	         // storing excel values read to arraylist
	         names.add(name);
	      }
		  
	      // closing excel file
	      w.close();
	      return names;
	   }
}
