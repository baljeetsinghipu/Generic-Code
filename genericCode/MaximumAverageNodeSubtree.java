package genericCode;

/*
Subtree: Maximum Average Node
Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
Example Given a binary tree:
*/

class Node 
{ 
    int data; 
    Node left, right; 
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 
  
class MaximumAverageNodeSubtree 
{ 
    // Root of the Binary Tree 
     Node root; 
     Node resultNode = new Node(-1);
     int sum= -1;
    public MaximumAverageNodeSubtree() 
    { 
        root = null; 
    } 
  
    
    void maxNode(Node root) 
    {
    	
    	int temp = maxNodeHelper(root,this.sum);
    	System.out.println(resultNode.data);
    	
    	
    }
    
    int maxNodeHelper(Node currentNode,int sum) 
    { 
    	
    	if(currentNode==null) return -1;
    	else if(currentNode.left == null && currentNode.right==null) return currentNode.data;
    	else 
    	{
    		int n1=maxNodeHelper(currentNode.left,sum); 
    		int n2=maxNodeHelper(currentNode.right,sum); 
    		int temp = this.sum;
    		this.sum = currentNode.data + n1 +n2;
    		if(this.sum>temp) {resultNode = currentNode;}
    		return sum;
    	}
    }
      
    /* Driver program to test above functions */
    public static void main(String args[]) 
    { 
       MaximumAverageNodeSubtree tree = new MaximumAverageNodeSubtree(); 
       tree.root= new Node(2); 
       tree.root.left= new Node(-2); 
       tree.root.right= new Node(14); 
       tree.root.left.left= new Node(-1); 
       tree.root.left.right= new Node(1); 
       tree.root.right.left= new Node(5); 
       tree.root.right.right= new Node(-1); 
         
       tree.maxNode(tree.root);
 
    } 
} 