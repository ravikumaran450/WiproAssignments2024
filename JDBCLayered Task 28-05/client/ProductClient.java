package com.wipro.jdbc.client;
import java.sql.*;
import com.wipro.jdbc.model.*;
import com.wipro.jdbc.service.*;
import com.wipro.jdbc.util.*;

public class ProductClient {

	public static void main(String[] args) throws SQLSyntaxErrorException,SQLException,ClassNotFoundException{
		ProductService ps=new ProductServiceImpl();

		//creating a table
		ps.tablecreate();
	       
		//inserting
		ps.insertproduct(new Product(1,"SmartTV",25000));
		ps.insertproduct(new Product(2,"SmartWatch",15000));
		ps.insertproduct(new Product(3,"Tab",10000));

		//deleting
		ps.deleteproduct(3);

		//updating
		ps.updateproduct(2, new Product(2,"SmartWatch", 10000));

		//listing
		ps.ProductList().stream().forEach(e->System.out.println(e));
		
		
	}
}

