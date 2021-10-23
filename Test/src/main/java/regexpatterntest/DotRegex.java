package regexpatterntest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DotRegex {
	// start and end of character ^------$
	public static void main(String[] arg)
	{
	
	Pattern p=Pattern.compile("...\\.");
	Matcher match=p.matcher(".f#.");
	
	System.out.println("---------------:"+match.matches());
	}

}
