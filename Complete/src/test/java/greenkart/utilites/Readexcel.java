package greenkart.utilites;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexcel {

	public String readdata (int a,int b) throws IOException {


		
		FileInputStream fil=new FileInputStream(System.getProperty("user.dir")+"/src/test/java/greenkart/testdata/Test data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fil);
		XSSFSheet sh=wb.getSheetAt(0);
		String data1=sh.getRow(a).getCell(b).getStringCellValue();
		System.out.println(data1);
		return data1;
		



	}

}
