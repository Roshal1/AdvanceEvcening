package dataDrivenTesting;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class ReadDataFromExcel {

		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			// TODO Auto-generated method stub
			FileInputStream fis = new FileInputStream("./TestData/TestScriptDataAdv.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Campaign");
		Row row = sh.getRow(1);
		String Campname = row.getCell(2).getStringCellValue();
		String size = row.getCell(3).getStringCellValue();

}
}