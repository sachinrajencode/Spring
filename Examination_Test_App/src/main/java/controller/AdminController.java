package controller;

import java.util.List;

import model.dao.AdminDao;
import model.entity.Admin;
import model.entity.Question;
import model.entity.Result;
import model.entity.Student;

public class AdminController 
{
  AdminDao dao;
  
  
  public AdminController() {
	dao= new AdminDao();
}
  
  public boolean validateAdmin(Admin admin) {
	  return dao.validateAdmin(admin);
  }

  public boolean addQuestion(Question q) {
	
	return dao.addQuestion(q);
  }

  public boolean addMultiQuestion(List<Question> lq) {
	
	return dao.addmultiQuestion(lq);
  }

  public boolean viewQuestionById(Integer id) {
	
	return dao.viewQuestionById(id);
  }

  public List<Question> viewAllQuestion(List<Question> questions) {
	// TODO Auto-generated method stub
	return dao.viewAllQuestion(questions);
  }

  public List<Student> viewAllStudent(List<Student> stud) {
	
	return dao. viewAllStudent(stud);
  }

  public List<Result> viewStudentResult(int sId) {
	
	return dao.viewStudentResult(sId);
  }

  public List<Result> viewStudentAllResult() {
	
	return dao.viewStudentAllResult();
  }

  public List<Result> viewPassedStudent() {
	
	return dao.viewPassedStudent();
  }

  public List<Result> viewMaxScore() {
	
	return dao.viewMaxScore();
  }

  public List<Result> viewResultOrderByScore() {
	
	return dao.viewResultOrderByScore();
  }
  
  public void adminClose() {
	    System.out.println("Admin DB Connection Closed");
		dao.adminClose();
	}
  
  
}
