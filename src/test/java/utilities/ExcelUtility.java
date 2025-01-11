package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {

    private Workbook workbook;
    private Sheet sheet;
    private String filePath;



    // Constructor to load the Excel file and sheet
    public ExcelUtility(String filePath, String sheetName) {
        this.filePath = filePath; // Save file path for reuse
        try (FileInputStream fis = new FileInputStream(filePath)) {
            workbook = new XSSFWorkbook(fis); // For .xlsx files
            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet " + sheetName + " does not exist in the file: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load the Excel file: " + filePath, e);
        }
    }

    // Method to get data from a specific cell
    public String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            return "";
        }
        Cell cell = row.getCell(colNum);
        if (cell == null) {
            return "";
        }
        return cell.toString();
    }

    // Method to set data in a specific cell
    public void setCellData(int rowNum, int colNum, String data) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        cell.setCellValue(data);

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not write to the Excel file: " + filePath, e);
        }
    }

    // Method to get the total number of rows
    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Close the workbook
    public void closeWorkbook() {
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
