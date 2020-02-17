package com.sunbeam.rest.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunbeam.rest.entities.Customer;

public class CustomerDao extends Dao{
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT id, name, password, email, mobile, address FROM CUSTOMERS WHERE email=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery()){
				Customer c= new Customer();
				if(rs.next()) {
					c.setId(rs.getInt("Id"));
					c.setName(rs.getString("name"));
					c.setPassword(rs.getString("password"));
					c.setEmail(rs.getString("email"));
					c.setMobile(rs.getString("mobile"));
					c.setAddress(rs.getString("address"));
					return c;

				}
			}
			
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
