package com.microegg.dao.mapper;


import com.microegg.model.MotherBoard;
import com.microegg.model.Storage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StorageMapper implements RowMapper<Storage> {
    @Override
    public Storage mapRow(ResultSet rs, int rowNum) throws SQLException {
        Storage product = new Storage();
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
