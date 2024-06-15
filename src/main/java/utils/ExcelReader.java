package utils;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public static List<String> getPhoneNumbersWithExecutionRequiredYes(String filePath) {
        List<String> phoneNumbers = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(new File(filePath));

            // Create Workbook instance for XLSX file
            Workbook workbook = new XSSFWorkbook(file);

            // Get first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each row
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Skip header row
                if (row.getRowNum() == 0) {
                    continue;
                }

                // Get the execution required value
                Cell executionCell = row.getCell(1);
                String executionRequired = executionCell.getStringCellValue().trim();

                // Check if execution required is "Yes"
                if (executionRequired.equalsIgnoreCase("Yes")) {
                    // Get the phone number
                    Cell phoneCell = row.getCell(0);
                    String phoneNumber = "";
                    if (phoneCell.getCellType() == CellType.NUMERIC) {
                        phoneNumber = String.valueOf((long) phoneCell.getNumericCellValue());
                    } else if (phoneCell.getCellType() == CellType.STRING) {
                        phoneNumber = phoneCell.getStringCellValue().trim();
                    }
                    phoneNumbers.add(phoneNumber);
                }
            }

            // Close the workbook
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phoneNumbers;
    }
    
    
    public static String getGroceryProduct(String filePath) {
        String groceryProduct = null;

        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
            int rowIndex = 0; // Assuming data starts from the first row

            Row headerRow = sheet.getRow(rowIndex);
            int groceryProductIndex = -1;

            // Find the index of the "GroceryProduct" column
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase("GroceryProduct")) {
                    groceryProductIndex = cell.getColumnIndex();
                    break;
                }
            }

            if (groceryProductIndex != -1) {
                // Read the value of the "GroceryProduct" column from the first row
                Row dataRow = sheet.getRow(++rowIndex); // Move to the first data row
                Cell groceryProductCell = dataRow.getCell(groceryProductIndex);

                // Ensure the cell is not null and is of type STRING
                if (groceryProductCell != null && groceryProductCell.getCellType() == CellType.STRING) {
                    groceryProduct = groceryProductCell.getStringCellValue();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return groceryProduct;
    }

    public String getPhoneNumber() {
    	String filePath = "C:\\Users\\amantrivedi\\Downloads\\ExitTest-main\\ExitTest-main\\src\\main\\resources\\TestData.xlxs";
        List<String> phoneNumbers = getPhoneNumbersWithExecutionRequiredYes(filePath);
        String phoneNumber = phoneNumbers.get(0);
        return phoneNumber;
    }
    
    
    public String  getGroceryProduct() {
        String filePath = "C:\\Users\\amantrivedi\\Downloads\\ExitTest-main\\ExitTest-main\\src\\main\\GroceryStoreTestData.xlxs";
        String groceryProduct = getGroceryProduct(filePath);
        if (groceryProduct != null) {
            return groceryProduct;
        } else {
            return "";
        }
    }
    
    
    
    
    
}
