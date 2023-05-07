package com.defaglige.webshop.pojo;


public class Item {
    Product product;
    int quantity;
    boolean giftWrap;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isGiftWrap() {
        return giftWrap;
    }

    public void setGiftWrap(boolean giftWrap) {
        this.giftWrap = giftWrap;
    }
}
