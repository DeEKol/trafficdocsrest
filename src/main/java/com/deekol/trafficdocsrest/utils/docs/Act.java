package com.deekol.trafficdocsrest.utils.docs;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

public class Act {
	private final static int startRow = 2;
	static void sheetFilling(Workbook wb, Sheet sheet, List<List<Object>> denominationList) throws IOException {
		DocBody docBody = new DocBody(wb, sheet, startRow, denominationList);
		
		
		CellStyle arial9LT = FontStyles.createArial9LT(wb);
		CellStyle arial9LTW = FontStyles.createArial9LTW(wb);
		CellStyle arial11LCB = FontStyles.createArial11LCB(wb);
		CellStyle arial14LCB = FontStyles.createArial14LCB(wb);
		
		docBody.bodyFilling();
		
		//Заголовок
		sheet.addMergedRegion(new CellRangeAddress(startRow, startRow+1, 1, 27));
		Row row11 = sheet.createRow(startRow);
		Cell cell1r11 = row11.createCell(1);
		cell1r11.setCellStyle(arial14LCB);
		cell1r11.setCellValue("Акт № 0 от 00 января 0000 г.");
		
		int c = denominationList.size();
		
		//Условия
		sheet.addMergedRegion(new CellRangeAddress(14 + c, 14 + c, 1, 27));
		Row rowCondition = sheet.createRow(14 + c);
		rowCondition.setHeightInPoints((float) 23.6);
		Cell cellCondition = rowCondition.createCell(1);
		cellCondition.setCellStyle(arial9LTW);
		cellCondition.setCellValue("Вышеперечисленные услуги выполнены полностью и в срок."
				+ "Заказчик претензий по объему, качеству и срокам оказания услуг не имеет.");
		
		//Подписи
		Row rowSignation = sheet.createRow(startRow+18 + c);
		Cell cellSignature1 = rowSignation.createCell(1);
		cellSignature1.setCellStyle(arial11LCB);
		cellSignature1.setCellValue("ИСПОЛНИТЕЛЬ");
		Cell cellSignature2 = rowSignation.createCell(17);
		cellSignature2.setCellStyle(arial11LCB);
		cellSignature2.setCellValue("ЗАКАЗЧИК");
		
		Row rowInitials = sheet.createRow(startRow+19 + c);
		Cell cellrowInitials1 = rowInitials.createCell(1);
		cellrowInitials1.setCellStyle(arial9LT);
		cellrowInitials1.setCellValue("ИП Иванов Иван Иванович");
		Cell cellrowInitials2 = rowInitials.createCell(17);
		cellrowInitials2.setCellStyle(arial9LT);
		cellrowInitials2.setCellValue("ИП Петров Пётр Петрович");
		
		//Границы
//		RegionUtil.setBorderTop(BorderStyle.MEDIUM , CellRangeAddress.valueOf("$B$" + (startRow+15 + c) + ":$AB$" + (startRow+15 + c)), sheet);
		RegionUtil.setBorderTop(BorderStyle.THIN , CellRangeAddress.valueOf("$B$" + (startRow+23 + c) + ":$L$" + (startRow+23 + c)), sheet);
		RegionUtil.setBorderTop(BorderStyle.THIN , CellRangeAddress.valueOf("$R$" + (startRow+23 + c) + ":$AB$" + (startRow+23 + c)), sheet);
	}
}
