package regexpatterntest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DotRegex {
	// start and end of character ^------$    (Regexs Anchors)
	public static void main(String[] arg)
	{
	
	Pattern p=Pattern.compile("...");
	Matcher match=p.matcher(".f#");  // This will provide true
	
	System.out.println("-------1--------:"+match.matches());
	
	
	//-------------------------------------------------------
	//if you want to compare with dot(.) hen we need to use \\.  
	//if you used (.) then it will be true for all character
	
	Pattern pp=Pattern.compile("\\.");
	Matcher matchs=pp.matcher("k");  //--> This will provide false
	
	System.out.println("-------2--------:"+matchs.matches());
	
	}

}
