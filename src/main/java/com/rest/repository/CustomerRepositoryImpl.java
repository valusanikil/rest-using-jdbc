package com.rest.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rest.entity.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Override
	public Customer addCustomer(Customer customer) {
		String url = "jdbc:mysql://localhost:3306/RestApiJDBCDatabase?useSSL=false";
		String user = "root";
		String password = "123456";
		String query = "INSERT INTO customer_info VALUES(?,?,?,?)";
		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, customer.getId());
			pstmt.setString(2, customer.getName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPhone());
			int res = pstmt.executeUpdate();
			if (res == 0) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		String url = "jdbc:mysql://localhost:3306/RestApiJDBCDatabase?useSSL=false";
		String user = "root";
		String password = "123456";
		String query = "SELECT * FROM customer_info";
		List<Customer> list = new ArrayList<Customer>();
		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = con.prepareStatement(query)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Customer customer=new Customer();
				customer.setId(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setEmail(rs.getString(3));
				customer.setPhone(rs.getString(4));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		String url = "jdbc:mysql://localhost:3306/RestApiJDBCDatabase?useSSL=false";
		String user = "root";
		String password = "123456";
		String query = "SELECT * FROM customer_info WHERE id=?";
		Customer customer=null;
		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				customer=new Customer();
				customer.setId(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setEmail(rs.getString(3));
				customer.setPhone(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public List<Customer> DeleteCustomerById(int customerId) {
		String url = "jdbc:mysql://localhost:3306/RestApiJDBCDatabase?useSSL=false";
		String user = "root";
		String password = "123456";
		String query="DELETE FROM customer_info WHERE id=?";
		int result;
		List<Customer> list;
		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, customerId);
			result=pstmt.executeUpdate();
			if(result==0) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		list=getAllCustomers();
		return list;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		String url = "jdbc:mysql://localhost:3306/RestApiJDBCDatabase?useSSL=false";
		String user = "root";
		String password = "123456";
		String query="UPDATE customer_info SET name=?,email=?,phone=? where id=?";
		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getEmail());
			pstmt.setString(3, customer.getPhone());
			pstmt.setInt(4, customer.getId());
			int status=pstmt.executeUpdate();
			if(status==0) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getCustomerById(customer.getId());
	}

}
