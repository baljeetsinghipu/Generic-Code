package genericCode;

public class Dijsktra_algorithm {
	int total_vertices;
	public Dijsktra_algorithm(int total){
		total_vertices=total;
		
	}
	// find the vertex with minimum distance value
    int minDist(int distance[], Boolean visited[]) 
    { 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < total_vertices; v++) 
            if (visited[v] == false && distance[v] <= min) 
            { 
                min = distance[v]; min_index = v; 
            } 
        return min_index; 
    } 

    //Main algorithm to find shorted path
    void dijkstraAlgorithm(int graph[][], int src) 
    { 
        int distance[] = new int[total_vertices];
        Boolean visited[] = new Boolean[total_vertices]; 
        for (int i = 0; i < total_vertices; i++) 
        { 
            distance[i] = Integer.MAX_VALUE; 
            visited[i] = false; 
        } 
        distance[src] = 0; 
        for (int count = 0; count < total_vertices-1; count++) 
        { 
            int currentVertex = minDist(distance, visited); 
            visited[currentVertex] = true; 
            for (int v = 0; v < total_vertices; v++) 
                if (visited[v]==false && graph[currentVertex][v]!=0 && distance[currentVertex] != Integer.MAX_VALUE && distance[currentVertex]+graph[currentVertex][v] < distance[v]) 
                    distance[v] = distance[currentVertex] + graph[currentVertex][v]; 
        } 
        printNodeWithDistance(distance, total_vertices, src); 
    }
    //Print the vertices along with the vertices from the source
    void printNodeWithDistance(int distance[], int n, int src) 
    { 
        System.out.println("Vertex | Dist. from Src (" + "vertex:"+src+")" ); 
        for (int i = 0; i < total_vertices; i++) System.out.println("  "+i+"    |      "+distance[i]); 
    } 

	public static void main(String[] args) {
	       int graph[][] = new int[][]{{0,7,9,0,5,0,0,8,0,0,0,0,0,0,0,0,0,0},
	    		   					   {7,0,9,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0},
	    		   					   {9,9,0,4,0,0,5,0,0,0,0,0,0,0,0,0,0,0},
	    		   					   {0,0,4,0,0,0,1,0,0,0,4,0,0,0,0,0,0,4},
	    		   					   {5,2,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0},
	    		   					   {0,0,0,0,1,0,5,0,0,6,0,0,0,0,0,0,0,0},
	    		   					   {0,0,5,1,0,5,0,0,0,1,0,0,0,0,0,0,0,0},
	    		   					   {8,0,0,0,1,0,0,0,5,0,0,3,0,0,3,0,0,0},
	    		   					   {0,0,0,0,1,0,0,5,0,2,0,3,0,0,0,0,0,0},
	    		   					   {0,0,0,0,0,6,1,0,2,0,3,0,1,9,0,0,0,0},
	    		   					   {0,0,0,4,0,0,0,0,0,3,0,0,0,7,0,0,0,0},
	    		   					   {0,0,0,0,0,0,0,3,3,0,0,0,8,0,5,0,0,0},
	    		   					   {0,0,0,0,0,0,0,0,0,1,0,8,0,4,0,8,3,0},
	    		   					   {0,0,0,0,0,0,0,0,0,9,7,0,4,0,0,0,0,1},
	    		   					   {0,0,0,0,0,0,0,3,0,0,0,5,0,0,0,4,0,0},
	    		   					   {0,0,0,0,0,0,0,0,0,0,0,0,8,0,4,0,0,1},
	    		   					   {0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,1},
	    		   					   {0,0,0,4,0,0,0,0,0,0,0,0,0,1,0,1,1,0}};
     
	       Dijsktra_algorithm obj = new Dijsktra_algorithm(graph[0].length);
	       System.out.println("");
	       System.out.println("-------Adjacent Matrix of Graph-----");
	       System.out.println("");
	       System.out.println(""
	       		+ "{0,7,9,0,5,0,0,8,0,0,0,0,0,0,0,0,0,0},\n"
	       		+ "{7,0,9,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0},\n"
	       		+ "{9,9,0,4,0,0,5,0,0,0,0,0,0,0,0,0,0,0},\n"
	       		+ "{0,0,4,0,0,0,1,0,0,0,4,0,0,0,0,0,0,4},\n"
	       		+ "{5,2,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0},\n"
	       		+ "{0,0,0,0,1,0,5,0,0,6,0,0,0,0,0,0,0,0},\n"
	       		+ "{0,0,5,1,0,5,0,0,0,1,0,0,0,0,0,0,0,0},\n"
	       		+ "{8,0,0,0,1,0,0,0,5,0,0,3,0,0,3,0,0,0},\n"
	       		+ "{0,0,0,0,1,0,0,5,0,2,0,3,0,0,0,0,0,0},\n"
	       		+ "{0,0,0,0,0,6,1,0,2,0,3,0,1,9,0,0,0,0},\n"
	       		+ "{0,0,0,4,0,0,0,0,0,3,0,0,0,7,0,0,0,0},\n"
	       		+ "{0,0,0,0,0,0,0,3,3,0,0,0,8,0,5,0,0,0},\n"
	       		+ "{0,0,0,0,0,0,0,0,0,1,0,8,0,4,0,8,3,0},\n"
	       		+ "{0,0,0,0,0,0,0,0,0,9,7,0,4,0,0,0,0,1},\n"
	       		+ "{0,0,0,0,0,0,0,3,0,0,0,5,0,0,0,4,0,0},\n"
	       		+ "{0,0,0,0,0,0,0,0,0,0,0,0,8,0,4,0,0,1},\n"
	       		+ "{0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,1},\n"
	       		+ "{0,0,0,4,0,0,0,0,0,0,0,0,0,1,0,1,1,0}");
	       System.out.println("");
	       System.out.println("---------Result-------------");
	       System.out.println("");
	       obj.dijkstraAlgorithm(graph, 0); 
	    } 
	} 