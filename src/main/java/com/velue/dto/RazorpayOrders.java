package com.velue.dto;

import java.util.List;

public class RazorpayOrders {
    private String entity;
    private int count;
    private List<RazorpayOrderItem> items;

    // Getters and setters

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<RazorpayOrderItem> getItems() {
        return items;
    }

    public void setItems(List<RazorpayOrderItem> items) {
        this.items = items;
    }
}

class RazorpayOrderItem {
    private String id;
    private String entity;
    private long amount;
    private long amount_paid;
    private long amount_due;
    private String currency;
    private String receipt;
    private String offer_id;
    private String status;
    private int attempts;
    private RazorpayNotes notes;
    private long created_at;

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(long amount_paid) {
        this.amount_paid = amount_paid;
    }

    public long getAmount_due() {
        return amount_due;
    }

    public void setAmount_due(long amount_due) {
        this.amount_due = amount_due;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public RazorpayNotes getNotes() {
        return notes;
    }

    public void setNotes(RazorpayNotes notes) {
        this.notes = notes;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }
}

class RazorpayNotes {
    private String notes_key_1;
    private String notes_key_2;

    // Getters and setters

    public String getNotes_key_1() {
        return notes_key_1;
    }

    public void setNotes_key_1(String notes_key_1) {
        this.notes_key_1 = notes_key_1;
    }

    public String getNotes_key_2() {
        return notes_key_2;
    }

    public void setNotes_key_2(String notes_key_2) {
        this.notes_key_2 = notes_key_2;
    }
}

