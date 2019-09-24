package lambdaexpression;

import java.util.Arrays;
import java.util.List;

public class LambdaBasicForEach {
	
	
	public static void main(String[] arg)
	{
		
		//Lambda ForEach Example
		List<String> list=Arrays.asList("Test1","Test2","Test3","Test4");
		
		//iterating using lambda for each
		list.forEach(l->System.out.println("Data:"+l));
		
		
		List<PersonPojo> personList=Arrays.asList(new PersonPojo("praveen","Thanjavur",23),new PersonPojo("prakash","Thanjavur",23),new PersonPojo("Siva","Thanjavur",23));
		personList.forEach(pl->System.out.println("Data for person:  Name:"+pl.getName()
		
				+"\tAddress:"+pl.getAddress()
				));
		
		
		
		
	}

}
