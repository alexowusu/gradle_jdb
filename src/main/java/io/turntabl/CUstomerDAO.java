package io.turntabl;

import java.sql.*;
import java.util.List;

public class CUstomerDAO {
    public List<Product> getproductByCustomer(String customer) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql:northwind";
        try(Connection db = DriverManager.getConnection(url,"alex-owusu","turntabl")) {
            PreparedStatement products = db.prepareStatement(DBConstants.ADDPRODUCT);

            //        "select product_name from products where product_name like?;"
            //);
            System.out.println();


        }
}
