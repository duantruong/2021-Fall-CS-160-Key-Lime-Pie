package com.microegg.model.Request;

public class ProductIntoCart {

    private Integer cartId;
    private  Integer productId;
    private  Integer quantity;

    public ProductIntoCart(Integer cartId, Integer productId, Integer quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getCartId() {
        return cartId;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
