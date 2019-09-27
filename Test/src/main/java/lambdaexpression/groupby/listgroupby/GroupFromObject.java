package lambdaexpression.groupby.listgroupby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lambdaexpression.PersonPojo;

public class GroupFromObject {
	
	public static void main(String[] arg)
	{
		List<PersonPojo> pp=Arrays.asList(new PersonPojo("ajeeth","Thanjavur",23),new PersonPojo("praveen","chennai",10),new PersonPojo("ajeeth","Trichy",10));
		GroupFromObject obj=new GroupFromObject();
		
		Map<String,Long> result=pp.stream().collect(Collectors.groupingBy(PersonPojo::getName,Collectors.counting()));
	}
	public static String name()
	{
	return "ajeeth";
	}

}
