package com.task1;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DAOImpl newtest = new DAOImpl();
        Product testprod = new Product("ID001");
        testprod.setType("Bread");
        testprod.setManufacturer("Rich Bake");
        testprod.setProductionDate("10/10/2016");
        testprod.setExpiryDate("12/10/2016");
        newtest.insertProduct(testprod);
        Product testprodUpd = new Product("ID001");
        testprodUpd.setType("Chocolate");
        testprodUpd.setManufacturer("Rich Bake");
        testprodUpd.setProductionDate("10/10/2016");
        testprodUpd.setExpiryDate("12/10/2016");
        newtest.updateProduct(testprodUpd);
        List<Product> list = newtest.retrieveProduct("Rich Bake");
        System.out.println(list.get(0).getType());
        newtest.deleteProduct("ID001");
    }
}