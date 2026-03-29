package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public  String data;
	public  FileInputStream fi;
	public  FileOutputStream fo;
	public  Workbook w;
	public  Sheet s;
	public  Row r;
	public  Cell c;


	public  int getRowcount(String f,int n) {
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			w = WorkbookFactory.create(fi);
			//w = new XSSFWorkbook(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		s = (Sheet) w.getSheetAt(n);
		 //s = (XSSFSheet) w.getSheetAt(n);
		 int rowcount = s.getLastRowNum();
		 try {
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 try {
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return rowcount;
	}

	public  int getCellcount(String f,int n,int rn) {
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			w = WorkbookFactory.create(fi);
			//w = new XSSFWorkbook(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		s = (Sheet) w.getSheetAt(n);
		 //s = (XSSFSheet) w.getSheetAt(n);
		 r = s.getRow(rn);
		 int cellcount = r.getLastCellNum();
		 try {
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 try {
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return cellcount;
	}

	public  String getCelldata(String f,int n,int rn,int cn) {
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			w = WorkbookFactory.create(fi);
			//w = new XSSFWorkbook(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		s = (Sheet) w.getSheetAt(n);
		 //s = (XSSFSheet) w.getSheetAt(n);
		 r = s.getRow(rn);
		 c = r.getCell(cn);
		 if (r == null) return "";
		 if (c == null) return "";
		 CellType type = c.getCellType();

		 switch(type) {
		 case STRING: data = c.getStringCellValue();
			 break;
		case FORMULA:data = c.getCellFormula();
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(c)) {
			Date datecell = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
			data = sim.format(datecell);
			}
			else {
				double numeric = c.getNumericCellValue();
				long l = (long)numeric;
				data = String.valueOf(l);
			}
			break;
		default: data = c.getStringCellValue();
			break;
		 }
		 try {
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 try {
				fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return data;
	}

	public  void setCelldata(String f,int n,int rn,int cn,String data) {
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			w = WorkbookFactory.create(fi);
			//w = new XSSFWorkbook(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		s = (Sheet) w.getSheetAt(n);
		//s = (XSSFSheet) w.getSheetAt(n);
		r = s.getRow(rn);
		c = r.createCell(cn);
		c.setCellValue(data);
		try {
			fo = new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			w.write(fo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
