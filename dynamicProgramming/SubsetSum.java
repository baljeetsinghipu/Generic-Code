package dynamicProgramming;

public class SubsetSum {
	
	public boolean canPartition(int[] num,int sum)
	{
		
		int n = num.length;
		boolean[][] dp = new boolean[n][sum+1];
		
		for(int i =0;i<n;i++)
		{
			dp[i][0]=true;
		}
		for(int s =1;s<=sum;s++)
		{		
			if(num[0]==s) dp[0][s]=true;
			else dp[0][s]=false;
		}
		
		for(int i =1;i<num.length ;i++)
		{
//			for(int s =1 ; s<=sum;s++)
//			{	
//				if(dp[i-1][s])
//				{
//					dp[i][s]=dp[i-1][s];
//				}
//				else if(s>=num[i])
//					dp[i][s]=dp[i-1][s-num[i]];
//			}
			
			for(int s =1 ; s<=sum;s++)
			{	
				if(s>=num[i])
				dp[i][s]=dp[i-1][s] || dp[i-1][s-num[i]];
				else dp[i][s]=dp[i-1][s];
			}
			
//			for (int s = 1; s <= sum; s++) {
//		        // if we can get the sum 's' without the number at index 'i'
//		        if (dp[i - 1][s]) {
//		          dp[i][s] = dp[i - 1][s];
//		        } else if (s >= num[i]) {
//		          // else include the number and see if we can find a subset to get the remaining
//		          // sum
//		          dp[i][s] = dp[i - 1][s - num[i]];
//		        }
//		      }
			
		}
		return dp[n-1][sum];
	} 
	
	//for recursion
//	boolean recursion(int[]num,int sum,int current_index)
//	{
//		if(current_index>num.length-1) return false;
//		if(sum<0) return false;
//		if(sum==0) return true;
//		
//		if(recursion(num,sum-num[current_index],current_index++)) return true;
//		if(recursion(num,sum,current_index++)) return true;
//		else return false;
//		
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SubsetSum ss = new SubsetSum();
	    int[] num = { 1, 2, 3, 7 };
	    System.out.println(ss.canPartition(num, 6));
	    num = new int[] { 1, 2, 7, 1, 5 };
	    System.out.println(ss.canPartition(num, 10));
	    num = new int[] { 1, 3, 4, 8 };
	    System.out.println(ss.canPartition(num, 6));

	}

}
