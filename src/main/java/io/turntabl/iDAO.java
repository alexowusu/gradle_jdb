package io.turntabl;

import java.sql.SQLException;

public interface iDAO {
    public void addCustomer(Customers cus) throws SQLException;
}
