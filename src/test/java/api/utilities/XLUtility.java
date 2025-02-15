package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 
 


public class XLUtility {
	
	
	public Sheet sheet;
	public XSSFWorkbook workbook;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	FileInputStream fis;
	int rowcount;
	 int cellcount;
	
	
	public XLUtility(String path) {
		this.path=path;
	}

	public int getRowCount(String sheetName) throws IOException{
		  fis=new FileInputStream(path);
		  workbook =new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		rowcount=sheet.getLastRowNum();
		workbook.close();
		
		return rowcount;
		
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException{
		  fis=new FileInputStream(path);
		  workbook =new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row =(XSSFRow) sheet.getRow(rownum);
	    cellcount=row.getLastCellNum();
		workbook.close();
		
		return cellcount;	
	}
	
	public String getCellData(String sheetName, int rownum, int column) throws IOException {
		  fis=new FileInputStream(path);
		 workbook =new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row =(XSSFRow) sheet.getRow(rownum);
		cell=row.getCell(column);
		
		
		DataFormatter format=new DataFormatter();
		String data;
		try {
			data=format.formatCellValue(cell);
		}
		catch(Exception e) {
			data="";
		}
		workbook.close();
		fis.close();
		return data;
	}
}

	

