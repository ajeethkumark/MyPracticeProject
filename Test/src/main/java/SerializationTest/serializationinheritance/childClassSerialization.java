package SerializationTest.serializationinheritance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class childClassSerialization {
	public static void main(String[] arg) throws IOException, ClassNotFoundException
	{
		DogTest dt=new DogTest();
		dt.i=100;
		dt.j=200;
		System.out.println("-----"+dt.i+"-----------"+dt.j);
		FileOutputStream fos=new FileOutputStream("childclassserialization.file");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(dt);
		System.out.println("Serialization over....");
		
		FileInputStream fis=new FileInputStream("childclassserialization.file");
		ObjectInputStream ois=new ObjectInputStream(fis);
		DogTest dt2=(DogTest)ois.readObject();
		System.out.println("Deserialization....."+dt2.i+"........"+dt2.j);
		
		
	}
}
class AnimalTest
{
	int i=10;
	AnimalTest()
	{
		System.out.println("Animal class constructor");
	}
}
class DogTest extends AnimalTest implements Serializable
{
	int j=20;
	DogTest()
	{
		System.out.println("Dog class constructor");
	}
}