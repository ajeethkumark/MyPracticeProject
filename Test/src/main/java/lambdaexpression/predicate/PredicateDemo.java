package lambdaexpression.predicate;

import java.util.function.Predicate;

public class PredicateDemo implements Predicate<Integer> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<Integer> p=new PredicateDemo();
		System.out.println(p.test(10));

		
	}

	@Override
	public boolean test(Integer t) {
		// TODO Auto-generated method stub
		if(t%2==0)
			return true;
		
		return false;
	}

}
