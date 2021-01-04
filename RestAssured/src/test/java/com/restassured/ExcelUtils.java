package com.restassured;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {


	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;


	public static int getRowCount(String Xlfile, String XlSheet) throws IOException {

		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(XlSheet);
		int rowcount =ws.getLastRowNum();
		wb.close();
		fi.close();

		return rowcount;

	}


	public static int getcellCount (String Xlfile, String XlSheet,int rownum) throws IOException {

		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(XlSheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();

		return cellcount;

	}

	public static String getcellData(String Xlfile, String XlSheet,int rownum,int colnum) throws IOException  {

		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(XlSheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		String data;

		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}

		catch(Exception e) {
			data = "";

		}
		wb.close();
		fi.close();

		return data;

	}
}
