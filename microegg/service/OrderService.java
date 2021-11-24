package com.microegg.service;

import com.microegg.dao.OrderDao;
import com.microegg.dao.ProductDao;
import com.microegg.dao.mapper.CartProductMapper;
import com.microegg.dao.mapper.OrderProductMapper;
import com.microegg.model.CartProduct;
import com.microegg.model.OrderProduct;
import com.microegg.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.tags.ArgumentAware;

import java.sql.Date;
import java.util.List;

@Service
@CrossOrigin(origins = {"http://localhost:3000"})
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    public int createCart(Integer userId){
        return orderDao.createCart(userId);
    }

    public int addProductToCart(Integer cartId, Integer productId, Integer quantity){
        return orderDao.addProductToCart(cartId,productId,quantity);
    }

    public List<CartProduct> getCartProducts(Integer cartId){
        return orderDao.getCartProducts(cartId);
    }


    public int doOrder(Integer cartId, Integer userId, Integer addressId){
        List<CartProduct> cartProducts = getCartProducts(cartId);
        for(CartProduct cartProduct: cartProducts){
            Product product = productDao.searchProductById(cartProduct.getProductId());
            if(product.getAvailableQuantity() < cartProduct.getQuantity()){
                throw new IllegalArgumentException("Available quantity in stock for Product "+ product.getProductName()  + " " +
                        product.getAvailableQuantity());
            }
        }
        return orderDao.doOrder(cartId,userId,addressId, cartProducts);
    }

    public List<OrderProduct> getOrderedProduct(Integer orderId){
        return orderDao.getOrderedProduct(orderId);
    }

    public List<OrderProduct> getOrderedProductByUserId(Integer userId){
        return orderDao.getOrderedProductByUserId(userId);
    }


    public int doTransaction(int cardId, String paymentMode, Integer orderId){
        return orderDao.doTransaction(cardId,paymentMode,orderId);

    }



}
