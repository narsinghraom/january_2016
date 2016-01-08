package example_Ajax;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DBCountry
{
	Connection connect=null;
	Statement statement;
	ResultSet resset=null;


public DBCountry()
{
	
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
		}
		catch(ClassNotFoundException classe)
		{
			System.out.println(classe);
		}
		catch (SQLException e) {
			System.out.println(e);		}
		
		
	}
}
public ArrayList<Citybean> getDetails() throws SQLException 
{
	ArrayList<Citybean> array=new ArrayList<Citybean>();
	Citybean bean=null;
	String query="select * from coutries";
	statement=connect.createStatement();
	resset=statement.executeQuery(query);
	while(resset.next())
	{
		bean=new Citybean();
		bean.setCountry(resset.getString(2));
		
		array.add(bean);
				
	}
	return array;
}

public ArrayList<Citybean> getDetails1(String name) throws SQLException 
{
	ArrayList<Citybean> array=new ArrayList<Citybean>();
	Citybean bean1=new Citybean();
	name=bean1.getStates();
	if(name=="INDIA")
	{
	String query1="select * from india_states";
	statement=connect.createStatement();
	resset=statement.executeQuery(query1);
	while(resset.next())
	{
		
		bean1.setStates(resset.getString(1));
		
		array.add(bean1);
				
	}
	
}
	return array;
}
}