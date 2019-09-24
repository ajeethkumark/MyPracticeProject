package lambdaexpression.supplier;

import java.util.function.Supplier;

public class SupplierDemo implements Supplier<String>{

	public static void main(String[] arg)
	{
		Supplier<String> supplier=new SupplierDemo();
		System.out.println("supplier Test:"+supplier.get());
	}

	@Override
	public String get() {
		// TODO Auto-generated method stub
		
		return "Hi Ajeeth";
	}
}
