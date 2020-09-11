package com.noesisinformatica.test.utility;


import java.sql.Connection;
import java.sql.SQLException;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.noesisinformatica.test.bean.Constants;
import com.noesisinformatica.test.dao.TestDao.TestDao;

public class MySQLConnectionFactory {
	public static MysqlDataSource mysqlDS = new MysqlDataSource();
	public static Connection con=null;
	public static MysqlDataSource getMySQLDataSource() {
		
		    mysqlDS.setURL(Constants.MYSQL_URL);
			mysqlDS.setUser(Constants.MYSQL_USERNAME);
			mysqlDS.setPassword(com.noesisinformatica.test.bean.Constants.MYSQL_PASSWORD);
			mysqlDS.setAutoReconnectForConnectionPools(true);
			mysqlDS.setCachePreparedStatements(true);
			mysqlDS.setCacheResultSetMetadata(true);
			mysqlDS.setConnectTimeout(10000);
			mysqlDS.setQueryTimeoutKillsConnection(true);
			mysqlDS.setSocketTimeout(10000);
			
		return mysqlDS;
	}
	
			public Connection getConnection() {
				MysqlDataSource ds=getMySQLDataSource();
				try {
					if(con==null || con.isClosed()) {
						
						System.out.println("Creating connection");
					con = ds.getConnection();
					}
					else {
						
						System.out.println("Existing one"+con.isClosed());
						
					}
				
				} catch (SQLException e) {
					
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				return con;
			}
			

}
