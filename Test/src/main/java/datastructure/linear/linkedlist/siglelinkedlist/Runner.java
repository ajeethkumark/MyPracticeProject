package datastructure.linear.linkedlist.siglelinkedlist;

public class Runner {
	public static void main(String[] arg)
	{
		LinkedList linkedList=new LinkedList();
		linkedList.insert(2);
		linkedList.insert(10);
		linkedList.insert(56);
		linkedList.insert(70);
		
		linkedList.insertAtStart(1);
		
		linkedList.insertAt(3, 3);
		
		linkedList.show();
	}
}
