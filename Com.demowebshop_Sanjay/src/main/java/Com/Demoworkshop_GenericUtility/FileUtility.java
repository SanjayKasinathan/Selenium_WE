package Com.Demoworkshop_GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		
		FileInputStream fis = new FileInputStream(frameWorkConstants.propertyPath);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}
	
	public String readDataFromExcelfile( String SheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(frameWorkConstants.execlPath);
		Workbook wb =  WorkbookFactory.create(fis);
		String value = wb.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
		
	}

}
