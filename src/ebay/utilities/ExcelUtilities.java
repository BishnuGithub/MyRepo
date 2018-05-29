package ebay.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	public static String readFromExcel(String sheetName,
			int rowNum, int colNum) throws InvalidFormatException, IOException {

		String value = "";

		File myFile = new File("");
		FileInputStream fis = new FileInputStream(myFile);
		// Finds the workbook instance for XLSX file
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
		// Return first sheet from the XLSX workbook
		XSSFSheet mySheet = myWorkBook.getSheet(sheetName);
		Row row = mySheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		/*
		 * // Get iterator to all the rows in current sheet Iterator<Row>
		 * rowIterator = mySheet.iterator(); // Traversing over each row of XLSX
		 * file while (rowIterator.hasNext()) { Row row = rowIterator.next(); //
		 * For each row, iterate through each columns Iterator<Cell>
		 * cellIterator = row.cellIterator(); while (cellIterator.hasNext()) {
		 * Cell cell = cellIterator.next();
		 */
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				value = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				value = "" + cell.getNumericCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				value = "" + cell.getBooleanCellValue();
				break;
			case Cell.CELL_TYPE_BLANK:
				value = "";
				break;

			default:
				value = "";
			}
		}
		// } System.out.println(""); }
		fis.close();
		System.out.println("value: " + value);
		return value;

		// ------ for excel with extension .xls -----------------

		/*
		 * FileInputStream fis = new FileInputStream(pathOfFile); Workbook wb =
		 * WorkbookFactory.create(fis); Sheet s = wb.getSheet(sheetName); Row r
		 * = s.getRow(rowNum); Cell c = r.getCell(colNum);
		 * 
		 * int type = c.getCellType();
		 * 
		 * if (((type == Cell.CELL_TYPE_NUMERIC) || (type ==
		 * Cell.CELL_TYPE_STRING)) || (type == Cell.CELL_TYPE_BLANK)) { if (type
		 * == 0) { int numvalue = (int) c.getNumericCellValue(); value = "" +
		 * numvalue; } else if (type == 1) {
		 * 
		 * value = c.getStringCellValue().toString().trim();
		 * 
		 * } else { value = ""; } fis.close(); return value; }
		 * 
		 * return null;
		 */
	}
	
	public static int getRowCount(String sheetName) throws InvalidFormatException, IOException {
		File file =    new File("");
		FileInputStream inputStream = new FileInputStream(file);		
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		XSSFSheet s=wb.getSheet(sheetName);
		int r=s.getLastRowNum();
		inputStream.close();
		return r;
	}
	
	public static void writeDataToExcel(int rowNum, int cellNum, String sheetName,String dataToWrite) throws IOException, InvalidFormatException{
		// xlsx
		File myFile = new File("");
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
		XSSFSheet mySheet = myWorkBook.getSheet(sheetName);
		Row row = mySheet.getRow(rowNum);
		// sometimes row is coming as null. So added the below condition
		if (row == null)
			row = mySheet.createRow(rowNum);
		Cell cell = row.getCell(cellNum);
		// sometimes cell is coming as null. So added the below condition
		if (cell == null)
			cell = row.createCell(cellNum);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		//cell.setCellValue(testcaseID);
		// mySheet.getRow(rowNum).createCell(cellNum).setCellValue(testcaseID);
		fis.close();
	    FileOutputStream fos = new FileOutputStream("");
		myWorkBook.write(fos);
		fos.flush();
		fos.close();

		// xls
		/*
			* FileInputStream fis = new FileInputStream(pathOfFile); Workbook wb =
			* WorkbookFactory.create(fis); Sheet s = wb.getSheet(sheetName);
			* s.getRow(rowNum).createCell(cellNum).setCellValue(testcaseID);
			* fis.close(); FileOutputStream fos = new FileOutputStream(pathOfFile);
			* wb.write(fos); fos.flush(); fos.close();
		*/
	}
	
	
}
