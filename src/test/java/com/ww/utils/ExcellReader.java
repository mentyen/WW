package com.ww.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellReader {

	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;

	public void openConnection(String filePath, String sheetName) {

		try {

			fis = new FileInputStream(filePath);

			wb = new XSSFWorkbook(fis);

			sheet = wb.getSheet(sheetName);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public int getCellNum() {
		


		return sheet.getRow(1).getLastCellNum();

	}

	public int getRowNum() {
		return sheet.getPhysicalNumberOfRows();
	}

	public String getCellData(int rownum, int cellnum) {
		
		
		
				return sheet.getRow(rownum).getCell(cellnum).toString();
	}

}
