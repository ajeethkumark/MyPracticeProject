package SerializationTest;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizationDemo implements Externalizable{
	String s;
	int i,j;
	public ExternalizationDemo()
	{
		System.out.println("No Argument consturctor");
	}
	ExternalizationDemo(String s,int i,int j)
	{
		this.s=s;
		this.i=i;
		this.j=j;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ExternalizationDemo ed=new ExternalizationDemo("ajeeth",1,2);
		FileOutputStream fos=new FileOutputStream("external.file");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(ed);
		
		
		FileInputStream fis=new FileInputStream("external.file");
		ObjectInputStream ois=new ObjectInputStream(fis);
		ExternalizationDemo ed2=(ExternalizationDemo)ois.readObject();
		System.out.println("...."+ed2.s+"....."+ed2.i);

	}
	
	public void writeExternal(ObjectOutput out)throws IOException
	{
		out.writeObject(s);
		out.writeInt(i);
	}
	public void readExternal(ObjectInput in)throws IOException, ClassNotFoundException
	{
		s=(String)in.readObject();
		i=in.readInt();
		
	}
}
