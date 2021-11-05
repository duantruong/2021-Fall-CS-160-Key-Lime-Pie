package com.microegg.dao.mapper;

import com.microegg.model.MotherBoard;
import com.microegg.model.Processorrs;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcessorMapper implements RowMapper<Processorrs> {
    @Override
    public Processorrs mapRow(ResultSet rs, int rowNum) throws SQLException {
        Processorrs product = new Processorrs();
        product.setProductId(rs.getInt("productId"));
        product.setProductName(rs.getString("productName"));
        product.setProductDescription(rs.getString("productDescription"));
        product.setPrice(rs.getInt("PRICE"));
        product.setAvailableQuantity(rs.getInt("AVAILABLEQUANTITY"));
        product.setMake(rs.getString("make"));
        return product;
    }
}
