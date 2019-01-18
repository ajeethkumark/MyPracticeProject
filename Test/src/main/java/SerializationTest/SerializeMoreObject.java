package SerializationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeMoreObject 
{

	public static void main(String[] arg) throws IOException, ClassNotFoundException
	{
		FileOutputStream fos=new FileOutputStream("file.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Test1 t1=new Test1();
		oos.writeObject(t1);
		Test2 t2=new Test2();
		oos.writeObject(t2);
		System.out.println("Serialization over");
		
		
		FileInputStream fis=new FileInputStream("file.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		Object o=null;
		
		while(fis.available()>0)
		{
			o=ois.readObject();
			if(o instanceof Test1)
			{
				System.out.println("called");
			}
			else if(o instanceof Test2)
			{
				System.out.println("Test2");	
			}
			else
			{
				System.out.println("Nothing");
			}
			System.out.println("Enter");
		}
		
		
	}
	
}
class Test1 implements Serializable
{
	int a=10;
}
class Test2  implements Serializable
{
	int b=20;
}
