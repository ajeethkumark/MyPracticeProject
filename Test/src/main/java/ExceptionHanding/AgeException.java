package ExceptionHanding;

public class AgeException extends RuntimeException {
	public AgeException(String msg)
	{
		super(msg);
	}
	public AgeException()
	{
		
	}
	public void ageExcptionAnalysis(int age)
	{
		if(age>60)
		{
			throw new AgeException("Your are too old to married");
		}
		else if(age<25)
		{
			throw new AgeException("Your are too Young to married");
		}
		else
		{
			System.out.println("Your Data is registered");
		}
	}
}
