package com.microegg.dao.mapper;

import com.microegg.model.Colling;
import com.microegg.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoolingMapper implements RowMapper<Colling> {
    @Override
    public Colling mapRow(ResultSet rs, int rowNum) throws SQLException {
        Colling product = new Colling();
        product.setProductId(rs.getInt("productId"));
        product.setProductName(rs.getString("productName"));
        product.setProductDescription(rs.getString("productDescription"));
        product.setPrice(rs.getInt("PRICE"));
        product.setAvailableQuantity(rs.getInt("AVAILABLEQUANTITY"));
        product.setMake(rs.getString("make"));
        return product;
    }
}
