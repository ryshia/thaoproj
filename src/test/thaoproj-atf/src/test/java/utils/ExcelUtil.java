package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	//Row indexes defined for the header/parameter lines in the excel file
	static int headerRowIndex=0;
	static int idColIndex=0;
	

	 public static String[][] getExcelData(String fileName, String sheetName) throws IOException {
		 
		   String[][] data=null;
		   
		   FileInputStream file = new FileInputStream(fileName);
		   XSSFWorkbook wb = new XSSFWorkbook(file);
		   XSSFSheet sheet = wb.getSheet(sheetName);
		   XSSFRow row ;
		   
		   //Number of Rows and Column can be simply defined like this if the table simply including data only
		   // int noOfRows1 = sheet.getPhysicalNumberOfRows();
		  // int noOfCols1 = sheet.getRow(0).getPhysicalNumberOfCells();
		  
		
		   //Or below
		   
		   XSSFCell[] boundaryCells=getBoundaryCells(sheet);
		   
		   //First cell to start with
		   XSSFCell startCell = boundaryCells[0];
		   //Last cell where data reading should stop
		   XSSFCell endCell = boundaryCells[1];
		   
		   //Find the start row based on the start cell
		   int startRow = startCell.getRowIndex() + 1;
		   // Find the end row based on end cell
		   int endRow = endCell.getRowIndex() - 1;
		   // Find the start column based on the start cell
		   int startCol = startCell.getColumnIndex();
		   // Find the end column based on end cell
		   int endCol = endCell.getColumnIndex();
		   
		   int noOfRows= endRow-startRow+1;
		   int noOfCols=endCol-startCol+1;		   
		   
		   System.out.println("Rows 2: ="+ noOfRows);
		   System.out.println("Column 2: ="+ noOfCols);
			  
		   Cell cell;
		   data = new String[noOfRows-1][noOfCols];
		   
		   for(int i =2; i<noOfRows+1;i++){
			   for(int j=0;j<noOfCols;j++){
			     row = sheet.getRow(i);
			     cell= row.getCell(j);
			     data[i-2][j] = cell.getStringCellValue();
			    }
			 }
	       
	        return data;
	    }
	 
	 public static XSSFCell[] getBoundaryCells( XSSFSheet sheet){
		 
		 XSSFCell[] cells= new XSSFCell[2];
		 
		 DataFormatter dataFormatter = new DataFormatter();
		 
		 for (Row row: sheet) {
			 for (Cell cell: row) {
				 String cellValue = dataFormatter.formatCellValue(cell);
	                if (cellValue.equalsIgnoreCase("Login"))
	                	cells[0]=(XSSFCell) cell;
	                if (cellValue.equalsIgnoreCase("End Login"))
	                	cells[1]=(XSSFCell) cell;
			 }
			
		}	
		 
		 return cells;

	 }
	 

	    @SuppressWarnings("deprecation")
		public static void setCellStyle(Workbook workbook, Sheet sheet, Row row, int col, short color, String result) {

	    	
	        Cell cell = row.getCell(col);
	        if (cell == null)
	            cell = row.createCell(col);

	        cell.setCellType(CellType.STRING);
	        result = result.length()>32767 ? result.substring(0, 32767) : result;
	        cell.setCellValue(result);
	        CellStyle cellStyle = workbook.createCellStyle();
	        Font font = workbook.createFont();
	        font.setColor(color);
	        cellStyle.setFont(font);
	        cell.setCellStyle(cellStyle);
	        
	        sheet.setColumnWidth(col, col);
	     
	        //sheet.autoSizeColumn(cell.getColumnIndex());	        
	    	
	    }

}
