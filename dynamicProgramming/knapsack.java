/**
 * 
 */
package dynamicProgramming;

/**
 * @author Baljeet Singh
 *
 */
public class knapsack {
	
	int solveKnapsack(int[] profit, int[] weight, int capacity)
	{
		int[][] dp= new int[profit.length][capacity+1 ];
		
		for(int i=0;i<profit.length;i++)
		{
			dp[i][0] = 0;
		}
		
		for(int j=0;j<=capacity;j++)
		{
			if(capacity<=weight[0])
			dp[0][j]=profit[0];
		}
		
		for(int i =1;i<profit.length;i++)
		{
			for(int j = 1;j<=capacity;j++)
			{
				int profit1 = 0,profit2=0;
				if(weight[i]<=j){
					profit1 = profit[i] + dp[i-1][capacity-weight[i]];
				}
				profit2 = dp[i-1][j];
				dp[i][j] = Math.max(profit1,profit2);
		
			}
		}
		
		return dp[profit.length-1][capacity];
	} 
	

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		 knapsack ks = new knapsack();
		    int[] profits = {1, 6, 10, 16};
		    int[] weights = {1, 2, 3, 5};
		    
		    int maxProfit = ks.solveKnapsack(profits, weights, 7);
		    System.out.println("Total knapsack profit ---> " + maxProfit);
		    maxProfit = ks.solveKnapsack(profits, weights, 6);
		    System.out.println("Total knapsack profit ---> " + maxProfit);
		  }

	}

