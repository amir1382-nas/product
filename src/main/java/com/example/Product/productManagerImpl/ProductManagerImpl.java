package com.example.Product.productManagerImpl;

import com.example.Product.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerImpl implements ProductManager {
    private List<Product> products = new ArrayList<>();

        @Override
        public void addProduct(Product product) {
            products.add(product);
        }


    @Override
    public Product getProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void updateProduct(int id, Product newproduct) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(newproduct.getName());
                product.setPrice(newproduct.getPrice());
                product.setQuantity(newproduct.getQuantity());
                return;
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
