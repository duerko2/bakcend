package com.defaglige.webshop.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("webshop")
public class Product {
    @Id
    private String _id;
    private String name;
    private String id;
    private double price;
    private String currency;
    private int rebateQuantity;
    private double rebatePercent;
    private String upsellProductId;

    public Product(String _id, String name, String id, double price, String currency, int rebateQuantity, double rebatePercent, String upsellProductId) {
        super();
        this._id = _id;
        this.name = name;
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.rebateQuantity = rebateQuantity;
        this.rebatePercent = rebatePercent;
        this.upsellProductId = upsellProductId;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getRebateQuantity() {
        return rebateQuantity;
    }

    public void setRebateQuantity(int rebateQuantity) {
        this.rebateQuantity = rebateQuantity;
    }

    public double getRebatePercent() {
        return rebatePercent;
    }

    public void setRebatePercent(double rebatePercent) {
        this.rebatePercent = rebatePercent;
    }

    public String getUpsellProductId() {
        return upsellProductId;
    }

    public void setUpsellProductId(String upsellProductId) {
        this.upsellProductId = upsellProductId;
    }
}

