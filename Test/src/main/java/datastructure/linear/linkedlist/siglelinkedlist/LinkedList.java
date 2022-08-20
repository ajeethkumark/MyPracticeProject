package datastructure.linear.linkedlist.siglelinkedlist;

public class LinkedList {
	Node head;

	public void insert(int data) {
		Node newNode=new Node();
		newNode.data=data;
		newNode.next=null;
		
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			Node node=head;
			while(node.next!=null)
			{
				node=node.next;
			}
			node.next=newNode;
		}
	}
	
	
	public void show()
	{
		Node node=head;
		while(node.next!=null)
		{			
			System.out.println("Value:"+node.data);
			node=node.next;
		}
		System.out.println("Value:"+node.data);
	}
	
	
	public void insertAtStart(int data)
	{
		Node newNode=new Node();
		newNode.data=data;
		newNode.next=head;
		head=newNode;
	}
	
	
	public void insertAt(int position,int data)
	{
		Node newNode=new Node();
		newNode.data=data;
		newNode.next=null;
		
		Node n=head;
		for(int i=0;i<position-2;i++) {
			n=n.next;
		}
		newNode.next=n.next;
		n.next=newNode;
		System.out.println("-:"+n.data);
		
		
	}
}
