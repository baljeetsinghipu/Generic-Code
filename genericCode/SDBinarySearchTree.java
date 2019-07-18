package genericCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
*/

class Node3 
{ 
    int data; 
    Node3 left, right; 
    public Node3(int item) // COnstructor
    { 
        data = item; 
        left = right = null; 
    } 
} 
  
class SDBinarySearchTree 
{ 
    // Root of the Binary Tree
     Node3 root; 
     Node3 resultNode = new Node3(-1);
     Queue<Node3> q = new LinkedList<Node3>(); // Queue for serialization process
     StringBuilder str = new StringBuilder(); // String for serialization process
     int sum= -1;
    public SDBinarySearchTree() // Constructor 
    { 
        root = null; 
    } 
  

    public String serialize(Node3 root) {
    	q.add(root); // add root node to the queue;
    	while(q.size()>0) 
    	{
    		
    		Node3 temp = q.poll(); //Extract element from queue;
    		if(temp==null) str.append("n "); // if node is null place n otherwise add value of node.
    		else {
    			str.append(temp.data+" ");
    			q.add(temp.left); // left recursive call
    			q.add(temp.right); //right recursive call
    		}
    	}
    	
		return str.toString();
        
    }

    // Decodes your encoded data to tree.
    public Node3 deserialize(String data) {
   
  
    	String[] arr=data.split(" ") ; //splits with spaces
    	Deque<Node3> dq = new LinkedList<Node3>(); //Dequeue initialization
    	
    	dq.add(root); //add root node to dequeue
    	
    	int i =1;
    	Node3 left = null; //Left Node
    	Node3 right = null; //Right Node
    	
    	while(dq.size()>0) // Loop till queue is empty
    	{
    		
    		Node3 node = dq.pollFirst(); //extract left element from Dequeue
    		if(i<arr.length)  // check array overflow
    		{
    			if(arr[i].equals("n")) left = null; // Node is null in case n found.
    			else 
    			{
    				left = new Node3(Integer.parseInt(arr[i]));
    				node.left = left; //Append left child to the node
    			}
    			
    		}
    		i++;
    		if(i+1<arr.length) // check array overflow
    		{ 
    			if(arr[i].equals("n")) right=null;
    			else 
    			{
    				right = new Node3(Integer.parseInt(arr[i]));
    				node.right = right; // Append right child to the node.
    			}
    		}
    		i++;
    		if(left!=null)dq.add(left); // add left node to the Dequeue
    		if(right!=null)dq.add(right); // add eight node to the Dequeue
    		
    	}
    	
    	return root; //return the final tree
    }

    void preorder(Node3 root)
    {
    	if(root==null) return;
    	else 
    	{
    		System.out.print(root.data +"  ");
    		preorder(root.left); //Left recursive call
    		
    		preorder(root.right); //Right recursive call
    	}
    }

	/* Driver program to test above functions */
    public static void main(String args[]) 
    { 
    	SDBinarySearchTree tree = new SDBinarySearchTree(); 
       tree.root= new Node3(-1); 
       tree.root.left= new Node3(0); 
       tree.root.right= new Node3(1); 
       tree.root.left.left= new Node3(-1); 
       tree.root.left.right= new Node3(1); 
       tree.root.right.left= new Node3(4); 
       tree.root.right.right= new Node3(5); 
         String result = tree.serialize(tree.root);
//         System.out.println(result);
         Node3 newTree =tree.deserialize(result);
         tree.preorder(newTree);
 
    } 
} 