package io.turntabl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCExample {
    public static void main(String[] args)  {
        //ApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
     ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
      JdbcTemplate tmpl = (JdbcTemplate) ctx.getBean("jdbcTemplate");

      int numRows = tmpl.queryForObject("select count(customer) from customers", Integer.class);
        System.out.println(numRows);

    }



}
