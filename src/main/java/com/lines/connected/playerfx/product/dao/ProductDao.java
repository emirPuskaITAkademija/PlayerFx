package com.lines.connected.playerfx.product.dao;

import com.lines.connected.playerfx.product.dao.connection.ConnectionPool;
import com.lines.connected.playerfx.product.dao.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Product>{
    @Override
    public Product save(Product entity) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                products.add(product);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        ConnectionPool.getInstance().releaseConnection(connection);
        return products;
    }

    @Override
    public Product get(Long id) {
        return null;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public boolean delete(Product entity) {
        return false;
    }
}
