package com.microegg.dao.mapper;

import com.microegg.model.OrderProduct;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderProductMapper implements RowMapper<OrderProduct> {
    @Override
    public OrderProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderProduct op = new OrderProduct();
        op.setOrderId(rs.getInt("orderId"));
        op.setProductId(rs.getInt("productId"));
        op.setQuantity(rs.getInt("quantity"));
        op.setTotalAmount(rs.getInt("totalAmount"));
        return op;
    }
}
