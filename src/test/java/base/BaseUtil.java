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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pageObject.homePage;

public class BaseUtil {
	public WebDriver driver;
	
	public BaseUtil(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String returnvaluefromexcel(String parameter) throws Exception {
		File inputFile = new File(System.getProperty("user.dir") + "\\InputData\\demodata.xlsx");
		FileInputStream fis = new FileInputStream(inputFile);
		XSSFWorkbook inputWorkbook = new XSSFWorkbook(fis);
		XSSFSheet inputSheet = inputWorkbook.getSheetAt(0);
		//String inputSheetName = inputWorkbook.getSheetName(0);
		int rowCount = inputSheet.getPhysicalNumberOfRows();
		System.out.println("out");
		String cellData = null;
		System.out.println(rowCount + " rows in inputsheet " + inputSheet.getSheetName());
		for (int row = 0; row <= rowCount - 1; row++) {
		cellData = inputSheet.getRow(row).getCell(0).getStringCellValue().toString();
		if (cellData.equalsIgnoreCase(parameter)) {
		String value = inputSheet.getRow(row).getCell(1).getStringCellValue().toString();
		return value;
		}
		}
		return "no match";
		}
	
	public void SelectDropDownByVisibleText(WebElement element, String text)throws Exception {
		//waitForWebElement(driver,element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
		}
}
