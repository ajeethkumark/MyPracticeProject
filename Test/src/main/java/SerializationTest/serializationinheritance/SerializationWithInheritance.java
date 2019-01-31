package SerializationTest.serializationinheritance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationWithInheritance {
	public static void main(String[] arg) throws IOException, ClassNotFoundException
	{
		FileOutputStream fos=new FileOutputStream("inheritancefile.file");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(new Dog());
		
		FileInputStream fis=new FileInputStream("inheritancefile.file");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Dog d2=(Dog) ois.readObject();
		System.out.println("..."+d2.i+"....."+d2.j);
		
		
	}

}
class Animal implements Serializable
{
	Animal()
	{
		System.out.println("Animal constructor");
	}
	int i=10;
}
class Dog extends Animal
{
	int j=90;
	Dog()
	{
		
		System.out.println("Dog constructor");
	}
}
