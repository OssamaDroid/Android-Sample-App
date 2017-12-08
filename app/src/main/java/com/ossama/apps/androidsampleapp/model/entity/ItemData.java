package com.ossama.apps.androidsampleapp.model.entity;

import java.io.Serializable;

/**
 * Created by ossama on 12/6/17.
 */

public class ItemData implements Serializable {

    private String itemId;
    private String value;
    private String currency;
    private String title;
    private Description description;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
