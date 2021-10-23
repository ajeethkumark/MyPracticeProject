package regexpatterntest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveDuplicateNumber {
	
	public static void main(String[] arg)
	{
		 // Test Case: 1
		
		System.out.println("Test Case 1 started");
        String str1
            = "Good bye bye world world";
        System.out.println(
            removeDuplicateWords(str1));
        System.out.println("Test Case 1 End");
        
        System.out.println("Test Case 2 started");
        
 
        // Test Case: 2
        String str2
            = "Ram went went to to his home";
        System.out.println(
            removeDuplicateWords(str2));
        
        System.out.println("Test Case 2 End");
        
        System.out.println("Test Case 3 started");
 
        // Test Case: 3
        String str3
            = "Hello hello world world";
        System.out.println(
            removeDuplicateWords(str3));
        
        System.out.println("Test Case 3 End");
	}

public static String removeDuplicateWords(String input)
	    {
	 
	        // Regex to matching repeated words.
	        String regex
	            = "\\b(\\w+)(?:\\W+\\1\\b)+";
	        Pattern p
	            = Pattern.compile(
	                regex,
	                Pattern.CASE_INSENSITIVE);
	 
	        // Pattern class contains matcher() method
	        // to find matching between given sentence
	        // and regular expression.
	        Matcher m = p.matcher(input);
	 
	        // Check for subsequences of input
	        // that match the compiled pattern
	        while (m.find()) {
	            input
	                = input.replaceAll(
	                    m.group(),
	                    m.group(1));
	            
	            System.out.println(" m.group():"+ m.group()+"-------:"+m.group(1));
	        }
	        return input;
	    }
	
}
