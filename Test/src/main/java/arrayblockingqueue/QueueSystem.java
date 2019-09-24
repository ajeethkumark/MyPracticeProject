package arrayblockingqueue;

import java.time.LocalTime;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueSystem {
	
	public static void main(String[] m) throws InterruptedException
	{
		ArrayBlockingQueue<Integer> abq=new ArrayBlockingQueue<Integer>(10);
		int value=0;
		System.out.println(".time.."+LocalTime.now());
		for(int i=0;i<15;i++)
		{
			System.out.println("Entered:"+i);
			abq.add(i);
		}
	/* 	System.out.println(".........**......"+value+"........."+abq);
		System.out.println("....peek......."+abq.peek()+"........."+abq.take());   */
		System.out.println(".....poll......."+abq.poll());   
		for(int j=0;j<abq.size();j++)
		{
			System.out.println("........"+abq);
		}
		abq.clear();
		
	System.out.println("over");
	}
	

}
