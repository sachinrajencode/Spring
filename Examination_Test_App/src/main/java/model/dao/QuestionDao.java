package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Utility.ConnectionUtil;
import model.entity.Question;

public class QuestionDao {

	Connection con;
	Statement stm;
	ResultSet rs;
	
	public QuestionDao() {
		con = ConnectionUtil.getConnection();
		try {
			stm = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Question> getAllQuetion(){
		
		List<Question> questions= new ArrayList<Question>();
		
		String query = "select * from question FETCH FIRST 10 ROWS ONLY;";
		
		try {
			rs = stm.executeQuery(query);
			
			if(rs.next()) {
				
				do {
					questions.add(new Question(rs.getInt("qid"),rs.getString("question"),rs.getString("option_a"),rs.getString("option_b"),rs.getString("option_c"),rs.getString("option_d"),rs.getString("answer")));
				  
				}while(rs.next());
				
				return questions;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
