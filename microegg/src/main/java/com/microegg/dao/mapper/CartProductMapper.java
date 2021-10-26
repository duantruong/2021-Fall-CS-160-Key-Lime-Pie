package com.microegg.dao.mapper;

import com.microegg.model.CartProduct;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartProductMapper implements RowMapper<CartProduct> {
    @Override
    public CartProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
