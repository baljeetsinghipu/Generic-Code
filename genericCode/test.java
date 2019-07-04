package genericCode;

import java.util.*;
public class test {
	
	void calculateClosest(int[][] points,int k)
	{
		int[][] result=new int [k][2]; 
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1,p2)->(-(p2[0]+p2[1])+(p1[0]+p1[1])));
		
		for(int[] point: points) 
		{
			pq.add(point);
//			if(pq.size()>k) pq.poll();
		}
		int[] temp = pq.poll();
		for(int r : temp) 
		{
			System.out.print(r);
			
		}
	}
			
//		return result;
		
		


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		String s1="12"+"13";
		System.out.print(s1);

	}

}
