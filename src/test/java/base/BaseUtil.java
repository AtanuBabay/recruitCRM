package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BaseUtil {
	public WebDriver driver;
	
	public void excelInput() throws IOException {
		FileInputStream fis = new FileInputStream(
		new File(System.getProperty("user.home") + "\\InputData\\demodata.xlsx"));
		//FileInputStream fis = new FileInputStream("user.dir") + 
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			XSSFSheet sheet = workbook.getSheetAt(i);
		}
	}
	public ArrayList<String> getData(String testcaseName) throws IOException
	{
	//fileInputStream argument
	ArrayList<String> a=new ArrayList<String>();

	FileInputStream fis = new FileInputStream(
	new File(System.getProperty("user.home") + "\\InputData\\demodata.xlsx"));
	XSSFWorkbook workbook=new XSSFWorkbook(fis);

	int sheets=workbook.getNumberOfSheets();
	for(int i=0;i<sheets;i++)
	{
	if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
	{
	XSSFSheet sheet=workbook.getSheetAt(i);
	//Identify Testcases coloum by scanning the entire 1st row

	Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows
	Row firstrow= rows.next();
	Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
	int k=0;
	int coloumn = 0;
	while(ce.hasNext())
	{
	Cell value=ce.next();

	if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
	{
	coloumn=k;

	}

	k++;
	}
	System.out.println(coloumn);

	////once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
	while(rows.hasNext())
	{

	Row r=rows.next();

	if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName))
	{

	////after you grab purchase testcase row = pull all the data of that row and feed into test

	Iterator<Cell>  cv=r.cellIterator();
	while(cv.hasNext())
	{
	Cell c= cv.next();
	if(c.getCellType()==CellType.STRING)
	{

	a.add(c.getStringCellValue());
	}
	else{

	a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

	}
	}
	}

	}


	}
	}
	return a;

	}

}
