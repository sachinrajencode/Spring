package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Utility.ConnectionUtil;
import model.entity.Admin;
import model.entity.Question;
import model.entity.Result;
import model.entity.Student;


public class AdminDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	
	public AdminDao() {
		
		con = ConnectionUtil.getConnection();
	}
	
	public void adminClose() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean validateAdmin(Admin admin) {
		
		String query = "Select * from admin where a_id = ? and password = ? ";
		
		try {
		
		ps = con.prepareStatement(query);
		
		ps.setInt(1, admin.getId());
		ps.setString(2,admin.getPassword());
		
		rs = ps.executeQuery();
		
		if(rs.next())
		{
			return true;
		}
		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return false;
	}


	public boolean addQuestion(Question q) {
		String query = "insert into question (question,option_a,option_b,option_c,option_d,answer) values(?,?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setString(1, q.getQuestion());
			ps.setString(2, q.getOption_a());
			ps.setString(3, q.getOption_b());
			ps.setString(4, q.getOption_c());
			ps.setString(5, q.getOption_d());
			ps.setString(6, q.getAnswer());
			
			if(ps.executeUpdate()>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


	public boolean addmultiQuestion(List<Question> listQ) {
		String query = "insert into question (question,option_a,option_b,option_c,option_d,answer) values(?,?,?,?,?,?)";
		int addQcount=0;
		try {
			ps=con.prepareStatement(query);
			
			for(Question q:listQ) {
				ps.setString(1, q.getQuestion());
				ps.setString(2, q.getOption_a());
				ps.setString(3, q.getOption_b());
				ps.setString(4, q.getOption_c());
				ps.setString(5, q.getOption_d());
				ps.setString(6, q.getAnswer());
				
				ps.addBatch();
			}
			
			int [] result = ps.executeBatch();
			
			for(int r:result) {
				if(r>0) {
					addQcount++;
				}
			}
			
			System.out.println("total number of question added :"+addQcount);
			if(addQcount>0)
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


	public boolean viewQuestionById(Integer id) {
		
		String query = "select * from Question where qid = ?";
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				System.out.println("Question with given id : "+rs.getString("question")+"|Answers : "+rs.getString("answer"));
				
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
		
		return false;
	}


	public List<Question> viewAllQuestion(List<Question> questions) {
		
		
		
		String query = "Select * from Question";
		
		try {
			ps=con.prepareStatement(query);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				do {
					questions.add(new Question(rs.getInt("qid"),rs.getString("question"),rs.getString("option_a"),rs.getString("option_b"),rs.getString("option_c"),rs.getString("option_d"),rs.getString("answer")));
				}while(rs.next());
				
			}
			
			return questions;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	public List<Student> viewAllStudent(List<Student> stud) {
		
		String query = "Select * from student";
		
		try {
			ps=con.prepareStatement(query);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				do {
					stud.add(new Student(rs.getInt("s_id"),rs.getString("name"),rs.getString("password"),rs.getString("email"),rs.getString("gender"),rs.getString("qualification"),rs.getDate("dob")));
				}while(rs.next());
				
			}
			
			return stud;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	public List<Result> viewStudentResult(int sId) {
		String query = "Select * From RESULT where s_id= ?";
		List<Result> rStudent = new ArrayList<Result>();
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setInt(1, sId);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				do {
					rStudent.add(new Result(rs.getInt("score"),rs.getString("result"),rs.getInt("s_id")));
				}while(rs.next());
			}
			
			return rStudent;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	public List<Result> viewStudentAllResult() {
	
		String query = "Select * From RESULT ";
		List<Result> rStudent = new ArrayList<Result>();
		
		try {
			ps=con.prepareStatement(query);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				do {
					rStudent.add(new Result(rs.getInt("score"),rs.getString("result"),rs.getInt("s_id")));
				}while(rs.next());
			}
			
			return rStudent;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	public List<Result> viewPassedStudent() {
		
		String query = "Select * From RESULT Where result = 'passed' ";
		List<Result> rStudent = new ArrayList<Result>();
		
		try {
			ps=con.prepareStatement(query);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				do {
					rStudent.add(new Result(rs.getInt("r_id"),rs.getInt("score"),rs.getString("result"),rs.getInt("s_id")));
				}while(rs.next());
			}
			
			return rStudent;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	public List<Result> viewMaxScore() {
		
		String query =" SELECT * FROM Result WHERE score= (SELECT MAX(score) FROM Result)";
		
		List<Result> rStudent = new ArrayList<Result>();
		
		try {
			ps=con.prepareStatement(query);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				do {
					rStudent.add(new Result(rs.getInt("r_id"),rs.getInt("score"),rs.getString("result"),rs.getInt("s_id")));
				}while(rs.next());
			}
			
			return rStudent;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return null;
	}


	public List<Result> viewResultOrderByScore() {
      
   String query =" SELECT * FROM Result ORDER BY score";
		
		List<Result> rStudent = new ArrayList<Result>();
		
		try {
			ps=con.prepareStatement(query);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				do {
					rStudent.add(new Result(rs.getInt("r_id"),rs.getInt("score"),rs.getString("result"),rs.getInt("s_id")));
				}while(rs.next());
			}
			
			return rStudent;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
	

}
