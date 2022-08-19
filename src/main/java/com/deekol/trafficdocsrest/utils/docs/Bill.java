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

/**
 * Класс Счёт.
 * Метод sheetFilling создаёт лист со счётом.
 * @author Den Kolodkin
 * dekolodkin@gmail.com
 */

public class Bill {	
	static void sheetFilling(Workbook wb, Sheet sheet, List<List<Object>> denominationList) throws IOException {
		DocBody docBody = new DocBody(wb, sheet, 10, denominationList);
		docBody.bodyFilling();
		
		//Шрифты
		CellStyle arial8LT = FontStyles.createArial8LT(wb);
		CellStyle arial9LT = FontStyles.createArial9LT(wb);
		CellStyle arial9LTW = FontStyles.createArial9LTW(wb);
		CellStyle arial9LTB = FontStyles.createArial9LTB(wb);
		CellStyle arial14LCB = FontStyles.createArial14LCB(wb);

	//Шапка банк
		//Ряды шапки
		Row row3 = sheet.createRow(2);
			Cell cell2r3 = row3.createCell(1);
			cell2r3.setCellStyle(arial9LT);
			cell2r3.setCellValue("ПАО «Сбербанк»");
			
			Cell cell17r3 = row3.createCell(16);
			cell17r3.setCellStyle(arial9LT);
			cell17r3.setCellValue("БИК");
			
			Cell cell20r3 = row3.createCell(19);
			cell20r3.setCellStyle(arial9LT);
			cell20r3.setCellValue("000000000");
			
		Row row4 = sheet.createRow(3);
			Cell cell17r4 = row4.createCell(16);
			cell17r4.setCellStyle(arial9LT);
			cell17r4.setCellValue("Сч. №");
			
			Cell cell20r4 = row4.createCell(19);
			cell20r4.setCellStyle(arial9LT);
			cell20r4.setCellValue("00000000000000000000");
		
		Row row5 = sheet.createRow(4);
			Cell cell2r5 = row5.createCell(1);
			cell2r5.setCellStyle(arial8LT);
			cell2r5.setCellValue("Банк получателя");
			
		Row row6 = sheet.createRow(5);
			Cell cell2r6 = row6.createCell(1);
			cell2r6.setCellStyle(arial9LT);
			cell2r6.setCellValue("ИНН");
			
			Cell cell4r6 = row6.createCell(3);
			cell4r6.setCellStyle(arial9LT);
			cell4r6.setCellValue("000000000000");
			
			Cell cell10r6 = row6.createCell(9);
			cell10r6.setCellStyle(arial9LT);
			cell10r6.setCellValue("КПП");
		
			Cell cell17r6 = row6.createCell(16);
			cell17r6.setCellStyle(arial9LT);
			cell17r6.setCellValue("Сч. №");
			
			Cell cell20r6 = row6.createCell(19);
			cell20r6.setCellStyle(arial9LT);
			cell20r6.setCellValue("00000000000000000000");
			
		Row row7 = sheet.createRow(6);
			Cell cell2r7 = row7.createCell(1);
			cell2r7.setCellStyle(arial9LT);
			cell2r7.setCellValue("ИП Иванов Иван Иванович");
			
		Row row9 = sheet.createRow(8);
			Cell cell2r9 = row9.createCell(1);
			cell2r9.setCellStyle(arial8LT);
			cell2r9.setCellValue("Получатель");
		
		//Границы
		//Верхнии границы
		RegionUtil.setBorderTop(BorderStyle.THIN , CellRangeAddress.valueOf("$B$3:$AB$3"), sheet);
		RegionUtil.setBorderTop(BorderStyle.THIN , CellRangeAddress.valueOf("$B$6:$AB$6"), sheet);
		RegionUtil.setBorderTop(BorderStyle.THIN , CellRangeAddress.valueOf("$B$10:$AB$10"), sheet);
		
		RegionUtil.setBorderTop(BorderStyle.THIN , CellRangeAddress.valueOf("$B$7:$P$7"), sheet);
		
		RegionUtil.setBorderTop(BorderStyle.THIN , CellRangeAddress.valueOf("$Q$4:$S$4"), sheet);
		
		//Правые границы
		RegionUtil.setBorderRight(BorderStyle.THIN , CellRangeAddress.valueOf("$A$3:$A$9"), sheet);
		RegionUtil.setBorderRight(BorderStyle.THIN , CellRangeAddress.valueOf("$P$3:$P$9"), sheet);
		RegionUtil.setBorderRight(BorderStyle.THIN , CellRangeAddress.valueOf("$S$3:$S$9"), sheet);
		RegionUtil.setBorderRight(BorderStyle.THIN , CellRangeAddress.valueOf("$AB$3:$AB$9"), sheet);
		
		RegionUtil.setBorderRight(BorderStyle.THIN , CellRangeAddress.valueOf("$I$6"), sheet);
		
	//Заголовок
		sheet.addMergedRegion(new CellRangeAddress(10, 11, 1, 27));
		Row row11 = sheet.createRow(10);
		Cell cell1r11 = row11.createCell(1);
		cell1r11.setCellStyle(arial14LCB);
		cell1r11.setCellValue("Счет на оплату № 0 от 00 января 0000 г.");		
		
		int c = denominationList.size(); //Количество наименований
		
		//Условия
		sheet.addMergedRegion(new CellRangeAddress(24 + c, 24 + c, 1, 27));
		Row rowCondition = sheet.createRow(24 + c);
		rowCondition.setHeightInPoints((float) 47);
		Cell cellCondition = rowCondition.createCell(1);
		cellCondition.setCellStyle(arial9LTW);
		cellCondition.setCellValue("Оплата данного счета означает согласие с условиями поставки товара.\r\n"
				+ "Уведомление об оплате обязательно, в противном случае не гарантируется наличие товара на складе.\r\n"
				+ "Товар отпускается по факту прихода денег на р/с Поставщика, самовывозом, при наличии доверенности и\r\n"
				+ "паспорта.");
		
		//Подпись
		Row rowSignation = sheet.createRow(28 + c);
		Cell cellSignature1 = rowSignation.createCell(1);
		cellSignature1.setCellStyle(arial9LTB);
		cellSignature1.setCellValue("Руководитель");
		
		Cell cellSignature2 = rowSignation.createCell(13);
		cellSignature2.setCellStyle(arial8LT);
		cellSignature2.setCellValue("Иванов И.И.");
		
		RegionUtil.setBorderTop(BorderStyle.THIN , CellRangeAddress.valueOf("$F$" + (30 + c) + ":$P$" + (30 + c)), sheet);
	}
}
