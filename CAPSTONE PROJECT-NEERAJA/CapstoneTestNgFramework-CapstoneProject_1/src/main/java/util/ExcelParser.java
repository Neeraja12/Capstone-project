package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ExcelParser {
	
	
	public ArrayList<String> getData(String testcaseName)
	
	{
	
		ArrayList<String> data=new ArrayList<String>();
	try {
		
	
	
	FileInputStream fis=new FileInputStream("C://Users//Neeraja//Documents//Sample projects//CapstoneTestNgFramework-CapstoneProject_1//CapstoneTestNgFramework-CapstoneProject_1//src//test//resources//Test Data.xlsx");
	
	XSSFWorkbook workbook=new XSSFWorkbook();
	
	int sheets =workbook.getNumberOfSheets();
	
	for(int i=0;i<=sheets;i++)
	{
		if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
		{
			XSSFSheet sheet=workbook.getSheetAt(i);
			
			Iterator<Row> rows=sheet.iterator();
			Row firstrow=rows.next();
			Iterator<Cell> cell=firstrow.cellIterator();
			int k=0;
			int column=0;
			while(cell.hasNext())
			{
				Cell value=cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
				{
					column=k;
				}
				k++;
			}
			System.out.println(column);
			
			while(rows.hasNext())
			{
				Row r=rows.next();
				
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
				{
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext())
					{
						data.add(cv.next().getStringCellValue());
					}
				}
				
			}
			
		}
	}
	
	}
	catch(FileNotFoundException ex) {
		
		System.out.println(ex);
		
	}
	return data;
	

}
}

