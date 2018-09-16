package com.yangyang.POI;



import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.springframework.util.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class POIUtils1 {

	private POIFSFileSystem fs;
	private Workbook wb;
	private Sheet sheet;

	private List<String> sheetNames;
	private Map<String, List<String>> headMap;
	private Map<String, List<String[]>> contentMap;

	private POIUtils1() {
		wb = new HSSFWorkbook();
	}


	public POIUtils1(InputStream inputStream) {
		try {

			wb = WorkbookFactory.create(inputStream);
			sheetNames = new ArrayList<String>();
			contentMap = new HashMap<String, List<String[]>>();
			headMap = new LinkedHashMap<String, List<String>>();

			int sheet = wb.getNumberOfSheets();

			// 获取所有sheet页的名称
			for (int i = 0; i < sheet; i++) {
				sheetNames.add(wb.getSheetAt(i).getSheetName());
			}

			// 获取每一页的内容
			for (String name : sheetNames) {
				if (contentMap.get(name) == null) {
					try {
						contentMap.put(name, this.parseCellsBySheetName(name));
					} catch (Exception e) {
						continue;
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//throw new BaseException(ExceptionCategory.File_Upload, "解析excel文件错误，未找到上传的文件;" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			//throw new BaseException(ExceptionCategory.File_Upload, "解析excel文件错误，" + e.getMessage());
		}catch (Exception e){
			//throw new BaseException(ExceptionCategory.File_Upload, "解析excel文件错误，" + e.getMessage());
		}
	}

	public List<String> getSheetNames() {
		return sheetNames;
	}

	public List<String> getHeadBySheetName(String sheetName) {
		return headMap.get(sheetName);
	}

	public List<String[]> getContentBySheetName(String name) {
		return contentMap.get(name);
	}

	private List<String[]> parseCellsBySheetName(String sheetName) {
		List<String[]> result = new ArrayList<String[]>();
		List<String> head = null;
		String[] obj = null;
		int i = 0;
		sheet = wb.getSheet(sheetName);

		Iterator<Row> rows = sheet.iterator();
		while (rows.hasNext()) {
			Row row = rows.next();
			int cellNums;
			// update by chenqiuxia	2017/10/27
			if (i == 0) {  // 表头
				cellNums = row.getLastCellNum();
			} else {  // 内容长度取表头长度
				cellNums = head.size();
			}
			// update by chenqiuxia	2017/10/27
			obj = new String[cellNums];
			for (int j = 0; j < cellNums; j++) {
				// 设置cell的格式为时间格式：hh:mm
				if (i > 0) {
					List<String> tp = headMap.get(sheetName);
					if (tp.get(j).contains("时间")) {
						CellStyle cellStyle = wb.createCellStyle();
						DataFormat format = wb.createDataFormat();
						cellStyle.setDataFormat(format.getFormat("hh:mm"));
						row.getCell(j).setCellStyle(cellStyle);
					}
				}
				obj[j] = this.getValue(row.getCell(j));
			}
			if (i == 0) {
				head = Arrays.asList(obj);
				headMap.put(sheetName, head);
				i++;
			} else {
				if(!isEmptyArray(obj)){
					result.add(obj);
				}

			}
		}
		return result;
	}

	private boolean isEmptyArray(String[] arr) {
		if(arr == null || arr.length == 0){
			return true;
		}
		for(String s : arr){
			if(!StringUtils.isEmpty(s)){
				return false;
			}
		}
		return true;
	}

	private String getValue(Cell cell) {
		String value = "";
		if (cell == null) {
			return value;
		}
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				// 日期
				Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				value = format.format(date);
			} else {
				BigDecimal big = new BigDecimal(String.valueOf(cell.getNumericCellValue()));
				value = big.toString();
				// 解决1234.0 去掉后面的.0
				if (null != value && !"".equals(value.trim())) {
					String[] item = value.split("[.]");
					if (1 < item.length && "0".equals(item[1])) {
						value = item[0];
					}
				}
			}
			break;
		case Cell.CELL_TYPE_STRING:
			if ("hh:mm".equals(cell.getCellStyle().getDataFormatString())) {  //判断单元格的格式类型
				// 自定义格式
				value = "1990-1-1 " + cell.getStringCellValue().toString() + ":00";
			} else {
				// 字符串
				value = cell.getStringCellValue().toString().trim();
			}
			break;
		case Cell.CELL_TYPE_BLANK:
			value = "";
		}
		return value;
	}

	public void setSheetHidden(String name) {
		wb.setSheetHidden(sheetNames.indexOf(name), true);
	}

	public Workbook getWb() {
		return wb;
	}

}
