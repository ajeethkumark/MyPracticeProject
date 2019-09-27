package lambdaexpression.groupby.listgroupby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lambdaexpression.PersonPojo;

public class GroupFromObject {
	
	public static void main(String[] arg)
	{
		List<PersonPojo> pp=Arrays.asList(new PersonPojo("aaa","london",23),new PersonPojo("bbb","US",60),new PersonPojo("ccc","Africa",40));
		GroupFromObject obj=new GroupFromObject();
		
		Map<String,Long> result=pp.stream().collect(Collectors.groupingBy(PersonPojo::getName,Collectors.counting()));
		System.out.println(result);
	}
	public static String name()
	{
	return "ajeeth";
	}

}
