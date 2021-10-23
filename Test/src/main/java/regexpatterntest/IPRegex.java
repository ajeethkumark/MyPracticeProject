package regexpatterntest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPRegex {
	
	/*
	 * some valid IP sample - https://www.youtube.com/watch?v=e8LvIbWOdRM
	 * 000.12.12.034
	 * 121.234..12.12
	 * 23.45.12.56
	 * 
	 */
	
	
	/*
	 * Regex
	 * [01]?\\d{1,2} matches number 0 - 199
	 * 2[0-4]\\d matches numbers 200-249
	 * 25[0-5] matches number 250-255
	 * 
	 * \\d{1, 2} means one or two digits
	 */
	public static void main(String[] arg) {
	
	String num="[01]?\\d{1,2}2[0-4]\\d25[0-5]";
	
	String regex="((\\d{1,2}|(0|1)\\d{2})|2[0-4]\\d|25[0-5])";
	
	String pattern=regex+"."+regex+"."+regex+"."+regex;
	Pattern p=Pattern.compile(pattern);
	Matcher m=p.matcher("000.12.12.034");
	//m.matches()

	System.out.println(m.matches());
	}

}
