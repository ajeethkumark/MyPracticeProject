package lambdaexpression;

interface TestIf
{
	public void process(int i,int j);
}

public class InnerClassTest {
	
	public static void main(String[] arg)
	{
		doprocess(1,new TestIf() {

			@Override
			public void process(int i,int j) {
				// TODO Auto-generated method stub
				
				System.out.println("Inner class");
				
			}		
		
				
				
		});
		
		//closure in Lambda Expression
		doProcessLambda(10,(i,j)->System.out.println(i+j));
	}

	

	private static void doProcessLambda(int i, TestIf testIf) {
		// TODO Auto-generated method stub
		testIf.process(i,20);
		
	}

	private static void doprocess(int i, TestIf testIf) {
		// TODO Auto-generated method stub
		
		System.out.println("Start");
		testIf.process(1,20);
		System.out.println("End");
		
	}

	

}
