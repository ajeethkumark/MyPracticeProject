package lambdaexpression;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WithOutLambda {
	public static void main(String[] arg)
	{
		List<PersonPojo> list=Arrays.asList(new PersonPojo("zzz","xxx",23),
				new PersonPojo("zzz","xxx",23),
				new PersonPojo("fff","xxx",23),
				new PersonPojo("aaa","xxx",23),
				new PersonPojo("ccc","xxx",23));
		
		Collections.sort(list,new Comparator<PersonPojo>() {

			@Override
			public int compare(PersonPojo a1, PersonPojo a2) {
				// TODO Auto-generated method stub
				return a1.getName().compareTo(a2.getName());
			}
			
		});
		
		list.forEach(l->System.out.println("ordered Data:"+l.getName()));
		
		
		
		for(PersonPojo p:list)
		{
			if(p.getName().startsWith("a"))
				System.out.println("......................:"+p.getName());
		}
		
		
		//.............................
		printConditionally(list,new test() {

			@Override
			public boolean show(PersonPojo p) {
				// TODO Auto-generated method stub
				return p.getName().startsWith("a");
			}
			
		});
		
		
	}

	private static void printConditionally(List<PersonPojo> list, test test) {
		// TODO Auto-generated method stub
		for(PersonPojo p:list)
		{
			if(test.show(p))
				System.out.println("................:"+p.getName());
		}
		
	}

}

interface test{
	boolean show(PersonPojo p);
}
