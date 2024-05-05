package com.New_Framework.generic;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String getPropertyFileData(String key) throws IOException {
		//Generic method to read data from property file
		FileInputStream fis=new FileInputStream("./data/CommonData.property");
		Properties p = new Properties();	
		p.load(fis);
		String data=p.getProperty(key);
		return data;
	}

	public String getExcelFileData(String SheetName,int row,int cell) throws EncryptedDocumentException, IOException, InvalidFormatException{
		FileInputStream fis = new FileInputStream("./data/CreateCampaign.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		DataFormatter fr = new DataFormatter(); //creating formatter using the default locale
		 //Cell cell = wb.SheetName.getRow(row).getCell(0);
		 //String j_username = formatter.formatCellValue(cell);
		Cell c=wb.getSheet(SheetName).getRow(row).getCell(cell);
		String data=fr.formatCellValue(c);
		return data;

	}
}


