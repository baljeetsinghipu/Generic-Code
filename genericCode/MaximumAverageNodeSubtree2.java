//package genericCode;
//
//import java.util.Stack;
//
///*
//Subtree: Maximum Average Node Using Stack / DFS
//Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
//Example Given a binary tree:
//*/
//
//class Node2 
//{ 
//    int data; 
//    Node2 left, right; 
//    public Node2(int item) 
//    { 
//        data = item; 
//        left = right = null; 
//    } 
//} 
//  
//class MaximumAverageNodeSubtree2 
//{ 
//    // Root of the Binary Tree 
//     Node2 root; 
//     Node2 resultNode = new Node2(-1);
//     Stack<Node2> stack = new Stack<Node2>();
//     int sum= -1;
//    public MaximumAverageNodeSubtree2() 
//    { 
//        root = null; 
//    } 
//  
//  
//    void maxNode(Node2 root) 
//    {
//    	stack.push(root);
//    	
//    	while()
//    	Node2 temp = stack.peek();
//    	if(temp.right!=null) stack.push(temp.right);
//    	if(temp.left!=null) stack.push(temp.left);
//    	
//    	
//    	
//    	
//    	
//    	
//    	
//    	
//    	
//    }
//    
//    int maxNodeHelper(Node2 currentNode,int sum) 
//    { 
//    	
//    	if(currentNode==null) return -1;
//    	else if(currentNode.left == null && currentNode.right==null) return currentNode.data;
//    	else 
//    	{
//    		int n1=maxNodeHelper(currentNode.left,sum); 
//    		int n2=maxNodeHelper(currentNode.right,sum); 
//    		int temp = this.sum;
//    		this.sum = currentNode.data + n1 +n2;
//    		if(this.sum>temp) {resultNode = currentNode;}
//    		return sum;
//    	}
//    }
//      
//    /* Driver program to test above functions */
//    public static void main(String args[]) 
//    { 
//       MaximumAverageNodeSubtree2 tree = new MaximumAverageNodeSubtree2(); 
//       tree.root= new Node2(2); 
//       tree.root.left= new Node2(-2); 
//       tree.root.right= new Node2(14); 
//       tree.root.left.left= new Node2(-1); 
//       tree.root.left.right= new Node2(1); 
//       tree.root.right.left= new Node2(5); 
//       tree.root.right.right= new Node2(-1); 
//         
//       tree.maxNode(tree.root);
// 
//    } 
//} 