package com.sunbeam.rest.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sunbeam.rest.entities.Customer;
import com.sunbeam.rest.entities.Item;

public class CartDao extends Dao{
	public List<Item> addItems(List<Item> list) {
		String sql = "SELECT id, name, password, email, mobile, address FROM CUSTOMERS WHERE email=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			//stmt.setString(1, email);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
