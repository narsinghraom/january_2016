package example.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;





import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import bean.ZipBean;

public class ReadExcel1 {
	HSSFWorkbook workbook=null;
	FileInputStream file=null;
	Connection con=null;
	PreparedStatement pst=null;
	String state=null;
	String country=null;
	String prim_city=null;
	ResultSet rs=null;
	public ReadExcel1()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/excelDB", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	public  void storeInDB() throws  FileNotFoundException,IOException,InterruptedException, SQLException
	{
		
		
		 int i=0;
		try
		{
			
		
		pst=con.prepareStatement("insert into zipdata values(?,?,?,?,?,?)");
		 file = new FileInputStream(new File("E:/Ds-1140_WorkSpace/ReadExcel/zip_code_database.xls"));
		 workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> row = sheet.iterator();
		 row.next();
		 
		while(row.hasNext()) {
	        Row row1 = row.next();
	        int zip=(int)row1.getCell(0).getNumericCellValue();
	        
	        
	        
	        double longitude=(double)row1.getCell(9).getNumericCellValue();
	        double latitude=(double)row1.getCell(10).getNumericCellValue();
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
	       pst.setString(2,prim_city);
	       pst.setString(3,state);
	       pst.setString(4,country);
	       pst.setDouble(5, latitude);
	       pst.setDouble(6, longitude);
	       
	   i= pst.executeUpdate();
	    i++;
	        System.out.println(i+ " Data Inserted");
	        	
	        
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
		ReadExcel1 xl=new ReadExcel1();
		xl.storeInDB();

	}
	
	public  ArrayList<ZipBean> getDetails(int zip)
	{
		ArrayList<ZipBean> arrayemployee = null;
		try {
			ZipBean zipbean;
			
			arrayemployee = new ArrayList<ZipBean>();
			pst = con.prepareStatement("select * from zipdata where zip=?");
			pst.setInt(1, zip);
			rs = pst.executeQuery();
			while (rs.next()) {
				zipbean = new ZipBean();
				zipbean.setZip(rs.getInt(1));
				zipbean.setState(rs.getString(2));
				zipbean.setCountry(rs.getString(3));
				zipbean.setCity(rs.getString(4));
				zipbean.setLatitude(rs.getDouble(5));
				zipbean.setLongitude(rs.getDouble(6));

				arrayemployee.add(zipbean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return arrayemployee;
	}

}
