package restAssuredCommonFunctionPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class UtilitiyCommonFunction {
	@AfterTest
	public static void evidencefilecreater(String filename,String requestBody,String responseBody) throws IOException
	{
		File newfile=new File("C:\\Users\\Dell\\Desktop\\JAVA"+filename+".txt");
		System.out.println("a new txt file created to record request and response of API :" +newfile.getName());
		
		FileWriter datawrite=new FileWriter(newfile);
		datawrite.write("requestBody"+requestBody+"\n\n");
		datawrite.write("responseBody"+responseBody);
		datawrite.close();
		System.out.println("requestbody and responsebody are save in : " +newfile.getName());
		
	}
	public static ArrayList<String> readDataExcel(String sheetname,String testcasename) throws IOException
	{
		ArrayList<String> ArrayData =new ArrayList<String>();
		//Step 1: Create the object of file input stream
		FileInputStream fis=new FileInputStream("C:\\Users\\Dell\\Desktop\\JAVA\\testdata2.xlsx");
		
		//step 2: Access excel file
		XSSFWorkbook Workbook=new XSSFWorkbook(fis);
		
		//step 3: Access the sheet name
	    int countofsheet=Workbook.getNumberOfSheets();
	    for(int i=0;i<countofsheet;i++)
	    {
	    	String filesheetname=Workbook.getSheetName(i);
	    	if(filesheetname.equalsIgnoreCase(sheetname))
	    	{
	    		//step 4: access the row from where the data is suppose to fetch
	    		XSSFSheet sheet=Workbook.getSheetAt(i);
	    		Iterator<Row>rows =sheet.iterator();
	    	    // Row r=rows.next();
	    		while(rows.hasNext())
	       	{
	    			
	    			Row r2=rows.next();
	    			if(r2.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename))
	    			{
	    				Iterator<Cell>cellvalues=r2.cellIterator();
	    				while(cellvalues.hasNext())
	    				{
	    					String testdata=cellvalues.next().getStringCellValue();
	    					ArrayData.add(testdata);
	    							
	    				}
	    			}
	    		}
	    		
	    	}
	    	
	    	
	    }
		Workbook.close();
		return ArrayData;
		
	}
	}
