package model.entity; 

public class Result {
	
	private Integer rId;
	private Integer score;
	private String result;
	private Integer sId;
	
	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(Integer score, String result, Integer sId) 
	{
		super();
		this.score = score;
		this.result = result;
		this.sId = sId;
	}

	public Result(Integer rId, Integer score, String result, Integer sId) 
	{
		this(score,result,sId);
		this.rId = rId;
		
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	@Override
	public String toString() {
		return "Result [rId=" + rId + ", score=" + score + ", result=" + result + ", sId=" + sId + "]";
	}
	
	

}
