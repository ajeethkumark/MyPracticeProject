package lambdaexpression.groupby.listgroupby;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingString {
	public static void main(String[] arg)
	{
		List<String> items=Arrays.asList("apple","orange","banana","banana","papaya");
		
		HashMap<String,Long> result=(HashMap<String, Long>) items.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println("result:"+result);
		

	}

}
