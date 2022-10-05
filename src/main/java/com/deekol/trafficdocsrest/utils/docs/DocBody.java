package com.deekol.trafficdocsrest.utils.docs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import com.deekol.trafficdocsrest.domain.CounterpartyEntity;
import com.deekol.trafficdocsrest.domain.TripEntity;

public class DocBody {
	int startRow;
	Workbook wb;
	Sheet sheet;
	List<TripEntity> denominationList;
	
	DocBody(Workbook wb, Sheet sheet,  int startRow, List<TripEntity> denominationList) {
		this.wb = wb;
		this.sheet = sheet;
		this.startRow = startRow;
		this.denominationList = denominationList;
	}
	
	public void bodyFilling() throws IOException {
		//Шрифты
		CellStyle arial9CCN = FontStyles.createArial9CCN(wb);
		CellStyle arial9LT = FontStyles.createArial9LT(wb);
		CellStyle arial9LTB = FontStyles.createArial9LTB(wb);
		CellStyle arial9LTBW = FontStyles.createArial9LTBW(wb);
		CellStyle arial9CCB = FontStyles.createArial9CCB(wb);
		CellStyle arial9RCB = FontStyles.createArial9RCB(wb);
		CellStyle arial9RCBN = FontStyles.createArial9RCBN(wb);
	
	//Sheet1
	//Ширина столбцов
		//Столбец 1
		sheet.setColumnWidth(0, 260); //Ширина 1 столбца 0.61
		//Столбцы с 1-28 (2.64)
		for(int i = 1; i < 28; i++) {
			sheet.setColumnWidth(i, 850);
		}
	//Высотность рядов
		//Ряд 1-58 (11.3)
		for(int i = 0; i < 58; i++) {
			Row row = sheet.createRow(i);
			row.setHeightInPoints((float) 11.3);
		}
	
		//Границы
		//Верхнии границы
		RegionUtil.setBorderTop(BorderStyle.MEDIUM , CellRangeAddress.valueOf("$B$" +(startRow+3)+":$AB$" +(startRow+3)), sheet);
		
	//Поставщик
		sheet.addMergedRegion(new CellRangeAddress(startRow+3, startRow+3, 5, 27));
		Row row14 = sheet.createRow(startRow+3);
		row14.setHeightInPoints((float) 35.3);
		Cell cell2r14 = row14.createCell(1);
		cell2r14.setCellStyle(arial9LT);
		cell2r14.setCellValue("Поставщик:");
		
		Cell cell6r14 = row14.createCell(5);
		cell6r14.setCellStyle(arial9LTBW);
		
		//Описание поставщика
		CounterpartyEntity contractor = denominationList.get(0).getCounterpartyEntityContractor();
		String contractorBusinessStructure = contractor.getEBusinessStructure().toString();
		String contractorName = contractor.getName();
		String contractorDescription = contractorBusinessStructure + " " + contractorName + ", ";
		
		cell6r14.setCellValue(contractorDescription);
		
		
	//Покупатель
		sheet.addMergedRegion(new CellRangeAddress(startRow+5, startRow+5, 5, 27));
		Row row16 = sheet.createRow(startRow+5);
		row16.setHeightInPoints((float) 35.3);
		Cell cell2r16 = row16.createCell(1);
		cell2r16.setCellStyle(arial9LT);
		cell2r16.setCellValue("Покупатель:");
		
		Cell cell6r16 = row16.createCell(5);
		cell6r16.setCellStyle(arial9LTBW);
		
		//Описание поставщика
		CounterpartyEntity consumer = denominationList.get(0).getCounterpartyEntityConsumer();
		String consumerBusinessStructure = consumer.getEBusinessStructure().toString();
		String consumerName = consumer.getName();
		String consumerDescription = consumerBusinessStructure + " " + consumerName + ", ";
		
		cell6r16.setCellValue(consumerDescription);
		
	//Услуги
		//Шапка
		sheet.addMergedRegion(new CellRangeAddress(startRow+7, startRow+7, 2, 15));
		sheet.addMergedRegion(new CellRangeAddress(startRow+7, startRow+7, 16, 17));
		sheet.addMergedRegion(new CellRangeAddress(startRow+7, startRow+7, 18, 19));
		sheet.addMergedRegion(new CellRangeAddress(startRow+7, startRow+7, 20, 23));
		sheet.addMergedRegion(new CellRangeAddress(startRow+7, startRow+7, 24, 27));
		
		Row row18 = sheet.createRow(startRow+7);
		Cell cell2r18 = row18.createCell(1);
		cell2r18.setCellStyle(arial9CCB);
		cell2r18.setCellValue("№");
		
		Cell cell3r18 = row18.createCell(2);
		cell3r18.setCellStyle(arial9CCB);
		cell3r18.setCellValue("Товары (работы, услуги)");
		
		Cell cell17r18 = row18.createCell(16);
		cell17r18.setCellStyle(arial9CCB);
		cell17r18.setCellValue("Кол-во");
		
		Cell cell17r19 = row18.createCell(18);
		cell17r19.setCellStyle(arial9CCB);
		cell17r19.setCellValue("Ед.");
		
		Cell cell17r21 = row18.createCell(20);
		cell17r21.setCellStyle(arial9CCB);
		cell17r21.setCellValue("Цена");
		
		Cell cell25r18 = row18.createCell(24);
		cell25r18.setCellStyle(arial9CCB);
		cell25r18.setCellValue("Сумма");
		
		int c = denominationList.size(); //Кол-во наименований
		
		//Заполняем тело
		createDenomination(wb, sheet, denominationList, startRow);
		
		//Сумма
		Row rowSum = sheet.createRow(startRow+8+c);
		Cell cellSum1 = rowSum.createCell(23);
		cellSum1.setCellStyle(arial9RCB);
		cellSum1.setCellValue("Итого:");
		
		sheet.addMergedRegion(new CellRangeAddress(startRow+8+c, startRow+8+c, 24, 27));
		Cell cellSum2 = rowSum.createCell(24);
		cellSum2.setCellStyle(arial9RCBN);
		cellSum2.setCellFormula("SUM(Y"+(startRow+9)+":Y"+(startRow+8+c)+")");
		
		//НДС
		Row rowNds = sheet.createRow(startRow+9+c);
		Cell cellSum3 = rowNds.createCell(23);
		cellSum3.setCellStyle(arial9RCB);
		cellSum3.setCellValue("Без налога (НДС)");
		
		Cell cellSum4 = rowNds.createCell(27);
		cellSum4.setCellStyle(arial9RCB);
		cellSum4.setCellValue("-");
		
		//К оплате
		Row rowPay = sheet.createRow(startRow+10+c);
		Cell cellSum5 = rowPay.createCell(23);
		cellSum5.setCellStyle(arial9RCB);
		cellSum5.setCellValue("Всего к оплате:");
		
		sheet.addMergedRegion(new CellRangeAddress(startRow+10+c, startRow+10+c, 24, 27));
		Cell cellSum6 = rowPay.createCell(24);
		cellSum6.setCellStyle(arial9RCBN);
		cellSum6.setCellFormula("SUM(Y"+(startRow+9)+":Y"+(startRow+8+c)+")");
		
		//Всего наименований
		Row rowAllDenomination = sheet.createRow(startRow+11+c);
		Cell cellAllDenomination1 = rowAllDenomination.createCell(1);
		cellAllDenomination1.setCellStyle(arial9LT);
		cellAllDenomination1.setCellValue("Всего наименований " + c + ", на сумму");
		
		sheet.addMergedRegion(new CellRangeAddress(startRow+11+c, startRow+11+c, 9, 12));
		Cell cellAllDenomination2 = rowAllDenomination.createCell(9);
		cellAllDenomination2.setCellStyle(arial9CCN);
		cellAllDenomination2.setCellFormula("SUM(Y"+(startRow+9)+":Y"+(startRow+8+c)+")");
		
		sheet.addMergedRegion(new CellRangeAddress(startRow+11+c, startRow+11+c, 13, 14));
		Cell cellAllDenomination3 = rowAllDenomination.createCell(13);
		cellAllDenomination3.setCellStyle(arial9LT);
		cellAllDenomination3.setCellValue("руб.");
		
		//Сумма прописью
		String numS = MoneyInWords.inwords(allSum(denominationList));
		String numSU = numS.substring(0, 1).toUpperCase() + numS.substring(1);
		Row rowMoneyInWords = sheet.createRow(startRow+12+c);
		Cell cellMoneyInWords = rowMoneyInWords.createCell(1);
		cellMoneyInWords.setCellStyle(arial9LTB);
		cellMoneyInWords.setCellValue(numSU);
		
		//Границы подвижные
		//Верхнии
		RegionUtil.setBorderTop(BorderStyle.MEDIUM , CellRangeAddress.valueOf("$B$"+(startRow+8)+":$AB$"+(startRow+8)), sheet);
		RegionUtil.setBorderTop(BorderStyle.MEDIUM , CellRangeAddress.valueOf("$B$"+(startRow+9)+":$AB$"+(startRow+9)), sheet);
		for(int i = 1; i <= c; i++) {
			RegionUtil.setBorderTop(BorderStyle.THIN , CellRangeAddress.valueOf("$B$" + (startRow+9 + i) + ":$AB$" + (startRow+9 + i)), sheet);
		}
		RegionUtil.setBorderTop(BorderStyle.MEDIUM , CellRangeAddress.valueOf("$B$" + (startRow+9 + c) + ":$AB$" + (startRow+9 + c)), sheet);
		RegionUtil.setBorderTop(BorderStyle.MEDIUM , CellRangeAddress.valueOf("$B$" + (startRow+18 + c) + ":$AB$" + (startRow+18 + c)), sheet);

		RegionUtil.setBorderRight(BorderStyle.MEDIUM, CellRangeAddress.valueOf("$A$"+(startRow+8)+":$A$" + (startRow+8 + c)), sheet);
		RegionUtil.setBorderRight(BorderStyle.MEDIUM, CellRangeAddress.valueOf("$AB$"+(startRow+8)+":$AB$" + (startRow+8 + c)), sheet);
		
		RegionUtil.setBorderRight(BorderStyle.THIN, CellRangeAddress.valueOf("$B$"+(startRow+8)+":$B$" + (startRow+8 + c)), sheet);
		RegionUtil.setBorderRight(BorderStyle.THIN, CellRangeAddress.valueOf("$P$"+(startRow+8)+":$P$" + (startRow+8 + c)), sheet);
		RegionUtil.setBorderRight(BorderStyle.THIN, CellRangeAddress.valueOf("$R$"+(startRow+8)+":$R$" + (startRow+8 + c)), sheet);
		RegionUtil.setBorderRight(BorderStyle.THIN, CellRangeAddress.valueOf("$T$"+(startRow+8)+":$T$" + (startRow+8 + c)), sheet);
		RegionUtil.setBorderRight(BorderStyle.THIN, CellRangeAddress.valueOf("$X$"+(startRow+8)+":$X$" + (startRow+8 + c)), sheet);
	}
	
