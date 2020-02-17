package com.sunbeam.rest.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.rest.entities.Customer;
import com.sunbeam.rest.entities.Item;


public class ItemDao extends Dao {
	
	public List<String> findAllCatagorie(){
		String sql = "SELECT DISTINCT category FROM ITEMS";
		List<String> list = new ArrayList<String>();
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					list.add(rs.getString("category"));
				}
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	public List<Item> findItemsOfCategory(String category){
		String sql = "SELECT * FROM ITEMS WHERE category = ?";
		List<Item> list = new ArrayList<Item>();
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			stmt.setString(1, category);
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					Item item = new Item();
					item.setId(rs.getInt("ID"));
					item.setCategory(rs.getString("Category"));
					item.setInfo(rs.getString("Info"));
					item.setName(rs.getString("Name"));
					item.setPrice(rs.getDouble("Price"));
					list.add(item);
				}
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	public int addCustomer(Customer cust) throws Exception {
		String sql = "INSERT INTO CUSTOMERS(name, password, email, mobile, address) VALUES(?,?,?,?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, cust.getName());
			stmt.setString(2, cust.getPassword());
			stmt.setString(3, cust.getEmail());
			stmt.setString(4, cust.getMobile());
			stmt.setString(5, cust.getAddress());
			return stmt.executeUpdate();
		}
	}


}
