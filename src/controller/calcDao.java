package controller;

import java.sql.*;

public class calcDao {
    // Create a variable for the connection string.
    String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=DBLinkTest;integratedSecurity=true;";

    // String url2 = "jdbc:sqlserver://127.0.0.1:1433;databaseName=DBLinkTest;integratedSecurity=ture;";//windows集成模式连接

    private ResultSet rs = null;
    public void save(calcEntity en) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Declare the JDBC objects.
            //sa身份连接
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=DBLinkTest;user=sa;password=czw123";
             con = DriverManager.getConnection(url);
             stmt = con.createStatement();
            String sql = String.format("exec CALC %f,'%s',%f,%f", en.getX(), en.getOp(), en.getY(), en.getResult());
            rs = stmt.executeQuery(sql);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (Exception e) {
                }
            if (stmt != null)
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            if (con != null)
                try {
                    con.close();
                } catch (Exception e) {
                }
        }
    }
}
