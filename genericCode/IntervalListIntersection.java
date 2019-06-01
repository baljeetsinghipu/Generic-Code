package genericCode;

/*

Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  
The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented 
as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

*/

import java.util.ArrayList;
import java.util.Arrays;

public class IntervalListIntersection {
	
	int[][] finder(int[][]A,int[][]B)
	{
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		if(A.length == 0 || B.length ==0) return list.toArray(new int[list.size()][]);
		int i = 0;
		int j = 0;
		
		while(i<A.length && j<B.length) 
		{
			
			int low = Math.max(A[i][0], B[j][0]); // find maximum of starting element of given range
			int high = Math.min(A[i][1], B[j][1]); // find minimum of last element of given range
			
			if(low<=high) list.add(new int[]{low,high}); // if low<=high means out extracted low and high value is valid; we can add it to our final list
			
			if(A[i][1]<B[j][1]) i++; // move the ith pointer to next range if range of Bth is greater than Ath.
			else j++;
		}
		
		return list.toArray(new int[list.size()][]); //list to int array conversion;
	}

	public static void main(String[] args) { //Main driver function
		
		IntervalListIntersection obj = new IntervalListIntersection();
		int[][] A = {{0,2},{5,10},{13,23},{24,25}}; // Input-1 interval
		int[][] B = {{1,13},{8,12},{15,24},{25,26}}; //Input-2 Interval
		
		int[][] result = obj.finder(A,B); // Function to find intersection interval
		
		System.out.print(Arrays.deepToString(result)); // print result

	}

}
