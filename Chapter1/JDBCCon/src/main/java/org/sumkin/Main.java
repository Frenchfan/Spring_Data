package org.sumkin;

import java.sql.*;

public class Main {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/spring_data_ch01";
    static final String USER = "postgres";
    static final String PASS = "45stsat5";
    static final String Query = "SELECT id, code, name FROM country";

    public static void main(String[] args) {
        // Open a connection and close it when finish the execution
        // The use of try/catch in this way autoclose the resources
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(Query)) {

            //Obtain info of one row
            while (rs.next()) {
                //retieve the data by column
                int id  = rs.getInt("id");
                String code = rs.getString("code");
                String name = rs.getString("name");

                System.out.println(String.format("id: %d, code: %s, name: %s", id, code, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}