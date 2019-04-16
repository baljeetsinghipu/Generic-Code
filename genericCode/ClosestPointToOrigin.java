package genericCode;

import java.util.*;
public class ClosestPointToOrigin {
	
	int[][] calculateClosest(int[][] points,int k)
	{
		int[][] result =new int [k][2]; 
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1,p2)->(-(p1[0]*p1[0] + p1[1]*p1[1]) + (p2[0]*p2[0] + p2[1]*p2[1])));
		
		for(int[] point: points) 
		{
			pq.add(point);
			if(pq.size()>k) pq.poll();
		}
		
		while(k>0) 
		{
			result[--k]=pq.poll();
			
		}
		return result;
		
		
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestPointToOrigin obj = new ClosestPointToOrigin();
		int[][] points = {{1,3},{-2,2},{0,5},{0,1},{0,0}};
		int k =3;
		int[][] result=obj.calculateClosest(points,k);
		System.out.print("[");
		for(int[] i : result) 
		{
			System.out.print("[");
			for(int j : i) {
			System.out.print(j);
			
			}
			System.out.print("]");
			
		}
		System.out.print("]");

	}

}
