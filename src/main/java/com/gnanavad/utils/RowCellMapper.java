package com.gnanavad.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;

public interface RowCellMapper<T> {
	void writeToRow(T rowData, XSSFRow row);
}
