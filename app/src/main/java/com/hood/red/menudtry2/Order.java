package com.hood.red.menudtry2;

/**
 * Created by malyf on 29/5/18.
 */

public class Order {
    private String dishName;
    private String id;
    private int plates;
    private String status;
    private long rate;

    public Order(String dishName, String id, int plates, String status,long rate) {
        this.dishName = dishName;
        this.id = id;
        this.plates = plates;
        this.status = status;
        this.rate=rate;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPlates() {
        return plates;
    }

    public void setPlates(int plates) {
        this.plates = plates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }
}
