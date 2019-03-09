package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLTest {
	
	public static void main(String[] args) throws IOException {
		try
		{
			//URL url = new URL("http://localhost:8080/RestServices/testservice/testGet/45");
			URL url=new URL("http://localhost:8080/RestTest/date");
			System.out.println("Enter one");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			System.out.println("Enter 2");
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String res = null;
			System.out.println("Enter 3");
			while ((res = br.readLine()) != null) {
				System.out.println(res+"\n");
			}
			connection.disconnect();
		}
		catch(Exception e)
		{
			System.out.println("Exception...");
			e.printStackTrace();
		}

		

	}


}
