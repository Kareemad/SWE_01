package com.task1;

import java.util.List;

public interface ProductDAO {

    void insertProduct(Product product);
    void deleteProduct(String productID);
    void updateProduct(Product product);
    List<Product> retrieveProduct(String manufacturer);
}