package regexpatterntest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoundaryRegex {
	public static void main(String[] arg)
	{
		String input="sand is the word that make it sound like quick ,However to say sandquick is quciksand bg";
		prefixBoundary("\\bsand\\w+",input);
		postFixBoundary("[a-z]+sand\\b",input);
	//	prefixBoundary("[a-z]+sand\\b",input);
		
	}

	private static void postFixBoundary(String regex,String input) {
		// TODO Auto-generated method stub
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(input);
		while(m.find())
		{
			//System.out.println(m.group()+"  post Result:"+m.matches());
			System.out.println(m.group()+"  post Result:"+m.matches());
			
		}
		//faced catastrophic backtracking issue
		
	}

	private static void prefixBoundary(String regex,String input) {
		// TODO Auto-generated method stub
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(input);
		//System.out.println("------start---------:"+m.find());
		while(m.find())
		{
			System.out.println("--------start-----------");
			System.out.println(m.group()+"  pre Result:");
			System.out.println("--------End-----------:");
			
		}
		
		System.out.println("---------------:"+m.find());
		
	}
}
