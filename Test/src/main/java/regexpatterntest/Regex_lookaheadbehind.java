package regexpatterntest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_lookaheadbehind {
	/*
	 * Look ahead positive (?=)    Find expression A where expression B follows
	 * Look ahead negative (?!)    Find expression A where expression B does not follow:
	 * Look behind positive (?<=)  Find expression A where expression B precedes
	 * Look behind negative (?<!)  Find expression A where expression B does not precede:
	 * 
	 * 
	 */
	
	public static void main(String[] arg)
	{
		Regex_lookaheadbehind obj=new Regex_lookaheadbehind();
		System.out.println("LookaheadPositive start");
		obj.lookaheadPositive("(.)(?=\\1)","baaahbc");
		System.out.println("************************************");		
		obj.lookaheadPositive("(.)(?:\\1)+","aaabb");
		System.out.println("LookaheadPositive Ended");
		
		
		System.out.println("\n\nlookaheadNegative started----");
		obj.lookaheadnegative("(.)(?!\\1)","aabb");
		System.out.println("lookaheadNegative Ended----");
		
		// llokbehind not supportting....
	/*	System.out.println("\n\nlookbehindPositive started----");
		obj.lookbehindPositive("(.)(?<=\\1)","aabb");
		System.out.println("lookbehindPositive Ended----");
		
		
		System.out.println("\n\nlookbehindNegative started----");
		obj.lookbehindNegative("(.)(?<!\\1)","aabb");
		System.out.println("lookbehindNegative Ended----");  */
	}
	
	
	public void lookaheadPositive(String regex,String input)
	{
		 Pattern p = Pattern.compile(regex);
		 Matcher m = p.matcher(input);
		// System.out.println("lookaHeadPositive:---:"+m.matches());
		 while(m.find())
		 {
			 System.out.println("data:--:"+m.group()+"------start:"+m.start()+"   End:"+m.end());
		 }
		 
	}

	public void lookaheadnegative(String regex,String input)
	{
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(input);
		//System.out.println("lookaHeadnegative:---:"+m.matches());
		 while(m.find())
		 {
			 System.out.println("data:--:"+m.group()+"------start:"+m.start()+"   End:"+m.end());
		 }
	}
	
	public void lookbehindPositive(String regex,String input)
	{
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(input);
		//System.out.println("lookbehindPositive:---:"+m.matches());
		while(m.find())
		 {
			 System.out.println("data:--:"+m.group()+"------start:"+m.start()+"   End:"+m.end());
		 }
	}
	
	public void lookbehindNegative(String regex,String input)
	{
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(input);
		//System.out.println("lookbehindNegative:---:"+m.matches());
		while(m.find())
		 {
			 System.out.println("data:--:"+m.group()+"------start:"+m.start()+"   End:"+m.end());
		 }
	}
}



