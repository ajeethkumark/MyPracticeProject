package thread;

class Q{
	int num;
	boolean valueSet = false;
	public synchronized void put(int num)
	{
		if(valueSet)
		{
			try
			{
				System.out.println("Enter into put (beforewait)");
				wait();
				System.out.println("Enter into put (afterwait)");
				
			}
			catch(Exception e)
			{
				System.out.println("Error in Q put");
			}
		}
		System.out.println("put :"+num);
		this.num=num;
		valueSet=true;
		notify();
	}
	
	public synchronized void get()
	{
		//synchronized
		if(!valueSet)
		{
			try{
				System.out.println("Enter into get (beforewait)");
				wait();
				System.out.println("Enter into get (afterwait)");
				
			}
			catch(Exception e)
			{
				System.out.println("Exception in Q get");
			}
		}
			System.out.println("Get : "+num);
			valueSet=false;
			notify();
		
	}
}

class Producer implements Runnable{
	Q q;
	public Producer(Q q)
	{
		this.q=q;
		Thread t=new Thread(this,"producer");
		t.start();
	}
	public void run()
	{
		int i=0;
		while(true)
		{
			q.put(i++);
			try{
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				System.out.println("Exception in consumer");
			}
		}
	}
}

class Consumer implements Runnable{
	Q q;
	public Consumer(Q q)
	{
		this.q=q;
		Thread t=new Thread(this,"consumer");
		t.start();
	}
	public void run()
	{
		while(true)
		{
			q.get();
			try{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println("Exception in consumer");
			}
		}
	}
}
public class InterThread
{
	public static void main(String[] arg)
	{
		Q q=new Q();
		new Producer(q);
		new Consumer(q);
	}
}