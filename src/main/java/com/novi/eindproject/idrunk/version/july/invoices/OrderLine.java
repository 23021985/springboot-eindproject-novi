package com.novi.eindproject.idrunk.version.july.invoices;

public class OrderLine {

    public int count;
    public double price;
    public String name;

    public OrderLine(int count, double price, String name) {
        this.count = count;
        this.price = price;
        this.name = name;
    }
}
