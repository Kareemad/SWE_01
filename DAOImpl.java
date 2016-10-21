package com.task1;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOImpl implements ProductDAO {

    public void insertProduct(Product product) {
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/product", "root", "");
            PreparedStatement psst;
            psst = myConn.prepareStatement ("insert into product values (?,?,?,?,?)");
            psst.setString (1, product.getID());
            psst.setString (2, product.getType());
            psst.setString (3, product.getManufacturer());
            psst.setString (4, product.getProductionDate());
            psst.setString (5, product.getExpiryDate());
            int i = psst.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog (null, "Product was successfully added");
            } else {
                JOptionPane.showMessageDialog (null, "Product was not added");
            }
        } catch (Exception var5) {
            JOptionPane.showMessageDialog (null, var5);
        }

    }

    public void deleteProduct(String productID) {
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/product", "root", "");
            PreparedStatement psst;
            psst = myConn.prepareStatement ("delete from Product where Product_ID = ?");
            psst.setString (1, productID);
            int i = psst.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog (null, "Product was successfully deleted");
            } else {
                JOptionPane.showMessageDialog (null, "Product was not deleted");
            }
        } catch (Exception var5) {
            JOptionPane.showMessageDialog (null, var5);
        }
    }

    public void updateProduct(Product product) {
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/product", "root", "");
            PreparedStatement psst;
            psst = myConn.prepareStatement ("update product set Type = ?, Manufacturer = ?, Production_Date = ?, Expiry_Date = ? where Product_ID = ?");
            psst.setString (1, product.getType());
            psst.setString (2, product.getManufacturer());
            psst.setString (3, product.getProductionDate());
            psst.setString (4, product.getExpiryDate());
            psst.setString (5, product.getID());
            int i = psst.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog (null, "Product was successfully updated");
            } else {
                JOptionPane.showMessageDialog (null, "Product was not updated");
            }
        } catch (Exception var5) {
            JOptionPane.showMessageDialog (null, var5);
        }

    }

    public List<Product> retrieveProduct(String manufacturer) {

        List<Product> productList = new ArrayList<Product>();

        try {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/product", "root", "");
            PreparedStatement psst;
            psst = myConn.prepareStatement ("select * from product where Manufacturer = ?");
            psst.setString (1, manufacturer);
            ResultSet myRs = psst.executeQuery();
            while (myRs.next()) {
                Product retrievedProduct = new Product(myRs.getString("Product_ID"));
                retrievedProduct.setType(myRs.getString("Type"));
                retrievedProduct.setManufacturer(myRs.getString("Manufacturer"));
                retrievedProduct.setProductionDate(myRs.getString("Production_Date"));
                retrievedProduct.setExpiryDate(myRs.getString("Expiry_Date"));
                productList.add(retrievedProduct);
                //System.out.println(myRs.getString("Type") + "," + myRs.getString("Product_ID"));
            }
        } catch (Exception var5) {
            JOptionPane.showMessageDialog (null, var5);
        }
        return productList;
    }
}