	//Создание тела
	private static void createDenomination(Workbook wb, Sheet sheet, List<TripEntity> list, int startRow) {
		//Шрифты
		CellStyle arial8CT = FontStyles.createArial8CT(wb);
		CellStyle arial8LTW = FontStyles.createArial8LTW(wb);
		CellStyle arial8RT = FontStyles.createArial8RT(wb);
		CellStyle arial8RTN = FontStyles.createArial8RTN(wb);
		
		int i = 0;
		for(TripEntity denomination : list) {
			sheet.addMergedRegion(new CellRangeAddress(startRow+8+i, startRow+8+i, 2, 15));
			sheet.addMergedRegion(new CellRangeAddress(startRow+8+i, startRow+8+i, 16, 17));
			sheet.addMergedRegion(new CellRangeAddress(startRow+8+i, startRow+8+i, 18, 19));
			sheet.addMergedRegion(new CellRangeAddress(startRow+8+i, startRow+8+i, 20, 23));
			sheet.addMergedRegion(new CellRangeAddress(startRow+8+i, startRow+8+i, 24, 27));
			
			Row row = sheet.createRow(startRow+8+i);
			
			String tripDescription = "Перевозка груза " + denomination.getDate() + " " + denomination.getItinerary();
			
			if (tripDescription.length() > 50) {
				row.setHeightInPoints((float) 22.6);
			}
			
			Cell cell2r = row.createCell(1);
			cell2r.setCellStyle(arial8CT);
			cell2r.setCellValue(1+i);
			
			Cell cell3 = row.createCell(2);
			cell3.setCellStyle(arial8LTW);
			cell3.setCellValue(tripDescription);
			
			Cell cell17 = row.createCell(16);
			cell17.setCellStyle(arial8RT);
			cell17.setCellValue((int)denomination.getQuantity());
			
			Cell cell19 = row.createCell(18);
			cell19.setCellStyle(arial8RT);
			cell19.setCellValue(denomination.getEQuantityUnit().getTitle());
			
			Cell cell21 = row.createCell(20);
			cell21.setCellStyle(arial8RTN);
			cell21.setCellValue(denomination.getPrice().doubleValue());
			
			Cell cell25 = row.createCell(24);
			cell25.setCellStyle(arial8RTN);
			cell25.setCellFormula((String)("Q" + (startRow+9+i) + "*U" + (startRow+9+i)));
			i++;
		}
	}
	
	//Подсчет полной суммы услуг
	private static double allSum(List<TripEntity> list) {
		List<Double> listd = new ArrayList<>();
		double i = 0;
		for(TripEntity e : list) {
			int q = (int) e.getQuantity();
			double price = e.getPrice().doubleValue();
			double fullPrice = q * price;
			listd.add(fullPrice);
		}
		for(Double e : listd) {
			i = i + e;
		}
		return i;
	}
}
