package dynamicProgramming;

public class SubsetSumPartition {
	
	public boolean canPartition(int[] num)
	{
		int total=0;
		int half=0;
		for(int i:num)total+=i;
		if(total%2!=0) return false;
		else half = total/2;
		int n = num.length;
		boolean[][] dp = new boolean[n][half+1];
		
		for(int i =0;i<n;i++)
		{
			dp[0][i]=true;
		}
		for(int j =1;j<=n;j++)
		{		
			if(num[0]==half) dp[0][j]=true;
	 		else dp[0][j]=false;
		}
		
		for(int i =1;i<num.length ;i++)
		{
			for(int s =1 ; s<=half;s++)
			{	
				if(dp[i-1][s])
				{
					dp[i][s]=dp[i-1][s];
				}
				else if(s>=num[i])
					dp[i][s]=dp[i-1][s-num[i]];
			}
		}
		return dp[n-1][half];
	} 
	
	//for recursion
	boolean recursion(int[]num,int sum,int current_index)
	{
		if(current_index>num.length-1) return false;
		if(sum<0) return false;
		if(sum==0) return true;
		
		if(recursion(num,sum-num[current_index],current_index++)) return true;
		if(recursion(num,sum,current_index++)) return true;
		else return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SubsetSumPartition ps = new SubsetSumPartition();
	    int[] num = 
	    		{1,5,11,5};
	    System.out.println(ps.canPartition(num));
	    num = new int[]{1, 1, 3, 4, 7};
	    System.out.println(ps.canPartition(num));
	    num = new int[]{2, 3, 4, 6};
	    System.out.println(ps.canPartition(num));
	    

	}

}
