package view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.AdminController;
import controller.StudentController;
import model.Utility.TrackStudentId;
import model.entity.Admin;
import model.entity.Question;
import model.entity.Result;
import model.entity.Student;
import model.exception.InsufficientQuestionException;

public class App {
	
	AdminController controller;
	StudentController sController;
	Scanner sc;
	
	public App() {
		controller = new AdminController();
		sc= new Scanner(System.in);
		sController = new StudentController();
		
	}
	
	public boolean viewQuestionById() {
		System.out.println("Enter Question ID ");
		Integer id = sc.nextInt();
		
		return controller.viewQuestionById(id);
		
	}
	
	public boolean adminValidate() {
		
		System.out.println("Enter the admin id : ");
		Integer id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the password");
		String password = sc.nextLine();
		
		Admin admin = new Admin(id, password);
		
		return controller.validateAdmin(admin);
		
	}
	
	public boolean addQuestion() {
		
		System.out.println("Enter the Question ?");
		String question = sc.nextLine();
		
		
		System.out.println("Option a :");
		String option_a =sc.nextLine();
		
		System.out.println("Option b :");
		String option_b =sc.nextLine();
		
		System.out.println("Option c :");
		String option_c =sc.nextLine();
		
		System.out.println("Option d :");
		String option_d =sc.nextLine();
		
		System.out.println("Answer :");
		String answer =sc.nextLine();
		
		//question,option_a,option_b,option_c,option_d,answer
		Question q1 = new Question(question,option_a,option_b,option_c,option_d,answer);
		
		return controller.addQuestion(q1);
	}
	
	public boolean addmultipleQuestion() {
		
		List<Question> Lq = new ArrayList<Question>();
		
		System.out.println("Enter total number of Questions want to enter");
		int Nquestion =sc.nextInt();
		sc.nextLine();
		
		for(int i =0;i<Nquestion;i++) {
		
			System.out.println("Enter the Question ?  : "+(i+1));
			String question = sc.nextLine();
			
			System.out.println("Option a :");
			String option_a =sc.nextLine();
			
			System.out.println("Option b :");
			String option_b =sc.nextLine();
			
			System.out.println("Option c :");
			String option_c =sc.nextLine();
			
			System.out.println("Option d :");
			String option_d =sc.nextLine();
			
			System.out.println("Answer :");
			String answer =sc.nextLine();
			
			Question q = new Question(question,option_a,option_b,option_c,option_d,answer);
			
			Lq.add(q);
			
		}
	
		return controller.addMultiQuestion(Lq);
		
	}
	
	public boolean viewScore() {
		int sId = TrackStudentId.getStudent();
		
		return sController.viewScore(sId);
	}

	
	public boolean studentValidate() {
		
		System.out.println("Enter the student Email");
		String email=sc.nextLine();
		
		
		System.out.println("Enter the student Password");
		String password=sc.nextLine();
		
		Student s = new Student();
		
		s.setEmail(email);
		s.setPassword(password);
		
		boolean result = sController.validateStudent(s);
		
		if(result) {
		Student stud = sController.getStudentByEmail(email);
		int sId = stud.getId();
		 
		// track the student till the app is running
		TrackStudentId.setStudentId(sId);
		}
		return result;
		
	}
	
	public int takeTest() {
		            // 1. fetch the question
					List<Question> questions = sController.getAllQuetions();
					int score = 0;
					if(questions.size() >= 10) {
				    // 2. take test
						int qcnt = 1;
						
						List<String> answers = new ArrayList<String>();
						
						for(Question q : questions) {
							
							System.out.println("====================================");
							System.out.println(qcnt + " :" + q.getQuestion());
							System.out.println("a :" + q.getOption_a());
							System.out.println("b :" + q.getOption_b());
							System.out.println("c :" + q.getOption_c());
							System.out.println("d :" + q.getOption_d());
							System.out.println("Choose the correct option");
							String answer = sc.nextLine();
							
							answers.add(answer);
							
							qcnt++ ;
							
						}// eof for
						
						// 3. calculated score 
						
						 score = sController.calculateScore(questions, answers);
						 
						// 4. Store the result in result table
						int sId = TrackStudentId.getStudent();
						
						String status = (score > 6) ? "passed" : "failed";
						
						Result result = new Result(score, status, sId);
						
						if(!sController.addResult(result)) {
							throw new RuntimeException("Something went wrong while saving the result");
						}
						System.out.println("Status of result :"+status);
						return score;
						
					} // eof if
					
					else {
						throw new InsufficientQuestionException("Question are not sufficient to take the test");
					}
			
	}
	

