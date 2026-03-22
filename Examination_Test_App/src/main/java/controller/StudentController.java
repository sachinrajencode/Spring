package controller;

import java.util.List;

import model.Utility.ScoreUtility;
import model.dao.QuestionDao;
import model.dao.ResultDao;
import model.dao.StudentDao;
import model.entity.Question;
import model.entity.Result;
import model.entity.Student;

public class StudentController {

	StudentDao dao;
	QuestionDao qdao ;
	ResultDao rdao;
	
	public StudentController() {
		dao=new StudentDao();
		qdao = new QuestionDao();
		rdao= new ResultDao();
		
	}
	
	public boolean validateStudent(Student student)
	{
		return dao.validateStudent(student);
	}
	
	public Student getStudentByEmail(String email) {
		return dao.getStudentbyEmail(email);
	}
	
	public List<Question> getAllQuetions(){
		return qdao.getAllQuetion();
	}
	
	public boolean addResult(Result result) {
		return rdao.addResult(result);
	}
	
	public int calculateScore(List<Question> questions,List<String> answers) {
		
		return ScoreUtility.calculateScore(questions, answers);
	}

	public boolean viewScore(int sId) {
		
		return rdao.viewScore(sId);
	}

	public Student viewStudent(int sId) {
		
		return dao.viewStudent(sId);
	}

	public boolean updateStudent(Student std) {
		
		return dao.studentUpdate(std);
	}
   
	public void studentClose() {
		System.out.println("Student DB Connection Closed");
		dao.studentClose();
	}
	
	
}
