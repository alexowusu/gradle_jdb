package io.turntabl;

import java.sql.*;
import java.util.List;

public class ProductImpl implements IProduct {
//    public void addProduct(Product p){
//        Class.forName("org.postgresql.Driver");
//        String url = "jdbc:postgresql:northwind";
//        Connection c = DriverManager.getConnection(url,"alex-owusu","turntabl")){
//            Statement s = c.createStatement();
//            PreparedStatement ps = c.prepareStatement(DBConstant.ADDProduct);
//            try{
//                ps.setString(1, p.getName());
//                ps.setDouble(2, p.getPrice());
//            }
//    }

//    }

    @Override
    public void addProduct(Product p) throws SQLException {

    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> getProductByCustomerName(String CustomerName) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql:northwind";
        try{
            Connection db = DriverManager.getConnection(url,"alex-owusu","turntabl");{
            Statement s = db.createStatement();}
            PreparedStatement ps = db.prepareStatement("select product_name,product.unit_price from products" +
                    "inner join order_details on products.product_id = order_details.product_id inner join" +
                            "orders on order_details.order_id = orders.order_id inner join customers on" +
                            "orders.customer_id=customers.customer_id where customers.contact_name=?g"
                    );

            ps.setString(1, CustomerName);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
