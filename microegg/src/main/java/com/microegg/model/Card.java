package com.microegg.model;

import java.sql.Date;

public class Card {

    private int cardId;
    private String cardHolderName;
    private int cardNumber;
    private Date exiprationDate;
    private int userId;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExiprationDate() {
        return exiprationDate;
    }

    public void setExiprationDate(Date exiprationDate) {
        this.exiprationDate = exiprationDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
