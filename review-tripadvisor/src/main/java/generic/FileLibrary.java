package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary implements iFilePath 
{
	/**
	 * To Read Data From Properties
	 * @param key
	 * @return String
	 */
	public String getDataFromProperties(String key)
	{
		Properties propObj = new Properties();
		try
		{
			propObj.load(new FileInputStream(PROP_PATH));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		return propObj.getProperty(key);	
	}
	
	/**
	 * To Read Data From Excel
	 * @param path
	 * @param sheet
	 * @param r
	 * @param c
	 * @return String
	 */
	public String getData(String path, String sheet, int r, int c)
	{
		String v = "";
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
}
