package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class historyDao {

    public List<calcEntity> gethistory() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<calcEntity> en = new ArrayList<>();
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Declare the JDBC objects.
            //sa身份连接
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=DBLinkTest;user=sa;password=czw123";
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
            String sql = "select * from DBLinkTest.dbo.calcTable";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                en.add(new calcEntity(rs.getDouble(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4)));
            }
        } catch (Exception e) {
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
//        List<calcEntity>  z=new ArrayList<>();
//        z.add(new calcEntity(1,"+",3,4));
        return en;
    }
}
