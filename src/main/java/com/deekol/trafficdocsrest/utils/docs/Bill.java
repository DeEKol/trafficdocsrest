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

import com.deekol.trafficdocsrest.domain.DocsEntity;
import com.deekol.trafficdocsrest.domain.TripEntity;

/**
 * Класс Счёт.
 * Метод sheetFilling создаёт лист со счётом.
 * @author Den Kolodkin
 * dekolodkin@gmail.com
 */

public class Bill {	
	static void sheetFilling(Workbook wb, Sheet sheet, List<TripEntity> denominationList) throws IOException {
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
			
			DocsEntity docs = denominationList.get(0).getDocsEntity();
			String bankBS = docs.getCounterpartyEntityContractor().getEBusinessStructureBank().toString();
			String bankName = docs.getCounterpartyEntityContractor().getBank();
			String bankDescr = bankBS + " «" + bankName + "»";
			
			//Описание банка
			cell2r3.setCellValue(bankDescr);
			
			Cell cell17r3 = row3.createCell(16);
			cell17r3.setCellStyle(arial9LT);
			cell17r3.setCellValue("БИК");
			
			Cell cell20r3 = row3.createCell(19);
			cell20r3.setCellStyle(arial9LT);
			//бик
			cell20r3.setCellValue(docs.getCounterpartyEntityContractor().getBik());
			
		Row row4 = sheet.createRow(3);
			Cell cell17r4 = row4.createCell(16);
			cell17r4.setCellStyle(arial9LT);
			cell17r4.setCellValue("Сч. №");
			
			Cell cell20r4 = row4.createCell(19);
			cell20r4.setCellStyle(arial9LT);
			//Счет банка
			cell20r4.setCellValue(docs.getCounterpartyEntityContractor().getAccountOfBank());
		
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
			//Инн
			cell4r6.setCellValue(docs.getCounterpartyEntityContractor().getInn());
			
			Cell cell10r6 = row6.createCell(9);
			cell10r6.setCellStyle(arial9LT);
			cell10r6.setCellValue("КПП");
			
			Cell cell12r6 = row6.createCell(11);
			cell12r6.setCellStyle(arial9LT);
			//Кпп
			cell12r6.setCellValue(docs.getCounterpartyEntityContractor().getKpp());
		
			Cell cell17r6 = row6.createCell(16);
			cell17r6.setCellStyle(arial9LT);
			cell17r6.setCellValue("Сч. №");
			
			Cell cell20r6 = row6.createCell(19);
			cell20r6.setCellStyle(arial9LT);
			//Счет
			cell20r6.setCellValue(docs.getCounterpartyEntityContractor().getAccount());
			
		Row row7 = sheet.createRow(6);
			Cell cell2r7 = row7.createCell(1);
			cell2r7.setCellStyle(arial9LT);
			
			String contractorBS = docs.getCounterpartyEntityContractor().getEBusinessStructure().toString();
			String contractorName = docs.getCounterpartyEntityContractor().getName();
			String contractorDescr = contractorBS + " " + contractorName;
			
			//Описание поставщика
			cell2r7.setCellValue(contractorDescr);
			
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
		
		DocsEntity docsEntity = denominationList.get(0).getDocsEntity();
		long numberAct = docsEntity.getId();
		int dayAct = docsEntity.getDate().getDayOfMonth();
		String monthAct = DocsUtils.monthEngToRu(docsEntity.getDate().getMonth());
		int yearAct = docsEntity.getDate().getYear();
		
		cell1r11.setCellValue("Счет на оплату № " + numberAct + " от " + dayAct + " " + monthAct + " " + yearAct + " г.");		
		
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
//		cellSignature2.setCellValue("Иванов И.И.");
		
		RegionUtil.setBorderTop(BorderStyle.THIN , CellRangeAddress.valueOf("$F$" + (30 + c) + ":$P$" + (30 + c)), sheet);
	}
}
