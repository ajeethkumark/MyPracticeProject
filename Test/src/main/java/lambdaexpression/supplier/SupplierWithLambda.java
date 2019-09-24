package lambdaexpression.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierWithLambda {
	
	public static void main(String[] arg)
	{
		Supplier<String> supplier=()->"Hello Ajeeth";
		System.out.println("Test:"+supplier.get());
		
		
		//supplier with stream
		List<String> list=Arrays.asList("a","b");
		System.out.println(list.stream().findAny().orElseGet(()->"Ajeeth"));
	}

}
