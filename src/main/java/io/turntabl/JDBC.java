package io.turntabl;
import java.sql.*;
public class JDBC {
    public static void JDBC() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql:northwind";
        try(Connection db = DriverManager.getConnection(url,"alex-owusu","turntabl")){
           Statement s = db.createStatement();
           ResultSet rs = s.executeQuery("select * from customers");
           System.out.printf("%30s %30s %300s"," Name", " city", " country");
            System.out.println();

                   while(rs.next()) {
                       System.out.format("%30s %30s %30s",
                               rs.getString("contact_name"),
                               rs.getString("city"),
                               rs.getString("country")
                       );
                       System.out.println();
                   }

        }catch(SQLException sqle){
            System.err.println("cnnection err: " + sqle);
        }

    }


    public static void searchName(String name) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql:northwind";
        try(Connection db = DriverManager.getConnection(url,"alex-owusu","turntabl")){
            Statement s = db.createStatement();
            ResultSet rs = s.executeQuery("select * from customers where contact_name='"+name+"';");
            System.out.printf("%30s %30s %300s"," Name", " city", " country");
            System.out.println();

            while(rs.next()) {
                System.out.format("%30s %30s %30s",
                        rs.getString("contact_name"),
                        rs.getString("city"),
                        rs.getString("country")
                );
                System.out.println();
            }

        }catch(SQLException sqle){
            System.err.println("cnnection err: " + sqle);
        }

    }





}