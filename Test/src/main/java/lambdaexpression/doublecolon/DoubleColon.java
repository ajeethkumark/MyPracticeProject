package lambdaexpression.doublecolon;

public class DoubleColon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//without using medthod referenece
		Runnable r=()->{
			for(int i=0;i<10;i++)
				System.out.println("i value:"+i);
		};
		Thread t=new Thread(r);
		t.start();
		
		//Below code using Method referenece
		DoubleColon dc=new DoubleColon();
		Runnable r2=dc::runTest;
		Thread t2=new Thread(r2);
		t.start();
		
		//..........................................................		
		
		
		//same example without using runnable and method referenece		
		lam i=()->{System.out.println("hello");};
		i.mi();		
		//using method reference
		lam i2=dc::runTest;		
		i2.mi();
		
		
		//......................................
		
		

	}
	
	public void runTest()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("i value..:"+i);
		}
	}

}

interface lam
{
	public void mi();
}
