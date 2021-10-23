package datastructure.nonlinear;

import java.util.ArrayList;

public class BinaryTree {
	
	public static void main(String[] arg)
	{
		Node root=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);
		Node node6=new Node(6);
		Node node7=new Node(7);
		Node node8=new Node(8);
		
		root.left=node2;
		root.right=node3;		
		node3.left=node4;
		node3.right=node5;
		node2.left=node6;
		node2.right=node7;
		ArrayList<Integer> leftNodeResult=new ArrayList<Integer>();
		BinaryTree binaryTree=new BinaryTree();
		
		//To collect left outline
		binaryTree.view(root,leftNodeResult,true,false);
		System.out.println("LeftViewofBinaryTree:"+leftNodeResult);
		
		////To collect right outline
		ArrayList<Integer> rightNodeList=new ArrayList<Integer>();
		binaryTree.view(root,rightNodeList,false,true);
		System.out.println("RightView:"+rightNodeList);
		
		
	 /*
	  *          1
	  *     2         3
	  *    
	  *  6     7      4    5
	  */
	}
	
	/**
	 * This method is to print the left View of BS
	 */
	
/*public void leftView(Node root,ArrayList<Integer> result,boolean isViewEnable)
{
	if(root ==null)
		return;
	if(isViewEnable) {
		result.add(root.data);
	}
	leftView(root.left,result,true);
	leftView(root.right,result,false);
} */

	/**
	 * This method is to return the outerline of Binary Search
	 * @param root
	 * @param result
	 * @param isViewEnable
	 */
	public void view(Node root,ArrayList<Integer> result,boolean isLeftView,boolean isRightview)
	
	{
		if(root ==null)
			return;
		if(isLeftView) {
			result.add(root.data);
			view(root.left,result,true,false);
		}
		else if(isRightview)
		{
			result.add(root.data);
			view(root.right,result,false,true);
		}
		
		//leftView(root.right,result,false);
	} 
	
}

class Node{
	int data;
	Node left,right;
	public Node(int data)
	{
		this.data=data;
		this.left=this.right=null;
	}
}