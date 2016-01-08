package example.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcel {
	
	
	public Connection getConnection(String fname)
	{
		Connection con=null;
		try{
			
			
			Properties pr=new Properties();
			FileInputStream fis=new FileInputStream(fname);
			pr.load(fis);
			Class.forName(pr.getProperty("Driver"));
			con=DriverManager.getConnection(pr.getProperty("url"),pr.getProperty("username"),pr.getProperty("password"));
				
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return con;
	}
	
	
	
	
	public static void storeInDB() throws  FileNotFoundException,IOException,InterruptedException, SQLException
	{
		HSSFWorkbook workbook=null;
		FileInputStream file=null;
		Connection con=null;
		PreparedStatement pst=null;
		String state=null;
		String country=null;
		String prim_city=null;
		
		 int i=0;
		try
		{
			
		ReadExcel rxl=new ReadExcel();
		 con=rxl.getConnection("E:/Ds-1140_WorkSpace/ReadExcel/src/sql.properties");
		pst=con.prepareStatement("insert into us_zip values(?,?,?,?)");
		 file = new FileInputStream(new File("E:/Ds-1140_WorkSpace/ReadExcel/zip_code_database.xls"));
		 workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> row = sheet.iterator();
		 row.next();
		 
		while(row.hasNext()) {
	        Row row1 = row.next();
	        int zip=(int)row1.getCell(0).getNumericCellValue();
	        try{
	         state=row1.getCell(5).getStringCellValue();
	        }catch(NullPointerException ne)
	        {
	        	state=null;
	        }
	        try{
	        country=row1.getCell(6).getStringCellValue();
	        }catch(NullPointerException ne)
	        {
	        	country=null;
	        }
	        
	        try{
	         prim_city=row1.getCell(2).getStringCellValue();
	        }catch(NullPointerException ne)
	        {
	        	 prim_city=null;
	        }
	        
	        
	       pst.setInt(1,zip);
	       pst.setString(2,state);
	       pst.setString(3,country);
	       pst.setString(4,prim_city);
	       
	    pst.executeUpdate();
	    i++;
	    System.out.println(i);
	        
	        	
	        
		}
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		finally{
		//workbook.close();
		file.close();
		pst.close();
		con.close();
		
		}
		
	}
	

	public static void main(String[] args) throws FileNotFoundException,IOException,InterruptedException, SQLException
	{
		storeInDB();

	}
	

}
