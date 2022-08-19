package com.deekol.trafficdocsrest.utils.docs;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Класс хранящий Шрифты.
 * Методы класса создают шрифты.
 * @author Den Kolodkin
 * dekolodkin@gmail.com
 */

/*
 * Шрифты:
 * Arial8:
 * 	+LT(Horizontal-Left, Vertical-Top)
 * 	+LTW(Horizontal-Left, Vertical-Top)+W(Wrap)
 * 	+CT(Horizontal-Center, Vertical-Top)
 * 	+RT(Horizontal-Right, Vertical-Top)
 * 	+RTN(Horizontal-Right, Vertical-Top)+N(Numeric)
 * Arial9:
 * 	+CCN(Horizontal-Central, Vertical-Center)+N(Numeric)
 * 	+LT(Horizontal-Left, Vertical-Top)
 * 		+LTW(Horizontal-Left, Vertical-Top)+W(Wrap)
 * 		+LTB(Horizontal-Left, Vertical-Top)+B(Bold)
 * 		+LTBW(Horizontal-Left, Vertical-Top)+B(Bold)+W(Wrap)
 * 	+CCB(Horizontal-Central, Vertical-Center)+B(Bold)
 * 	+RCB(Horizontal-Right, Vertical-Center)+B(Bold)
 * 		+RCBN(Horizontal-Right, Vertical-Center)+B(Bold)+N(Numeric)
 * Arial11LCB(Horizontal-Left, Vertical-Center)+B
 * Arial14LCB(Horizontal-Left, Vertical-Center)+B
 */

public class FontStyles {
	private static Font createFontArial8(Workbook wb) {
		Font arial8 = wb.createFont();
		arial8.setFontName("Arial");
		arial8.setFontHeightInPoints((short) 8);
		return arial8;
	}
	private static Font createFontArial9(Workbook wb) {
		Font arial9 = wb.createFont();
		arial9.setFontName("Arial");
		arial9.setFontHeightInPoints((short) 9);
		return arial9;
	}
	private static Font createFontArial9B(Workbook wb) {
		Font arial9B = wb.createFont();
		arial9B.setFontName("Arial");
		arial9B.setFontHeightInPoints((short) 9);
		arial9B.setBold(true);
		return arial9B;
	}
	private static Font createFontArial11B(Workbook wb) {
		Font arial11B = wb.createFont();
		arial11B.setFontName("Arial");
		arial11B.setFontHeightInPoints((short) 11);
		arial11B.setBold(true);
		return arial11B;
	}
	private static Font createFontArial14B(Workbook wb) {
		Font arial14B = wb.createFont();
		arial14B.setFontName("Arial");
		arial14B.setFontHeightInPoints((short) 14);
		arial14B.setBold(true);
		return arial14B;
	}
	
