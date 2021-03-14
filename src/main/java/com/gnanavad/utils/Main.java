package com.gnanavad.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class Main {

	public static void main(String[] args) throws Exception {
		// Excel Spreadsheet Name
		String sheetName = "Report";

		// Header Column Names
		List<String> headers = Arrays
				.asList("Item Number", "Wamas On Hand", "Wamas On Hold", "Host On Hand", "Host On Hold", "matching");

		// Stub data to write to the spreadsheet.
		List<ReportEntry> data = new ArrayList<ReportEntry>();
		data.add(new ReportEntry(1000L, 10L, 30L, 20L, 20L, 0L));
		data.add(new ReportEntry(2000L, 100L, 50L, 75L, 70L, 5L));
		data.add(new ReportEntry(3000L, 35L, 75L, 45L, 85L, -20L));

		// Use the writer to create the spreadsheet and write it as a xlsx file.
		DefaultExcelWriter writer = new DefaultExcelWriter();
		writer.createWorkSheet(sheetName, headers, data, new RowCellMapper<ReportEntry>() {
			@Override
			public void writeToRow(ReportEntry rowData, XSSFRow row) {
				int columnNo = 0;
				row.createCell(columnNo++, CellType.NUMERIC).setCellValue(rowData.getItemNumber());
				row.createCell(columnNo++, CellType.NUMERIC).setCellValue(rowData.getWamasOnHand());
				row.createCell(columnNo++, CellType.NUMERIC).setCellValue(rowData.getWamasOnHold());
				row.createCell(columnNo++, CellType.NUMERIC).setCellValue(rowData.getHostOnHand());
				row.createCell(columnNo++, CellType.NUMERIC).setCellValue(rowData.getHostOnHold());
				row.createCell(columnNo++, CellType.NUMERIC).setCellValue(rowData.getMatching());
			}
		});
		writer.writeToFile("/tmp/output.xlsx");
	}

}
