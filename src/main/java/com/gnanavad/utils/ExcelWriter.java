package com.gnanavad.utils;

import java.util.Collection;
import java.util.List;

public interface ExcelWriter {
	<T> void createWorkSheet(String sheetName, List<String> headers, Collection<T> data, RowCellMapper<T> mapper);
}
