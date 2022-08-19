package com.deekol.trafficdocsrest.utils.docs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 
 * @author Den Kolodkin
 * dekolodkin@gmail.com
 */

public class DocsUtils {
	/* String itinerary, LocalDate date, int quantity, String quantityUnit, BigDecimal price */
	/* ArrayList<TripEntity> */
	
//	ArrayList<TripDto> tripDto = new ArrayList<>();
//	
//	BigDecimal bd1 = new BigDecimal(1200);
//	TripDto tripDto1 = new TripDto("Перевозка груза 11.02.22", 3, "ч", bd1);
//	
//	BigDecimal bd2 = new BigDecimal(7000);
//	TripDto tripDto2 = new TripDto("Перевозка груза 09.04.22 по г. Челябинск", 1, "шт", bd2);
//	
//	BigDecimal bd3 = new BigDecimal(25000);
//	TripDto tripDto3 = new TripDto("Перевозка груза 09.04.22 г. Челябинск - г. Екатеринбург", 2, "шт", bd3);
	
	public static void createDocsUtil(/* List<List<Object>> denominationList */) {
		//Тело		
				List<Object> firstDenimunation = new ArrayList<>();
				firstDenimunation.add("Перевозка груза");
				firstDenimunation.add(3);
				firstDenimunation.add("ч.");
				firstDenimunation.add(1200.0);
				
				List<Object> secondDenimunation = new ArrayList<>();
				secondDenimunation.add("Перевозка груза по г. Челябинск");
				secondDenimunation.add(1);
				secondDenimunation.add("шт.");
				secondDenimunation.add(7000.0);
				
				List<Object> thirdDenimunation = new ArrayList<>();
				thirdDenimunation.add("Перевозка груза г. Челябинск - г. Екатеринбург");
				thirdDenimunation.add(2);
				thirdDenimunation.add("шт.");
				thirdDenimunation.add(25000.0);
				
				List<List<Object>> denominationList = new ArrayList<>();
				denominationList.add(firstDenimunation);
				denominationList.add(secondDenimunation);
				denominationList.add(thirdDenimunation);
				
				
				Workbook wb = new HSSFWorkbook();
				
				Sheet sheet1 = wb.createSheet("Счет");
				Sheet sheet2 = wb.createSheet("Акт");
				
				try {
					Bill.sheetFilling(wb, sheet1, denominationList);
					Act.sheetFilling(wb, sheet2, denominationList);
					FileOutputStream fos = new FileOutputStream("docs.xls");
					wb.write(fos);
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}
