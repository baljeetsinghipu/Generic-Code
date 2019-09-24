package standardClasses;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	LinkedList<Integer> adjList[];
	
	int V = 0;
	int time =0;
	
	Graph(int V)
	{
		this.V = V;
		adjList = new LinkedList[V];
		
		for(int i = 0;i<V;i++) 
		{
			adjList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int source, int destination) 
	{
		this.adjList[source].add(destination);
		this.adjList[destination].add(source);
	}
	
	public void dfs(int source) //perform dfs using stack 
	{
		boolean[]visited = new boolean[this.V];
//		visited[source]=true;
		
		Stack<Integer> stack = new Stack<>(); 
		stack.push(source);
		
		while(stack.isEmpty()==false) 
		{
			int temp = stack.pop();
			
			if (visited[temp]==false) {
				
				System.out.println(temp);
				visited[temp] = true; 
				
			}
			Iterator<Integer> itr = adjList[temp].iterator();
			
			while(itr.hasNext()) 
			{
				int b = itr.next();
				if(visited[b]==false) stack.push(b);
			}
			
		}
		
	}
	
	public void bfs(int source) //perform BFS using Queue
	{
		boolean[] visited = new boolean[this.V];
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		visited[source] = true;
		
		while(q.size()>0) 
		{
			int temp = q.poll();
			
			System.out.println(temp);
			
			Iterator<Integer> itr = this.adjList[temp].iterator();
			
			while(itr.hasNext()) 
			{
				int n = itr.next();
				
				if(visited[n]==false) 
				{
				visited[n]=true;
				q.add(n);
				}
			}
		}
		
	}
	
	public void bridgeutil(int i, boolean[] visited, int[] disc, int[] low, int[] parent) 
	{
		visited[i]=true;
		disc[i] = low[i] = ++this.time;
		
		
		
		
	}
	public void articulation_utility(int u, boolean[]visited, int[]disc, int[] low, int[] parent,boolean[] ap) 
	{
		visited[u] = true;
		disc[u] = low[u] = ++this.time;
		int children = 0;
		
		Iterator<Integer> itr = this.adjList[u].iterator();
		
		while(itr.hasNext()) 
		{
			int current = itr.next();
			
			if(visited[current]==false) 
			{
				children++;
				parent[current] = u;
				this.articulation_utility(current, visited, disc, low, parent, ap);
				
				low[u]=Math.min(low[u],low[current]);
				
				if(parent[u]==-1 && children>1 ) 
				{
					ap[u]= true;
				}
				if(parent[u]!=-1 && low[current]>=disc[u]) ap[u]=true;
				
			}
			
			else if(current != parent[u]) 
			{
				low[u]=Math.min(low[u],disc[current]);
				
			}
			
			
		}
		
	}
	
	public void articulation_points() 
	{
		boolean visited[] = new boolean[this.V];
		int disc[]= new int[this.V];
		int low[]= new int[this.V];
		int parent[]= new int[this.V];
		boolean[] articulation_point = new boolean[this.V];
		
		for(int i = 0;i<this.V;i++) 
		{
			parent[i]=-1;
			visited[i]=false;
			articulation_point[i] =false;
		}
		
		for (int i = 0; i < this.V; i++) {
			
			if(visited[i]==false) 
			articulation_utility(i, visited, disc, low, parent,articulation_point);
		}
		
		for(int i =0;i<articulation_point.length;i++) 
		{
			if(articulation_point[i]==true) 
			{
				System.out.println(i);
			}
		}
		
	}
	
	public void bridgeutility(int u, boolean[]visited, int[]disc, int[] low, int[] parent,boolean[] ap) 
	{
		visited[u] = true;
		disc[u] = low[u] = ++this.time;
	
		
		Iterator<Integer> itr = this.adjList[u].iterator();
		
		while(itr.hasNext()) 
		{
			int current = itr.next();
			
			if(visited[current]==false) 
			{
				
	
				parent[current] = u;
				this.bridgeutility(current, visited, disc, low, parent, ap);
				
				low[u]=Math.min(low[u],low[current]);
	
				if(low[current]>disc[u]) 
				{
					System.out.println(u+" "+current);;
				}
				
			}
			
			else if(current != parent[u]) 
			{
				low[u]=Math.min(low[u],disc[current]);
				
			}
			
			
		}
		
		
	}
	
	
	
	
	public void bride() 
	{
		boolean visited[] = new boolean[this.V];
		int disc[]= new int[this.V];
		int low[]= new int[this.V];
		int parent[]= new int[this.V];
		boolean[] articulation_point = new boolean[this.V];
		
		for(int i = 0;i<this.V;i++) 
		{
			parent[i]=-1;
			visited[i]=false;
			articulation_point[i] =false;
		}
		
		for (int i = 0; i < this.V; i++) {
			
			if(visited[i]==false) 
			bridgeutility(i, visited, disc, low, parent,articulation_point);
		}
		
		
	}
	
	
	public void printGraph(Graph graph) 
    {        
        for(int v = 0; v <graph.V; v++) 
        { 
            System.out.println("Adjacency list of vertex "+ v); 
            System.out.print("head"); 
            System.out.println(v);
            for(Integer pCrawl: graph.adjList[v]){ 
                System.out.print(" -> "+pCrawl); 
            } 
            System.out.println("\n"); 
        } 
    } 

	public static void main(String[] args) {
		
		int V = 5; 
        Graph graph = new Graph(V); 
        
//        graph.addEdge(0, 1); 
//        graph.addEdge(0, 4); 
//        graph.addEdge(1, 2); 
//        graph.addEdge(1, 3); 
//        graph.addEdge(1, 4); 
//        graph.addEdge(2, 3); 
//        graph.addEdge(3, 4); 
        
//        graph.addEdge(1, 0); 
//        graph.addEdge(0, 2); 
//        graph.addEdge(2, 1); 
//        graph.addEdge(0, 3); 
//        graph.addEdge(1, 4);
        
        graph.addEdge(1, 0); 
        graph.addEdge(0, 2); 
        graph.addEdge(2, 1); 
        graph.addEdge(0, 3); 
        graph.addEdge(3, 4);
        
//        graph.printGraph(graph);
        graph.bride();
        
      

	}

}
