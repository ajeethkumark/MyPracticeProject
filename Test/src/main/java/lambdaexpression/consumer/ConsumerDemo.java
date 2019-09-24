package lambdaexpression.consumer;

import java.util.function.Consumer;

public class ConsumerDemo implements Consumer<Integer>{
	
	public static void main(String[] arg)
	{
		ConsumerDemo cd=new ConsumerDemo();
		cd.accept(10);
	}

	@Override
	public void accept(Integer i) {
		// TODO Auto-generated method stub
		System.out.println("Vale:"+i);
		
	}

}
