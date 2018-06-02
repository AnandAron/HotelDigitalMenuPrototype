package com.hood.red.menudtry2;

/**
 * Created by malyf on 29/5/18.
 */

public class MenuItem {
    private String id;


    private String dishName;
    private String rate;
    private String availability;

    public MenuItem(String id, String dishName, String rate, String availability) {
        this.id = id;
        this.dishName = dishName;
        this.rate = rate;
        this.availability = availability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
