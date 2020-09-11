package com.noesisinformatica.test.dao.TestDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.noesisinformatica.test.entity.Term;
import com.noesisinformatica.test.utility.MySQLConnectionFactory;

public class TestDao
{
	static MySQLConnectionFactory mysqlObj=new MySQLConnectionFactory();
	public List<Term> getAllTermDescFromTerm() {

		String termDescFromTerm="select id,termDesc from Term";
		

		Connection con=null;
		PreparedStatement stmt=null;
		List<Term> terms=null;
//		MySQLConnectionFactory mysqlObj=new MySQLConnectionFactory();
		String termDesc=null;
		
		Integer id=null;
		try {
			con=mysqlObj.getConnection();
			stmt=con.prepareStatement(termDescFromTerm);
			ResultSet rs=stmt.executeQuery();
			if(rs!=null)
			{
				terms=new ArrayList<Term>(); 
				while(rs.next()) {
					Term term=new Term();
					term.setUserId(rs.getInt(1));
					term.setTerm(rs.getString(2));
					terms.add(term);
					System.out.println(term.toString());
					
				}
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {

			try {

				if(stmt!=null) {
					stmt.close();
					stmt=null;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return terms;

	}

	public void InsertTermDescIntoTerm(String termDesc) {
		PreparedStatement stmt=null;
		String userLoginInfoQuery="INSERT INTO Term(termDesc) values(?)";
		Connection con=null;
		try {
			con=mysqlObj.getConnection();
			stmt=con.prepareStatement(userLoginInfoQuery);
			stmt.setString(1,termDesc);
			stmt.executeUpdate(); 
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {

			try {

				if(stmt!=null) {
					stmt.close();
					stmt=null;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getLastTermId() {

		String termDescFromTerm="select id from Term order by id desc limit 1";
		

		Connection con=null;
		PreparedStatement stmt=null;
		Integer id=null;
		try {
			con=mysqlObj.getConnection();
			stmt=con.prepareStatement(termDescFromTerm);
			ResultSet rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next()) {
				System.out.println(rs.getInt(1));
				id=rs.getInt(1);
				}
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {

			try {

				if(stmt!=null) {
					stmt.close();
					stmt=null;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
		

	}
	
	
}