package com.noesisinformatica.test.utility;

import java.sql.Connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.noesisinformatica.test.bean.Constants;
import com.noesisinformatica.test.dao.TestDao.TestDao;

public class MyDataSourceFactory {
	public static MysqlDataSource mysqlDS = new MysqlDataSource();

	public static MysqlDataSource getMySQLDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		mysqlDS.setURL(Constants.MYSQL_URL);
		mysqlDS.setUser(Constants.MYSQL_USERNAME);
		mysqlDS.setPassword(Constants.MYSQL_PASSWORD);
		return mysqlDS;
	}
	
			public static void main(String [] args) throws InterruptedException {
				MysqlDataSource ds=getMySQLDataSource();
				Connection con=null;
				TestDao dao=new TestDao();
				try {
					
					for(int i=0;i<100;i++) {
					con = ds.getConnection();
					Thread.sleep(1000);
					if(con!=null) {
						con.close();
					}
					
					System.out.println("DO I have a con"+con.isClosed());
					
					}
					System.out.println(ds.getDontTrackOpenResources());
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
}
