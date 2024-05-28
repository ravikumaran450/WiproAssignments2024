package com.wipro.jdbc.service;
import java.sql.*;
import java.util.List;

import com.wipro.jdbc.model.Product;

public interface ProductService {
	void tablecreate() throws SQLSyntaxErrorException,SQLException,ClassNotFoundException;
	void insertproduct(Product p) throws SQLSyntaxErrorException,SQLException,ClassNotFoundException;
	void updateproduct(Integer product_id, Product p) throws SQLSyntaxErrorException,SQLException,ClassNotFoundException;
	void deleteproduct(Integer product_id) throws SQLSyntaxErrorException,SQLException,ClassNotFoundException;
        List <Product> ProductList() throws SQLSyntaxErrorException,SQLException,ClassNotFoundException;
        Product getproducts(Integer product_id) throws SQLSyntaxErrorException,SQLException,ClassNotFoundException; 
}
