package com.microegg.dao.mapper;

import com.microegg.model.Colling;
import com.microegg.model.ComputerCases;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComputerCasesMapper implements RowMapper<ComputerCases> {
    @Override
    public ComputerCases mapRow(ResultSet rs, int rowNum) throws SQLException {
        ComputerCases product = new ComputerCases();
        product.setProductId(rs.getInt("productId"));
        product.setProductName(rs.getString("productName"));
        product.setProductDescription(rs.getString("productDescription"));
        product.setPrice(rs.getInt("PRICE"));
        product.setAvailableQuantity(rs.getInt("AVAILABLEQUANTITY"));
        product.setMake(rs.getString("make"));
        product.setSize(rs.getString("size"));
        return product;
    }
}
