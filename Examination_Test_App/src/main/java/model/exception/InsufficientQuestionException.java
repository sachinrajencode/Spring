package model.exception;

@SuppressWarnings("serial")
public class InsufficientQuestionException extends RuntimeException{
	
	public InsufficientQuestionException (String msg)
	{
		super(msg);
	}

}
