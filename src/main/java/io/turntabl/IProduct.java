package io.turntabl;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    public void addProduct(Product p) throws SQLException;
    public Product getProductByName(String name);
        List<Product> getProductByCustomerName(String CustomerName) throws ClassNotFoundException;

}
