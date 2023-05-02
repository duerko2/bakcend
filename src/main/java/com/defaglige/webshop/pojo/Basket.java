package com.defaglige.webshop.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("baskets")
public class Basket {
    @Id
    String id_;
    List<Item> itemList;
    boolean recurring;

    public String getId_() {
        return id_;
    }

    public void setId_(String id_) {
        this.id_ = id_;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public Basket(String id_, List<Item> itemList, boolean recurring) {
        super();
        this.id_ = id_;
        this.itemList = itemList;
        this.recurring = recurring;
    }
}
