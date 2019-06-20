package genericCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.
*
*/

//For each node there can be 4 ways that the max path goes through the node:
//1. Node only
//2. Max path through Left Child + Node
//3. Max path through Right Child + Node
//4. Max path through Left Child + Node + Max path through Right Child
// We check all these path and save the maximum of all and then return the maximum

class Node4 
{ 
    int data; 
    Node4 left, right; 
    public Node4(int item) // COnstructor
    { 
        data = item; 
        left = right = null; 
    } 
} 
  
class MaximumPathSum 
{ 
    // Root of the Binary Tree
     Node4 root; 
     int res = Integer.MIN_VALUE;
    public MaximumPathSum() // Constructor 
    { 
        root = null; 
    } 
  
    int maximumSum(Node4 root)  //Main function to find max path sum
    {
    	
    	if(root==null) return 0;
    	
    	int l = maximumSum(root.left); // recursively call left part
    	int r = maximumSum(root.right);// recursively call right part
    	
    	int max = Math.max(Math.max(l, r) + root.data,root.data); // find maximum sum by taking maximum of two child+parent compare to parent itself
    	int max_top = Math.max(max, l+r+root.data); // find max if we include both the child with parent. 
    	
    	this.res = Math.max(max_top, this.res); // save the maximum either including parent or not.
    	
    	return max;
    }
    void preorder(Node4 root) // printing function
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
    	MaximumPathSum tree = new MaximumPathSum(); 
       tree.root= new Node4(10); 
       tree.root.left= new Node4(2); 
       tree.root.right= new Node4(10); 
       tree.root.left.left= new Node4(20); 
       tree.root.left.right= new Node4(1); 
       tree.root.right.right= new Node4(-25);
       tree.root.right.right.left= new Node4(3); 
       tree.root.right.right.right= new Node4(4); 

//       tree.preorder(tree.root);
        int result = tree.maximumSum(tree.root);
        System.out.print(tree.res);
 
    } 
} 