package com.microegg.dao.mapper;

import com.microegg.model.Address;
import com.microegg.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product>{

    String category;

    public ProductMapper(String category) {
        this.category = category;
    }

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getInt("productId"));
        product.setProductName(rs.getString("productName"));
        product.setProductDescription(rs.getString("productDescription"));
        product.setPrice(rs.getInt("PRICE"));
        product.setMake(rs.getString("MAKE"));
        product.setAvailableQuantity(rs.getInt("AVAILABLEQUANTITY"));
        product.setCategory(category);
        return product;
    }
}

