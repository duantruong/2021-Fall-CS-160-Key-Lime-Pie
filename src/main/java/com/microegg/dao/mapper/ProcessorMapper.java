package com.microegg.dao.mapper;

import com.microegg.model.Processors;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcessorMapper implements RowMapper<Processors> {
    @Override
    public Processors mapRow(ResultSet rs, int rowNum) throws SQLException {
        Processors product = new Processors();
        product.setProductId(rs.getInt("productId"));
        product.setProductName(rs.getString("productName"));
        product.setProductDescription(rs.getString("productDescription"));
        product.setPrice(rs.getInt("PRICE"));
        product.setAvailableQuantity(rs.getInt("AVAILABLEQUANTITY"));
        product.setMake(rs.getString("make"));
        product.setImageUrl(rs.getString("imageUrl"));
        return product;
    }
}