	private List<Question> viewAllQuestion() {
		
		List<Question> questions= new ArrayList<Question>();
		
		return controller.viewAllQuestion(questions);
		
	}
	
    private List<Student> viewAllStudent() {
		
		List<Student> stud= new ArrayList<Student>();
		
		return controller.viewAllStudent(stud);
		
	}
	
	public Student viewStudent() {
		int sId = TrackStudentId.getStudent();
		
		
		return sController.viewStudent(sId);
	}
	
	public boolean updateStudent() {
		
		Student std = viewStudent();
		System.out.println(std);
	
		
		System.out.println("Enter name of Student or Press enter");
		String name = sc.nextLine();
		
		System.out.println("Enter Password of Student or Press enter");
		String password = sc.nextLine();
		
		System.out.println("Enter Email of Student or Press enter");
		String email = sc.nextLine();
		
		System.out.println("Enter Gender of Student or Press enter");
		String gender = sc.nextLine();
		
		System.out.println("Enter Qualification of Student or Press enter");
		String qualification = sc.nextLine();
		
		System.out.println("Enter DOB of Student or Press enter");
		String dob = sc.nextLine();
		
		if(!name.isEmpty()) {
			std.setName(name);
		}
		
		if(!password.isEmpty()) {
			std.setPassword(password);
		}
		
		if(!email.isEmpty()) {
			std.setEmail(email);
		}
		
		if(!gender.isEmpty()) {
			std.setGender(gender);
		}
		
		if(!qualification.isEmpty()) {
			std.setQualification(qualification);
		}
		
		if(!dob.isEmpty()) {
			std.setDob(Date.valueOf(dob));
		}
		
		return sController.updateStudent(std);
		
	}
	
	public List<Result> viewStudentResult() {
		
		System.out.println("Enter the Student ID ");
		int sId= sc.nextInt();
		sc.nextLine();
		
		
		return controller.viewStudentResult(sId);
	}
	
    public List<Result> viewStudentAllResult() {
		
		return controller.viewStudentAllResult();
	}
	
    public List<Result> viewPassedStudent() {
		
		return controller.viewPassedStudent();
	}
    
    public List<Result> viewMaxScore() {
		
		return controller.viewMaxScore();
	}
    
