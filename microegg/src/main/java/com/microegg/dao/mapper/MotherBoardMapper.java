package com.microegg.dao.mapper;


import com.microegg.model.ComputerCases;
import com.microegg.model.MotherBoard;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MotherBoardMapper implements RowMapper<MotherBoard> {
    @Override
    public MotherBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
        MotherBoard product = new MotherBoard();
        product.setProductId(rs.getInt("productId"));
        product.setProductName(rs.getString("productName"));
        product.setProductDescription(rs.getString("productDescription"));
        product.setPrice(rs.getInt("PRICE"));
        product.setAvailableQuantity(rs.getInt("AVAILABLEQUANTITY"));
        product.setMake(rs.getString("make"));
        product.setChipSet(rs.getString("chipset"));
        product.setSize(rs.getInt("size"));
        return product;
    }
}
