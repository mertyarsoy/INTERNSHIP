package sql.jdbc;

import org.junit.Test;
import utils.JDBC_utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class employees_TABLE {

    @Test
    public void queryTest() throws SQLException {
        ResultSet result = JDBC_utils.queryDB("SELECT * FROM employees");

        ResultSetMetaData metaData = result.getMetaData();

        while (result.next()) { // iterating over rows in a table

            for (int i = 1; i <= metaData.getColumnCount(); i++) { // iterating over columns in a table
                if (i == 1) System.out.print("|");
                System.out.print(result.getString(i) + " |");
            }
            System.out.println(); // it will print a new line for new row
        }

    }
}
