package genericCode;

import java.util.ArrayList;

public class SpiralMatrix {
	
	ArrayList<Integer> printMatrix(int[][] input) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		int m = 0;
		int k =0;
		int n = input.length-1;
		int l = input[0].length-1;
		
		while(k<=l && m<=n) 
		{
			for(int i=k;i<=l;i++) 
			{
				list.add(input[k][i]);
			}
			m++;
			
			for(int i=m;i<=n;i++) 
			{
				list.add(input[i][l]);
			}
			l--;
			
			if(m<=n) 
			{
				for(int i=l;i>=k;i--) 
				{
					list.add(input[n][i]);
				}
				n--;
			}
			if(k<=l) 
			{
				for(int i=n;i>=m;i--) 
				{
					list.add(input[i][k]);
				}
				k++;
			}
			
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix obj = new SpiralMatrix();
		int[][] input = {
		         {1, 2, 3, 4},
		         {5, 6, 7, 8},
		         {9,10,11,12}
		};
		
		ArrayList<Integer> result = obj.printMatrix(input);
		
		for(int val : result) 
		{
			System.out.print(val+" ");
		}

	}

}
