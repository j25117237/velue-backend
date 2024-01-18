package com.velue.dto;

public class PaymentOrder {
    private Long amount;
    private String currency;
    private String orderId;

    // Constructors, getters, setters, and other methods...

    // Constructors
    public PaymentOrder() {
    }

    public PaymentOrder(Long amount, String currency, String orderId) {
        this.amount = amount;
        this.currency = currency;
        this.orderId = orderId;
    }

    // Getters and Setters
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}

