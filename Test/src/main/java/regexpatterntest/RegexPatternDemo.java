package regexpatterntest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	Pattern p=Pattern.compile("[^a-zA-Z0-9]");
		Pattern p=Pattern.compile("\\s");
		Matcher m=p.matcher("a7b@ z#9");
		while(m.find())
		{
			System.out.println(m.start()+"....."+m.group());
		}
		
		splitTerst();
		mobileNumberValidation();
		

	}

	private static void mobileNumberValidation() {
		System.out.println("phone number match Test begin");
		// TODO Auto-generated method stub
		Pattern p=Pattern.compile("(91|0)?[7-9][0-9]{9}");
		Matcher m=p.matcher("07339092543");
		System.out.println("Match:"+m.matches());
		System.out.println("phone number match Test over");
		
	}

	private static void splitTerst() {
		// TODO Auto-generated method stub
		Pattern p=Pattern.compile("\\s");
		String[] splitData=p.split("ajeeth kumar");
		System.out.println("Split test start");
		for(String data: splitData)
			System.out.println(data);
		System.out.println("Split test over");
		
	}

}
