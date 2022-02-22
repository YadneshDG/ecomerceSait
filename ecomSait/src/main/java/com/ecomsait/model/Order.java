//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ecomsait.model;

public class Order extends Product {
    private int orderId;
    private int uid;
    private int qunatity;
    private String date;

    public Order() {
    }

    public Order(int orderId, int uid, int qunatity, String date) {
        this.orderId = orderId;
        this.uid = uid;
        this.qunatity = qunatity;
        this.date = date;
    }

    public Order(int uid, int qunatity, String date) {
        this.uid = uid;
        this.qunatity = qunatity;
        this.date = date;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getQunatity() {
        return this.qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
