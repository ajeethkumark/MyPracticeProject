package regexpatterntest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	
	public static void main(String[] arg)
	{
		Pattern p=Pattern.compile("(\\w+)");
		Matcher m=p.matcher("hellow world");
		while(m.find())
		{
			System.out.println("m.group():"+m.group()+"-------:"+m.group(1));
		}
	}

}
