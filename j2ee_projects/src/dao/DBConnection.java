package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import bean.*;
public class DBConnection 
{
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = null;

	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public ArrayList<CountryBean> getCountry()
	{
		ArrayList<CountryBean> country_array=new ArrayList<CountryBean>();
		CountryBean country_bean=null;
		String query="select * from countries";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				country_bean=new CountryBean();
				country_bean.setCountryName(rs.getString(1));
				country_array.add(country_bean);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return country_array;
		
	}
	public ArrayList<StateBean> getState(String Country_Name)
	{
		ArrayList<StateBean> state_array=new ArrayList<StateBean>();
		StateBean state_bean=null;
		if(Country_Name.equalsIgnoreCase("india"))
		{
		String query="select * from india_states";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				state_bean=new StateBean();
				state_bean.setStateName(rs.getString(1));
				state_array.add(state_bean);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		}
		return state_array;
	}
	public ArrayList<CityBean> getCity(String State_Name)
	{
		ArrayList<CityBean> state_array=new ArrayList<CityBean>();
		CityBean city_bean=null;
		if(State_Name.equalsIgnoreCase("telangana"))
		{
		String query="select * from telangana_state";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				city_bean=new CityBean();
				city_bean.setCityName(rs.getString(1));
				state_array.add(city_bean);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		}
		return state_array;
	}



}
