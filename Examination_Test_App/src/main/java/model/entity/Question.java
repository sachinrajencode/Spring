package model.entity;

public class Question {

	private Integer qId;
	
	private String question;
	
	private String option_a;
	private String option_b;
	private String option_c;
	private String option_d;
	
	private String answer;
	
	public Question(Integer qId,String question, String option_a, String option_b, String option_c, String option_d,
			String answer) {
		
		this(question,option_a,option_b,option_c,option_d,answer);
		this.qId = qId;
		
	}

	public Question( String question, String option_a, String option_b, String option_c, String option_d,
			String answer) {
		super();
		this.question = question;
		this.option_a = option_a;
		this.option_b = option_b;
		this.option_c = option_c;
		this.option_d = option_d;
		this.answer = answer;
	}
	
	

	@Override
	public String toString() {
		return "Question [qId=" + qId + ", question=" + question + ", option_a=" + option_a + ", option_b=" + option_b
				+ ", option_c=" + option_c + ", option_d=" + option_d + ", answer=" + answer + "]";
	}

	public Integer getqId() {
		return qId;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption_a() {
		return option_a;
	}

	public void setOption_a(String option_a) {
		this.option_a = option_a;
	}

	public String getOption_b() {
		return option_b;
	}

	public void setOption_b(String option_b) {
		this.option_b = option_b;
	}

	public String getOption_c() {
		return option_c;
	}

	public void setOption_c(String option_c) {
		this.option_c = option_c;
	}

	public String getOption_d() {
		return option_d;
	}

	public void setOption_d(String option_d) {
		this.option_d = option_d;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
}
