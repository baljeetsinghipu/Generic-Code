/*
 * Find the maximum sum of all element which is not consecutive in an unsorted array.
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
