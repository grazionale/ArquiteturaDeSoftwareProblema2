package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static Connection Conector() {
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/aqtsoft?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            throw new RuntimeException(e);
        }
    }    
}