	static CellStyle createArial8LT(Workbook wb) {
		CellStyle styleArial8LT = wb.createCellStyle();
		styleArial8LT.setFont(createFontArial8(wb));
		styleArial8LT.setAlignment(HorizontalAlignment.LEFT);
		styleArial8LT.setVerticalAlignment(VerticalAlignment.TOP);
		return styleArial8LT;
	}
	static CellStyle createArial8LTW(Workbook wb) {
		CellStyle styleArial8LTW = wb.createCellStyle();
		styleArial8LTW.setFont(createFontArial8(wb));
		styleArial8LTW.setAlignment(HorizontalAlignment.LEFT);
		styleArial8LTW.setVerticalAlignment(VerticalAlignment.TOP);
		styleArial8LTW.setWrapText(true);
		return styleArial8LTW;
	}
	static CellStyle createArial8CT(Workbook wb) {
		CellStyle styleArial8CT = wb.createCellStyle();
		styleArial8CT.setFont(createFontArial8(wb));
		styleArial8CT.setAlignment(HorizontalAlignment.CENTER);
		styleArial8CT.setVerticalAlignment(VerticalAlignment.TOP);
		return styleArial8CT;
	}
	static CellStyle createArial8RT(Workbook wb) {
		CellStyle styleArial8RT = wb.createCellStyle();
		styleArial8RT.setFont(createFontArial8(wb));
		styleArial8RT.setAlignment(HorizontalAlignment.RIGHT);
		styleArial8RT.setVerticalAlignment(VerticalAlignment.TOP);
		return styleArial8RT;
	}
	static CellStyle createArial8RTN(Workbook wb) {
		CellStyle styleArial8RTN = wb.createCellStyle();
		styleArial8RTN.setFont(createFontArial8(wb));
		styleArial8RTN.setAlignment(HorizontalAlignment.RIGHT);
		styleArial8RTN.setVerticalAlignment(VerticalAlignment.TOP);
		styleArial8RTN.setDataFormat(wb.createDataFormat().getFormat("#,##0.00"));
		return styleArial8RTN;
	}
	static CellStyle createArial9CCN(Workbook wb) {
		CellStyle styleArial9CCN = wb.createCellStyle();
		styleArial9CCN.setVerticalAlignment(VerticalAlignment.CENTER);
		styleArial9CCN.setAlignment(HorizontalAlignment.CENTER);
		styleArial9CCN.setFont(createFontArial9(wb));
		styleArial9CCN.setDataFormat(wb.createDataFormat().getFormat("#,##0.00"));
		return styleArial9CCN;
	}
	static CellStyle createArial9LT(Workbook wb) {
		CellStyle styleArial9LT = wb.createCellStyle();
		styleArial9LT.setFont(createFontArial9(wb));
		styleArial9LT.setAlignment(HorizontalAlignment.LEFT);
		styleArial9LT.setVerticalAlignment(VerticalAlignment.TOP);
		return styleArial9LT;
	}
	static CellStyle createArial9LTW(Workbook wb) {
		CellStyle styleArial9LTW = wb.createCellStyle();
		styleArial9LTW.setFont(createFontArial9(wb));
		styleArial9LTW.setAlignment(HorizontalAlignment.LEFT);
		styleArial9LTW.setVerticalAlignment(VerticalAlignment.TOP);
		styleArial9LTW.setWrapText(true);
		return styleArial9LTW;
	}
	static CellStyle createArial9LTB(Workbook wb) {
		CellStyle styleArial9LTB = wb.createCellStyle();
		styleArial9LTB.setFont(createFontArial9B(wb));
		styleArial9LTB.setAlignment(HorizontalAlignment.LEFT);
		styleArial9LTB.setVerticalAlignment(VerticalAlignment.TOP);
		return styleArial9LTB;
	}
	static CellStyle createArial9LTBW(Workbook wb) {
		CellStyle styleArial9LTBW = wb.createCellStyle();
		styleArial9LTBW.setFont(createFontArial9B(wb));
		styleArial9LTBW.setAlignment(HorizontalAlignment.LEFT);
		styleArial9LTBW.setVerticalAlignment(VerticalAlignment.TOP);
		styleArial9LTBW.setWrapText(true);
		return styleArial9LTBW;
	}
	static CellStyle createArial9CCB(Workbook wb) {
		CellStyle styleArial9CCB = wb.createCellStyle();
		styleArial9CCB.setAlignment(HorizontalAlignment.CENTER);
		styleArial9CCB.setVerticalAlignment(VerticalAlignment.CENTER);
		styleArial9CCB.setFont(createFontArial9B(wb));
		return styleArial9CCB;
	}
	static CellStyle createArial9RCB(Workbook wb) {
		CellStyle styleArial9RCB = wb.createCellStyle();
		styleArial9RCB.setAlignment(HorizontalAlignment.RIGHT);
		styleArial9RCB.setVerticalAlignment(VerticalAlignment.CENTER);
		styleArial9RCB.setFont(createFontArial9B(wb));
		return styleArial9RCB;
	}
	static CellStyle createArial9RCBN(Workbook wb) {
		CellStyle styleArial9RCBN = wb.createCellStyle();
		styleArial9RCBN.setAlignment(HorizontalAlignment.RIGHT);
		styleArial9RCBN.setVerticalAlignment(VerticalAlignment.CENTER);
		styleArial9RCBN.setFont(createFontArial9B(wb));
		styleArial9RCBN.setDataFormat(wb.createDataFormat().getFormat("#,##0.00"));
		return styleArial9RCBN;
	}
	static CellStyle createArial11LCB(Workbook wb) {
		CellStyle styleArial11LCB = wb.createCellStyle();
		styleArial11LCB.setAlignment(HorizontalAlignment.LEFT);
		styleArial11LCB.setVerticalAlignment(VerticalAlignment.CENTER);
		styleArial11LCB.setFont(createFontArial11B(wb));
		return styleArial11LCB;
	}
	static CellStyle createArial14LCB(Workbook wb) {
		CellStyle styleArial14LCB = wb.createCellStyle();
		styleArial14LCB.setAlignment(HorizontalAlignment.LEFT);
		styleArial14LCB.setVerticalAlignment(VerticalAlignment.CENTER);
		styleArial14LCB.setFont(createFontArial14B(wb));
		return styleArial14LCB;
	}
}
