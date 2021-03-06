package com.microegg.dao;

import com.microegg.dao.mapper.CartProductMapper;
import com.microegg.dao.mapper.OrderProductMapper;
import com.microegg.model.CartProduct;
import com.microegg.model.OrderProduct;
import com.microegg.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.util.List;

@Repository
public class OrderDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ProductDao productDao;

    public int createCart(Integer userId){
        String query = "INSERT INTO cart (userId) VALUES(?)";
        jdbcTemplate.update(query,userId);
        final Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        return id;
    }

    public int addProductToCart(Integer cartId, Integer productId, Integer quantity){
        Product product = productDao.searchProductById(productId);
        if(product.getAvailableQuantity() < quantity) throw new IllegalArgumentException("Available quantity is " + product.getAvailableQuantity());
        String query = "INSERT INTO cart_products (cartId, productId, quantity) VALUES(?,?,?)";
        jdbcTemplate.update(query,cartId,productId,quantity);
        final Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        return id;
    }

    public List<CartProduct> getCartProducts(Integer cartId){
        String query = "select * from cart_products cp where cartId = " + cartId  ;
        List<CartProduct> cartProducts =  jdbcTemplate.query(query , new CartProductMapper());
        for(CartProduct p : cartProducts){
            Product product = productDao.searchProductById(p.getProductId());
            p.setPrice(product.getPrice());
            p.setProductName(product.getProductName());
            p.setProductDescription(product.getProductDescription());
        }
        return cartProducts;
    }


    public int doOrder(Integer cartId, Integer userId, Integer addressId, List<CartProduct> cartProducts){


        String query = "INSERT INTO orders (orderDate, userId,addressId) VALUES(?,?,?)";
        jdbcTemplate.update(query,new Date(System.currentTimeMillis()),userId,addressId);
        final Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        for(CartProduct cartProduct : cartProducts){
            String queryOrderProduct = "INSERT INTO Orders_Products (orderId, productId,quantity,totalAmount) VALUES(?,?,?,?)";
            jdbcTemplate.update(queryOrderProduct,id,cartProduct.getProductId(),cartProduct.getQuantity(), cartProduct.getQuantity()*cartProduct.getPrice());

        }

        //clear cart
        String sql = "DELETE FROM Cart_Products where cartId= " + cartId;
        jdbcTemplate.update(sql);

        return id;
    }

    public List<OrderProduct> getOrderedProduct(Integer orderId){
        String query = "select * from Orders_Products op where orderId = " + orderId;
        List<OrderProduct> orderedProduct =  jdbcTemplate.query(query , new OrderProductMapper());
        return orderedProduct;
    }

    public List<OrderProduct> getOrderedProductByUserId(Integer userId){
        String query = "select * from Orders_Products op where orderId in (select orderId from orders where userId ="+userId + ")";
        List<OrderProduct> orderedProduct =  jdbcTemplate.query(query , new OrderProductMapper());
        return orderedProduct;
    }



    public int doTransaction(int cardId, String paymentMode, Integer orderId){
            List<OrderProduct> orderProducts = getOrderedProduct(orderId);
            Integer totalAmount = 0;
            for(OrderProduct op : orderProducts){
                totalAmount = totalAmount+ op.getTotalAmount();
                reduceQuantityOfProduct(op.getProductId(),op.getQuantity());
            }

        String queryOrderProduct = "INSERT INTO Transactions (paymentMode, cardId,totalAmount,transactionDate) VALUES(?,?,?,?)";
        jdbcTemplate.update(queryOrderProduct,paymentMode,cardId,totalAmount, new java.sql.Date(System.currentTimeMillis()));
        final Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        return id;

    }

    public void reduceQuantityOfProduct(Integer productId, Integer orderedQuantity){
        Product product = productDao.searchProductById(productId);
        Integer newQuantity = product.getAvailableQuantity() - orderedQuantity;
        productDao.updateQuantity(productId,newQuantity,product.getCategory());
    }




}
