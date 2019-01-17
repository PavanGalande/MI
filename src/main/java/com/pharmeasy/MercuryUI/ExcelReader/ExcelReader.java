package com.pharmeasy.MercuryUI.ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	/*public int getrowcount (String xlpath,String sheetname)
	{
		try 
		{
			FileInputStream f= new FileInputStream(xlpath);
		    Workbook wb = WorkbookFactory.create(f);
		    Sheet s = wb.getSheet(sheetname);
		    int rc = s.getLastRowNum();
		    return rc;
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
			return -1;
		}
		
	}
		public static String getcellvalue (String xlpath,String sheetname, int row, int col)
		{
			try 
			{
				FileInputStream f= new FileInputStream(xlpath);
			    Workbook wb = WorkbookFactory.create(f);
			    Sheet s = wb.getSheet(sheetname);
			    Cell cell = s.getRow(row).getCell(col);
			    
//			    cell.getCellTypeEnum();
				cell.setCellType(CellType.STRING);
			    
				String value = cell.getStringCellValue();
			    return value;
			}
			catch (Exception e)
			{
				
				e.printStackTrace();
				return "";
			}
	

	}
*/

	
	
	
	public String path ;
	XSSFWorkbook wb ;
	XSSFSheet sheet ;
	XSSFRow Row ;
	XSSFCell cell ;
	FileInputStream fis ;
	
	public ExcelReader(String path){
		
		this.path = path ;


		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public String[][] getdatafromSheet(String SheetName,String ExcelName){
		String DataSets[][]=null ;
		sheet = wb.getSheet(SheetName);
		int TotalRows = sheet.getLastRowNum()+1;
		int TotalCols = sheet.getRow(0).getLastCellNum();
		
		DataSets = new String [TotalRows -1][TotalCols];
		
		for(int i=1;i<TotalRows ;i++){
			Row = sheet.getRow(i);
			for(int j=0; j<TotalCols; j++){
				cell = Row.getCell(j);
				
				if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN){
					String cellText = String.valueOf(cell.getBooleanCellValue());
					 DataSets[i-1][j] = cellText ;
				}
				else if (cell.getCellType()==cell.CELL_TYPE_STRING){
					DataSets[i-1][j]=cell.getStringCellValue();
				}
				else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
					DataSets[i-1][j]= String.valueOf(cell.getNumericCellValue());
				}
				else if (cell.getCellType()==cell.CELL_TYPE_BLANK){
					DataSets[i-1][j]=cell.getStringCellValue();
				}
			}
			
		}
		
		return DataSets;
		
		
	}
	
	
}

