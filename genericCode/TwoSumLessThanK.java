package genericCode;

import java.util.Arrays;

//Given an array A of integers and integer K, return the maximum S such that there exists i < j with A[i] + A[j] = S and 
//S < K. 
//If no i, j exist satisfying this equation, return -1.

public class TwoSumLessThanK {
	
	int finder(int[] num, int k) 
	{
	
		Arrays.parallelSort(num);		
		int i = 0;
		int j = num.length-1;
		int max = -1;
		while(i<j) 
		{
			
			int sum = num[i]+num[j];
			if(sum<k) 
			{
				max = Math.max(sum, max);
				i++;
			}
			else 
			{
				j--;
			}
			
		}
		return max;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {34,23,1,24,75,33,54,8};
		TwoSumLessThanK obj = new TwoSumLessThanK();
		int k = 60;
		long startTime = System.nanoTime();
		int result = obj.finder(arr,k);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println(duration);
		System.out.println(result);

	}

}