    public List<Result> viewResultOrderByScore() {
		
    	return controller.viewResultOrderByScore();
	}
    
	
	public static void main(String[] args) 
	{
		App app = new App();
		
		
		System.out.println("************Welcome To Test Application*****************");
		boolean cond = true;
		while(cond) {
			
			System.out.println("Enter 1. Admin login");	
			System.out.println("Enter 2. Student login");
			System.out.println("Enter 0. for Exit");
			int choice = app.sc.nextInt();
			app.sc.nextLine();
			
		switch(choice){
		case 1:
		{   
			if(app.adminValidate()) {
			
			boolean Acond = true;
			
			while(Acond) {
				
				System.out.println("Enter 1. Add Question for Exam.");	
				System.out.println("Enter 2. Add Multiple Quetion.");
				System.out.println("Enter 3. View Question by ID.");
				System.out.println("Enter 4. View Question All Questions.");
				System.out.println("Enter 5. View Question All Students.");
				System.out.println("Enter 6. View Student Score.");
			    System.out.println("Enter 7. View All Student Score.");
			    System.out.println("Enter 8. View Only Passed Student.");
			    System.out.println("Enter 9. Filter Student by Score.");
			    System.out.println("Enter 10.Max Score .");
				System.out.println("Enter 0. Exit .");
			   
				int Achoice = app.sc.nextInt();
				
				switch (Achoice) {
				case 1:
				{   
					if(app.addQuestion()==false)
					{
						System.out.println("Error Occured .");
					}
				
					break;
				}
				case 2 :
				{   
					if(app.addmultipleQuestion()==false)
					{
						System.out.println("Error Occured .");
					}
				
					break;
				}
				
				case 3 :
				{   
					if(app.viewQuestionById()==false)
					{
						System.out.println("question doesn't exist .");
					}
				 
					break;
				}
				
				case 4 :
				{   
					List<Question> que =	app.viewAllQuestion();
					int i =1;
					for(Question e:que) {
						System.out.println(i+" : "+e);
						System.out.println();
						i++;
					}
					
					break;
				}
				
				case 5 :
				{   
					List<Student> que =	app.viewAllStudent();
					int i =1;
					for(Student e:que) {
						System.out.println(i+" : "+e);
						System.out.println();
						i++;
					}
					
					break;
				}
				
				case 6 :
				{   
					
					List<Result> que =	app.viewStudentResult();
					int i =1;
					for(Result e:que) {
						System.out.println(i+" : "+e);
						System.out.println();
						i++;
					}
					
					break;
				}
				
				case 7 :
				{   
					
					List<Result> que =	app.viewStudentAllResult();
					int i =1;
					for(Result e:que) {
						System.out.println(i+" : "+e);
						System.out.println();
						i++;
					}
					
					break;
				}
				
				case 8 :
				{   
					
					List<Result> que =	app.viewPassedStudent();
					int i =1;
					for(Result e:que) {
						System.out.println(i+" : "+e);
						System.out.println();
						i++;
					}	
					break;
				}
				
				case 9 :
				{   
					
					List<Result> que =	app.viewResultOrderByScore();
					int i =1;
					for(Result e:que) {
						System.out.println(i+" : "+e);
						System.out.println();
						i++;
					}	
					break;
				}
				
				case 10 :
				{   
					
					List<Result> que =	app.viewMaxScore();
					int i =1;
					for(Result e:que) {
						System.out.println(i+" : "+e);
						System.out.println();
						i++;
					}	
					break;
				}
				
				case 0:
				{    Acond = false;
				    
					break;
				}
				default: break;
				}
			   }
			  }
			else {
				System.out.println("Admin Detail Mismatched .");
			}
			
			break;
		     }
		case 2:
		{   
			
			if(app.studentValidate()) {
				
			
			boolean Slogin=true;
			while(Slogin) {
			
			System.out.println("Enter 1. Add Take a exam .");
			System.out.println("Enter 2. View a Score .");
		    System.out.println("Enter 3. View Personal Details .");
		    System.out.println("Enter 4. Update Details.");
			System.out.println("Enter 0. For Exit Student menu.");
			int	ch1 = app.sc.nextInt();
			app.sc.nextLine();
	
				
			switch(ch1) {
			
			case 1 :{
				
				System.out.println("Total Marks :"+app.takeTest());
				
				break;
			  }
			case 2 :{
				
				if(app.viewScore())
				{
					System.out.println("----------------------");
				}
				else
				{
					System.out.println("-------Error------");
				}
				break;
			}
			case 3 :{
				System.out.println(app.viewStudent());
				break;
			}
			
			case 4 :{
				if(app.updateStudent()){
				System.out.println("Updated Student : "+app.viewStudent());
				}
				else
				{
					System.out.println("some went wrong Ask coder");
				}
				
				break;
			}
			
			case 0 :{
				Slogin=false;
				break;
			}
			default : break;
			}

			}
			
			}
			else {
				System.out.println("student not found .");
			}
			break;
		}
		case 0:
		{
			cond= false;
			app.sController.studentClose();
			app.controller.adminClose();
			
		}

		 default:
		 {
			break;
		 }
		
	     }

		   } 
		
	}

	
	

}



