package lambdaexpression.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemoWithLambda {
	public static void main(String[] arg)
	{
		
		//Understanding about consumer
		Consumer<Integer> consume=t->System.out.println("value:"+t);		
		consume.accept(10);
		
		//stream with consumer interface 
		List<Integer> list=Arrays.asList(1,2,3,4,5);
		list.stream().forEach(consume);
		
		//above and below are same
		System.out.println("......................................");
		list.stream().forEach(t->System.out.println("...:"+t));
		
		
	}

}
