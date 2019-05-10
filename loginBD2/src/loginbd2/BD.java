/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginbd2;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class BD {

    public static void conectar() {

        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:mysql://192.168.4.238:3306/javatext";
            String user = "java";
            String password = "javajava";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here

            String sql = "SELECT * FROM usuarios";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }

            // ... 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}
