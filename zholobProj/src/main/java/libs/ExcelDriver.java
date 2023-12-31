package libs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/*
 *  Class that provides methods for extracting data from Excel tables.
 */
public class ExcelDriver {

	/*
	 * Static method that retrieves testing data from multiple data Excel table and returns it
	 * as Map collection of key-value pairs. Column Number indicates number of data set. Note, please, that returned values
	 * are String. We should take care of value's type by himself when will use
	 * data values in the test.
	 * метод приймає на вхід шлях до файлу з даними, назва листа, номер колонки
	 * і повертає мапу з ключем і значенням
	 */

	public static Map getMultipleData(String dataFileName, String sheetName, int columnNumber) throws IOException {
		Map<String, String> testData = new HashMap<>();
		// Create stream for reading from file
		InputStream input = new FileInputStream(dataFileName); // створюємо конекшен для читання з файлу записуємо в інпутстрім
		// Get Excel WorkBook from input stream
		HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input)); // створюємо ворк бук структура аналогічна хлс
		// Get Excel sheet from WorkBook
		HSSFSheet sheet = wb.getSheet(sheetName);//зчитуємо лист і записуємо в змінну

		// Get number of data values
        int dataSize = sheet.getPhysicalNumberOfRows() - 1; // зчитуємо кількість рядків в таблиці
		// Look over the table and put key-value pairs into the Map collection
		for (int k = 1; k < (dataSize + 1); k++) {
			HSSFCell keyCell = sheet.getRow(k).getCell(0); // зчитуємо ключ з першої колонки
			HSSFCell valueCell = sheet.getRow(k).getCell(columnNumber);// зчитуємо значення з колонки
			valueCell.setCellType(HSSFCell.CELL_TYPE_STRING); //всі типи данних в екселі переводимо в стрінг
			testData.put(keyCell.getStringCellValue(), valueCell.getStringCellValue()); //додаємо в мапу ключ і значення
		}

		input.close(); // закриваємо конекшен до файлу
		return testData;
	}


    /*
      * Static method that retrieves testing data from Excel table and returns it
      * as Map collection of key-value pairs. Note, please, that returned values
      * are String. We should take care of value's type by himself when will use
      * data values in the test.
      * метод приймає на вхід шлях до файлу з даними, назва листа
      * з першої колонки ключ з другої значення
      * викликаємо попередній метод
      */
    public static Map<String, String> getData(String dataFileName, String sheetName) throws IOException {
        return getMultipleData(dataFileName, sheetName, 1);
    }

	

	/*
	 * Static method that retrieves testing data from Excel table and returns it
	 * as Map collection of key-value pairs. Note, please, that returned values
	 * are String. We should take care of value's type by himself when will use
	 * data values in the test.
	 * транспонована матриця, ключі по горизонталі, значення по вертикалі
	 */
	public static Map getDataRow(String dataFileName, String sheetName) throws IOException {
		Map<String, String> testData = new HashMap<>();
		// Create stream for reading from file
		InputStream input = new FileInputStream(dataFileName);
		// Get Excel WorkBook from input stream
		HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input));
		// Get Excel sheet from WorkBook
		HSSFSheet sheet = wb.getSheet(sheetName);

		// Get number of data values
		int dataSize = sheet.getRow(2).getPhysicalNumberOfCells();
		// Look over the table and put key-value pairs into the Map collection
		for (int k = 0; k < (dataSize); k++) {
			HSSFCell keyCell = sheet.getRow(2).getCell(k);
			HSSFCell valueCell = sheet.getRow(3).getCell(k);
			valueCell.setCellType(HSSFCell.CELL_TYPE_STRING);
			testData.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
		}

		input.close();
		return testData;
	}
}
