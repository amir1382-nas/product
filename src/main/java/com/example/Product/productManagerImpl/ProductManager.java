package com.example.Product.productManagerImpl;

import com.example.Product.product.Product;
import java.util.List;

public interface ProductManager {
    void addProduct(Product product);

    Product getProduct(int id);

    void deleteProduct(int id);

    List<Product> getAllProducts();
}
