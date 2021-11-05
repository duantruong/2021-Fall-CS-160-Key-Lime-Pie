package com.microegg.model.Request;

public class Order {

    private Integer cartId;
    private Integer userId;
    private Integer addressId;

    public Order(Integer cartId, Integer userId, Integer addressId) {
        this.cartId = cartId;
        this.userId = userId;
        this.addressId = addressId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getAddressId() {
        return addressId;
    }
}
