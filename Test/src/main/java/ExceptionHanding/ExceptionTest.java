package ExceptionHanding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int age=90;
		new AgeException().ageExcptionAnalysis(age);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
	}

}
