package lambdaexpression;

interface FunIf
{
	public int show(int i);
}

public class LambdaBasic {
	
	public static void main(String[] arg)
	{
		FunIf funIf=n->{
			
			return n*n;
			
		};
		
		System.out.println("Test lambda:"+funIf.show(10));
	}

}
