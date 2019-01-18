package test;

public class ObjectCalling {
	
	public static void main(String[] arg)
	{
		Rat r=new Rat();
		System.out.println("value is:"+r.c.v.j);
	}

}
class Rat
{
	Cat c=new Cat();
}
class Cat
{
	VariableValue v=new VariableValue();
}
class VariableValue
{
	int j=25;
}
