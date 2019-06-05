package fileread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class FileReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			System.out.println("hello world");
			//home/ajeeth/hints
			//File f=new File("//home//ajeeth//hints//hello.txt");
			File f=new File("//home//ajeeth//drl_file//hello.txt");
			BufferedReader br=new BufferedReader(new FileReader(f));
			String letter=br.readLine();
			while(letter!=null)
			{
				System.out.println(letter);
				letter=br.readLine();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
