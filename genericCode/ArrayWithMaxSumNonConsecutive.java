/*
 * Find the maximum sum of all element which is not consecutive in an unsorted array.
 * Greedy Approach will not work; Greedy Algorithm: Start with the largest number add the number to the final list and remove its consecutive
 * number i.e.
 * 10 9 8 7 6 --> Greedy Algo. will choose --> 10 8 6 which is working perfectly in this scenario.
 * Let consider another array : 10 5 5 9 8  --> Greedy Algo. will choose 10 9 whereas the optimum solution is 10 5 8. Hence, greedy algorithm
 * will not work. We need dynamic programming solution which is given below:-
 */

package genericCode;

public class ArrayWithMaxSumNonConsecutive {
	
	int finder(int[] num) 
	{
		int[] dp = new int[num.length];
		
		dp[0]=num[0];
		
		for(int i = 1; i<dp.length;i++) 
		{
			int sum1;
			int sum2;
			if(i-2<0) sum1 = num[i];
			else sum1 = dp[i-2]+num[i];
			sum2 = dp[i-1];
			dp[i] = Math.max(sum1, sum2);
		}
		return dp[num.length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayWithMaxSumNonConsecutive obj = new ArrayWithMaxSumNonConsecutive();
		int[] arr = {8,4,10,5,1,9,7};
		System.out.print(obj.finder(arr));
		

	}

}
