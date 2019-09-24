package lambdaexpression;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WithLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<PersonPojo> list=Arrays.asList(new PersonPojo("zzz","xxx",23),
				new PersonPojo("zzz","xxx",23),
				new PersonPojo("fff","xxx",23),
				new PersonPojo("aaa","xxx",23),
				new PersonPojo("ccc","xxx",23));
		
		Collections.sort(list,(p1,p2)->p1.getName().compareTo(p2.getName()));
		
		printConditionally(list,p->p.getName().startsWith("C"));

	}

	private static void printConditionally(List<PersonPojo> list, Display d) {
		// TODO Auto-generated method stub
		list.forEach(l->System.out.println("...........:DataTest:"+d.show(l)));
		
	}

}
interface Display
{
	boolean show(PersonPojo p);
}
