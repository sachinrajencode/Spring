package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Utility.ConnectionUtil;
import model.entity.Student;

public class StudentDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public StudentDao() {
		// TODO Auto-generated constructor stub
		con= ConnectionUtil.getConnection();
	}
	
	public void studentClose() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Student getStudentbyEmail(String email) {
		String query = "select * from student where email = ?";
		
		try {
			ps= con .prepareStatement(query);
			ps.setString(1, email);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return new Student(rs.getInt("s_id"),rs.getString("name"),rs.getString("password"),rs.getString("email"),rs.getString("gender"),rs.getString("qualification"),rs.getDate("dob"));
			
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean validateStudent(Student student)
	
	{
		String query = "select email, password from student where email = ? and password = ?";
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setString(1,student.getEmail() );
			ps.setString(2,student.getPassword());
			
			rs= ps.executeQuery();
			
			if(rs.next()) {
				
				if(rs.getString("email").equals(student.getEmail())&&rs.getString("password").equals(student.getPassword())) 
				{ 
					return true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

	public Student viewStudent(int sId) {
		
		String query = "Select * from student  where s_id = ?";
		
	try {
		ps=	con.prepareStatement(query);
		
		ps.setInt(1, sId);
		
		rs= ps.executeQuery();
		
		if(rs.next()) {
	
			return new Student(rs.getInt("s_id"),rs.getString("name"),rs.getString("password"),rs.getString("email"),rs.getString("gender"),rs.getString("qualification"),rs.getDate("dob"));
		}
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return null;
	}

	public boolean studentUpdate(Student std) {
		
		String query = "update student set name = ?, password = ?, email = ?, gender = ?, qualification = ?, dob = ? where s_id = ?";
		
		try {
			ps = con.prepareStatement(query);
			
			ps.setString(1, std.getName());
			ps.setString(2, std.getPassword());
			ps.setString(3, std.getEmail());
			ps.setString(4, std.getGender());
			ps.setString(5, std.getQualification());
			ps.setDate(6, std.getDob());
			ps.setInt(7, std.getId());
			
			if(ps.executeUpdate()>0) {
				return true;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	
}
