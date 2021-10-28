package com.microegg.model.Request;

public class Transaction {
    private Integer cardId;
    private String paymentMode;
    private Integer orderId;

    public Transaction(Integer cardId, String paymentMode, Integer orderId) {
        this.cardId = cardId;
        this.paymentMode = paymentMode;
        this.orderId = orderId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
