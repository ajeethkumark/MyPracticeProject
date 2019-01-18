package SerializationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Test t1=new Test();
		FileOutputStream fos=new FileOutputStream("serialization.file");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(t1);
		System.out.println("over");
		
		FileInputStream fis=new FileInputStream("serialization.file");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Test t2=(Test)ois.readObject();
		System.out.println(t2.i+":De serialization over:"+t2.j);

	}

}
class Test implements Serializable
{
	int i=10;
	transient  int j=20;
}
