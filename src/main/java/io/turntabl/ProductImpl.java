package io.turntabl;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
            ps.clearParameters();
            ResultSet rs = ps.executeQuery();
            List<Product> result = new ArrayList<>();
            while (rs.next()){
                result.add(new Product(rs.getString("product_name"),rs.getDouble("unit_price")));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Product> getFiveTopProducts() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql:northwind";
        Connection db = DriverManager.getConnection(url,"alex-owusu","turntabl");{
            Statement s = db.createStatement();}
        PreparedStatement ps = db.prepareStatement("select product_name, count(products.product_name) as ct, " +
                "product.unit_price) from products inner join order_details.product on products.product_id group " +
                "by products.product_name, products.unit_price order by ct desc limit 5");

        ResultSet rs = ps.executeQuery();
        List<Product> result = new ArrayList<>();
        while (rs.next()){
            result.add(new Product(rs.getString("product_name"),rs.getDouble("unit_price")));
        }




        return result;
    }

    @Override
    public List<SalesTo> getSalesReport(LocalDate date) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql:northwind";
        Connection db = DriverManager.getConnection(url,"alex-owusu","turntabl");{
            Statement s = db.createStatement();}
        PreparedStatement ps = db.prepareStatement("select order_date - interval '7 day' from orders where oder_date" +
                "betwwen'1996-09-12' and '1996-09-12' + interval '7 day' order by order_date");

        ResultSet rs = ps.executeQuery();
        List<SalesTo> result = new ArrayList<>();
        while (rs.next()){
            Product product = new Product (rs.getString("product_name"), rs.getDouble("unit_price"));
            SalesTo salesTo = new SalesTo(product, rs.getString("customer_name"), rs.getDate("order_date"));
            result.add(salesTo);
        return result;
    }
}
