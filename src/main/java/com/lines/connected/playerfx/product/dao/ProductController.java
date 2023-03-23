package com.lines.connected.playerfx.product.dao;

import com.lines.connected.playerfx.product.dao.entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ProductController {
    private ProductDao productDao = new ProductDao();

    public ObservableList<Product> loadProducts(){
        List<Product> products = productDao.getAll();
        ObservableList<Product> productObservableList = FXCollections.observableList(products);
        return productObservableList;
    }

    public ProductDao getProductDao() {
        return productDao;
    }
}
