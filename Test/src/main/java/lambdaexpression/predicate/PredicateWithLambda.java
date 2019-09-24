package lambdaexpression.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateWithLambda {
	public static void main(String[] arg)
	{
		Predicate<Integer> predicate=(t)->{
			if(t%2==0)
				return true;
			else
				return false;
		}; 
		
		//above and below both are same
		Predicate<Integer> p=t->t%2==0;
		
		System.out.println("Test:"+predicate.test(6));
		System.out.println("Test:"+p.test(5));
		
		
		//predicate with stream
		System.out.println("......................................");
		List<Integer> list=Arrays.asList(1,2,3,4,5);
		list.stream().filter(p).forEach(t->System.out.println("Even Number:"+t));
		
		
		
	}

}
