package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Utility.ConnectionUtil;
import model.entity.Result;

public class ResultDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
    
	public ResultDao() {
		con= ConnectionUtil.getConnection();
	}
	
	public boolean addResult(Result result) {
		
		String query = "insert into result(score, result, s_id) values(?,?,?)";
		
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, result.getScore());
			ps.setString(2, result.getResult());
			ps.setInt(3, result.getsId());
			
			if(ps.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean viewScore(int sId) {
		
		String query ="Select * from result where s_id = ?";
		
		try {
			ps = con.prepareStatement(query);
			
			ps.setInt(1, sId);
			
			rs=ps.executeQuery();
			
			int i=1;
			
			while(rs.next()) {
				System.out.println("Result for test "+i);
				System.out.println("Result id : "+rs.getInt("r_id")+", Score : "+rs.getInt("score")+", Result : "+rs.getString("result"));
				System.out.println();
				i++;
			}
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
}
