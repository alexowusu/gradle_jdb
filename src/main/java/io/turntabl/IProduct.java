package io.turntabl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface IProduct {
    public void addProduct(Product p) throws SQLException;
    public Product getProductByName(String name);
        List<Product> getProductByCustomerName(String CustomerName) throws ClassNotFoundException;
        List<Product> getFiveTopProducts() throws SQLException, ClassNotFoundException;
        List<SalesTo> getSalesReport(LocalDate date) throws SQLException, ClassNotFoundException;

}
