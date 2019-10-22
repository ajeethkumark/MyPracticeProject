package generic;

public class Gen<T> {
	T obj;
	Gen(T obj)
	{
		this.obj=obj;
	}
	public void show()
	{
		System.out.println("class Name:"+obj.getClass().getName());
	}
	
	public T getObject()
	{
		return obj;
	}
}
