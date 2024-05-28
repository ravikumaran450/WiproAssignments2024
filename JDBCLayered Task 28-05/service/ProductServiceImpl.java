package com.wipro.jdbc.service;
import com.wipro.jdbc.model.*;
import com.wipro.jdbc.util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductServiceImpl implements ProductService{

	@Override
	public void tablecreate() throws SQLSyntaxErrorException, SQLException, ClassNotFoundException {
		Connection con=DBCon.getConnection();
		Statement s = con.createStatement();
		s.executeUpdate("create table Product(product_id number primary key, product_name varchar(20), price number)");
		System.out.println("Table Created Successfully");
	}
	@Override
	public void insertproduct(Product p) throws SQLSyntaxErrorException, SQLException, ClassNotFoundException {
		PreparedStatement pst=DBCon.getConnection().prepareStatement("insert into Product values(?,?,?)");
		pst.setInt(1,p.getId());
		pst.setString(2,p.getname());
		pst.setInt(3,p.getprice());
		pst.execute();
		System.out.println("Inserted Successfully");
	}
	@Override
	public void deleteproduct(Integer product_id) throws SQLSyntaxErrorException, SQLException, ClassNotFoundException {
		PreparedStatement pst=DBCon.getConnection().prepareStatement("delete from Product where product_id=?");
		pst.setInt(1,product_id);
		pst.execute();
	
		System.out.println("Deleted Successfully");
		
	}
	
	@Override
	public void updateproduct(Integer product_id, Product p) throws SQLSyntaxErrorException, SQLException, ClassNotFoundException {
		Connection con=DBCon.getConnection();
		con.setAutoCommit(false);
		try {
		PreparedStatement pst=con.prepareStatement("update  Product  product_name=?,price=? where product_id=?");
		pst.setInt(3,product_id);
		pst.setString(2, p.getname());
		pst.setInt(3, p.getprice());
		pst.execute();
		}
		catch(Exception e) {
			con.rollback();
		}
		con.commit();
		
		System.out.println("Updated");
		
	}
	
	@Override
	public List <Product> ProductList() throws SQLSyntaxErrorException,SQLException,ClassNotFoundException{
		Statement st=DBCon.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from Product");
		List<Product> plist=new ArrayList<>();
		while(rs.next()) {
		
			Product p=new Product();
			p.setId(rs.getInt(1));
			p.setname(rs.getString(2));
			p.setprice(rs.getInt(3));
			plist.add(p);
		}
		return plist;
	}
	
	@Override
	public Product getproducts(Integer product_id) throws SQLSyntaxErrorException,SQLException,ClassNotFoundException{
		PreparedStatement st=DBCon.getConnection().prepareStatement("select * from Product where product_id=?");
		st.setInt(1, product_id);
		
		ResultSet rs=st.executeQuery();
		Product p=new Product();
		
		while(rs.next()) {
			p.setId(rs.getInt(1));
			p.setname(rs.getString(2));
			p.setprice(rs.getInt(3));
		}
		
		return p;
	}
}
