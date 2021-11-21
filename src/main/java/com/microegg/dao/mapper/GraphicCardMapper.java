package com.microegg.dao.mapper;

import com.microegg.model.GraphicCard;
import com.microegg.model.MotherBoard;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GraphicCardMapper implements RowMapper<GraphicCard> {

    @Override
    public GraphicCard mapRow(ResultSet rs, int rowNum) throws SQLException {
        GraphicCard product = new GraphicCard();
        product.setProductId(rs.getInt("productId"));
        product.setProductName(rs.getString("productName"));
        product.setProductDescription(rs.getString("productDescription"));
        product.setPrice(rs.getInt("PRICE"));
        product.setAvailableQuantity(rs.getInt("AVAILABLEQUANTITY"));
        product.setMake(rs.getString("make"));
        product.setChipSet(rs.getString("chipset"));
        product.setImageUrl(rs.getString("imageUrl"));
        return product;
    }
}
