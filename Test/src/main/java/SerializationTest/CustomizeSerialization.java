package SerializationTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomizeSerialization {
	
	public static void main(String[] arg) throws IOException, ClassNotFoundException
	{
		Account a1=new Account();
		System.out.println("......"+a1.password);
		FileOutputStream fos=new FileOutputStream("customize_serialization.file");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		System.out.println("Enter 1");
		oos.writeObject(a1);
		System.out.println("Enter 3");
		System.out.println("serialization over");
		
		
		
		FileInputStream fis=new FileInputStream("customize_serialization.file");
		ObjectInputStream ois=new ObjectInputStream(fis);	
		Account a2=(Account)ois.readObject();
		System.out.println("result:"+a2.password+"............"+a2.pin+"..........."+a2.test);
	}
	

}
class Account implements Serializable
{
	String userName="root";
	transient String password="password";
	transient int pin=123;
	transient int test=1;
	private void writeObject(ObjectOutputStream oos) throws IOException
	{
		System.out.println("Enter 2");
		oos.defaultWriteObject();
		String epwd="123"+password;
		int epin=100+pin;
		oos.writeObject(epwd);
		oos.writeInt(epin);
		int etest=test+100;
		oos.writeInt(etest);
	}
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
	{
		ois.defaultReadObject();
		String epwd=(String)ois.readObject();
		int epin=ois.readInt();
		pin=epin-100;
		password=epwd.substring(3);
		
		 test=ois.readInt()-100;
	}
}
