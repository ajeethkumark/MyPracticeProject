package lambdaexpression.doublecolon;

public class ConstructorReference {
	
	public ConstructorReference()
	{
		System.out.println("No argument constructor called ");
	}
	
	public ConstructorReference(String s)
	{
		System.out.println("constructor with argument");
		System.out.println("value:"+s);
	}
	public static void main(String[] arg)
	{
		
		//object inizialied with lambda
		Inif i=()->new ConstructorReference();
		i.mi().test();;
		
		//object inizialied with constructor referenece
		Inif i2=ConstructorReference::new;
		i2.mi().test();
		
		
		//another example for constructor reference
		System.out.println("\n\nconstrctor reference 2");
		Init2  i3=ConstructorReference::new;
		ConstructorReference cr=i3.m2("Hello");
		cr.test();
		
	}
	
	public void test()
	{
		System.out.println("Testing constructorReference");
	}

}

interface Inif
{
	public ConstructorReference mi();
}

interface  Init2
{
	public ConstructorReference m2(String s);
}
