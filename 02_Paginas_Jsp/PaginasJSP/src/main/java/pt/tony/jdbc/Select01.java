package pt.tony.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Select01 {

	public static void main(String[] args) {
		//String user = "jdbctest";
        //String pwd  = "Xpto.1234.Student";
        
		// //register JDBC driver, optional, since java 1.6
		// try {
		//     Class.forName("org.postgresql.Driver");
		// } catch (ClassNotFoundException e) {
		//     e.printStackTrace(System.err);
		// }
		String url  = "jdbc:postgresql://vps-b7cf1329.vps.ovh.net:5432/tlusers";
		Properties props = new Properties();
		props.setProperty("user", "tluser_23");
        props.setProperty("password", "Xpto.1234.Student.tluser_23");
        props.setProperty("ssl", "false");
        props.setProperty("ApplicationName", "AserJDBC");
        props.setProperty("defaultRowFetchSize", "50");
        props.setProperty("options", "-c search_path=tluser_23,pg_catalog,public -c statement_timeout=90000");
        try {
			Connection conn = DriverManager.getConnection(url, props);
			
			// Preparar Statement. Esta confguração cria ResultSet com máximo desempenho
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            String sql  = "SELECT cust_id, firstname, surname from customer";
            
            ResultSet rset = stmt.executeQuery(sql);
            
            long n = 0;
            System.out.printf("%1$-7s | %2$-25s | %3$-25s |%n", "cust_id", "firstname", "surname");
            while (rset.next()) {
                System.out.printf("%1$7s | %2$-25s | %3$-25s |%n", rset.getString("cust_id"),
                    rset.getString("firstname"), rset.getString("surname"));
                    //rset.getString(1), rset.getString(2), rset.getString(3));
                n++;
            }
            if (n > 0) {
                System.out.println("There were " + n + " returned rows");
            } else {
                System.out.println("Query returned no rows");
            }
            rset.close();
            stmt.close();
			conn.close();
			DriverManager.deregisterDriver(DriverManager.getDriver(url));
		} catch (SQLException e) {
			e.printStackTrace(System.err);
		}
	}
}
