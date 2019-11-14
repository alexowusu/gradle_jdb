package io.turntabl;

import java.util.Date;

public class SalesTo {
    private Product product;
    private String customerName;
    private Date date;

    public SalesTo(Product product, String customerName, Date date){
        this.customerName = customerName;
        this.date = date;
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public Product getProduct() {
        return product;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "SalesTo{" +
                "product=" + product +
                ", customerName='" + customerName + '\'' +
                ", date=" + date +
                '}';
    }
}
