package com.microegg.dao.mapper;

import com.microegg.model.Ram;
import com.microegg.model.Storage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RamMapper implements RowMapper<Ram> {
    @Override
    public Ram mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ram product = new Ram();
        product.setProductId(rs.getInt("productId"));
        product.setProductName(rs.getString("productName"));
        product.setProductDescription(rs.getString("productDescription"));
        product.setPrice(rs.getInt("PRICE"));
        product.setAvailableQuantity(rs.getInt("AVAILABLEQUANTITY"));
        product.setMake(rs.getString("make"));
        return product;
    }
}
