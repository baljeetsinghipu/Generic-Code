package dynamicProgramming;

import java.util.ArrayList;

public class PowerSet {
	
	static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set,int index)
	{
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		if(set.size()==index)
		{
			allsubsets.add(new ArrayList<Integer>());
		}
		
		else
		{
			allsubsets = getSubsets(set,index+1);
			int item = 	set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>(); 
			for(ArrayList<Integer> subset: allsubsets)
			{
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); //
				newsubset.add(item);
				moresubsets.add(newsubset); 
			}
			allsubsets.addAll(moresubsets);
		}
		
		return allsubsets;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		ret=getSubsets(list,0);
		System.out.print(ret);
		
		
		

	}

}
