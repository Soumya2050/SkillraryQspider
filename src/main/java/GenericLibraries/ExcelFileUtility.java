package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	private Workbook wb;
	
	public void ExcelIntialization(String excelpath)
	{
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException |IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/**
	 * This method is used to read the single data from excel
	 * @param SheetName
	 * @param rownum
	 * @param cellname
	 * @return
	 */
	public String ReadData(String SheetName,int rownum,int cellnum) {
		return wb.getSheet(SheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
	}
	/**
	 * This method is used to read data from excel in the form of key an
	 * @param SheetName
	 * @return
	 */
	public Map<String,String> ReadData(String SheetName){
		Map<String,String>map=new HashMap<>();
		Sheet sh=wb.getSheet(SheetName);
		for(int i=0;i<=sh.getLastRowNum();i++){
			Cell c=sh.getRow(i).getCell(0);
			Cell c1=sh.getRow(i).getCell(1);
			String key=c.getStringCellValue();
			String  value=c1.getStringCellValue();			
			map.put(key, value);
		}		
		return map;		
	}
	/**
	 * This method is used to close the workbook
	 */
	public void closeWorkbook() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

