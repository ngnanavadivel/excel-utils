package com.gnanavad.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DefaultExcelWriter implements ExcelWriter {

	private XSSFWorkbook workbook;

	public DefaultExcelWriter() {
		this.workbook = new XSSFWorkbook();
	}

	public <T> void createWorkSheet(String sheetName, List<String> headers, Collection<T> data,
			RowCellMapper<T> mapper) {
		if (sheetName == null || sheetName.trim().isEmpty()) {
			throw new RuntimeException("Specify a valid spreadsheet name!");
		}
		// create the workbook.
		XSSFSheet sheet = this.workbook.createSheet(sheetName);

		// Create the Header which is BOLD in style.
		int rownum = 0;
		XSSFCellStyle boldStyle = this.workbook.createCellStyle();
		XSSFFont boldFont = workbook.createFont();
		boldFont.setBold(true);
		boldStyle.setFont(boldFont);
		XSSFRow headerRow = sheet.createRow(rownum++);
		int columnIndex = 0;
		for (String header : headers) {
			XSSFCell headerCell = headerRow.createCell(columnIndex++, CellType.STRING);
			headerCell.setCellStyle(boldStyle);
			headerCell.setCellValue(header);
		}

		// Write the data to the spreadsheet.
		if (data != null && !data.isEmpty()) {
			for (T rowData : data) {
				XSSFRow row = sheet.createRow(rownum++);
				mapper.writeToRow(rowData, row);
			}
		}

		// Resize all columns to fit the contents.
		while (columnIndex-- > 0) {
			sheet.autoSizeColumn(columnIndex);
		}
	}

	public void writeToFile(String uri) throws Exception {
		ByteArrayOutputStream ostream = new ByteArrayOutputStream();
		try {
			this.workbook.write(ostream);
		} catch (IOException e) {
			throw new RuntimeException("Failed writing excel workbook as a stream!");
		}
		Files.write(Paths.get(uri), ostream.toByteArray());
	}

}
