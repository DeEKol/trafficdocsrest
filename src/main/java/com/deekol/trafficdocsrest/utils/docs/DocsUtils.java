package com.deekol.trafficdocsrest.utils.docs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Month;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deekol.trafficdocsrest.domain.TripEntity;
import com.deekol.trafficdocsrest.repository.TripRepository;

/**
 * 
 * @author Den Kolodkin
 * dekolodkin@gmail.com
 */

@Service
public class DocsUtils {
	private final TripRepository tripRepository;
	
	@Autowired
	public DocsUtils(TripRepository tripRepository) {
		this.tripRepository = tripRepository;
	}
	
	public void createDocsUtil() {
		List<TripEntity> tripEntityList = tripRepository.findTripByDocsId(1L);
				
				
				Workbook wb = new HSSFWorkbook();
				
				Sheet sheet1 = wb.createSheet("Счет");
				Sheet sheet2 = wb.createSheet("Акт");
				
				try {
					Bill.sheetFilling(wb, sheet1, tripEntityList);
					Act.sheetFilling(wb, sheet2, tripEntityList);
					FileOutputStream fos = new FileOutputStream("docs.xls");
					wb.write(fos);
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

	static String monthEngToRu(Month month) {
		switch (month) {
		case JANUARY: return "января";
		case FEBRUARY: return "февраля";
		case MARCH: return "марта";
		case APRIL: return "апреля";
		case MAY: return "мая";
		case JUNE: return "июня";
		case JULY: return "июля";
		case AUGUST: return "августа";
		case SEPTEMBER: return "сентября";
		case OCTOBER: return "октября";
		case NOVEMBER: return "ноября";
		case DECEMBER: return "декабря";
		}
		return null;
	}
}
