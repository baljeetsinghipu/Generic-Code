/*
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

 

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 

Note:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 */



package genericCode;

import java.util.*;

public class taskScheduler {
	int scheduler(char[] tasks, int n) 
	{
		int[] map = new int[26];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (char c: tasks)
            map[c -'A']++;
		
		for(int f:map) 
		{
			if(f>0) pq.add(f);
		}
		int time=0;
		
		while(!pq.isEmpty()) 
		{
			List<Integer> temp = new ArrayList<Integer>(); 
			int i =0;
			while(i<=n) 
			{
				if(!pq.isEmpty())
				{				
					if(pq.peek()>1) 
					{
						temp.add(pq.poll()-1);
					}
					else pq.poll();
				}
				time++;
				if(pq.isEmpty() && temp.size()==0) break; 
				i++;
			}
			for(int g: temp) pq.add(g);			
			
		}
		return time;
	}

	public static void main(String[] args) {
		taskScheduler obj = new taskScheduler();
		int n =2;
		char[] input = {'A','A','A','B','B','B'};
		System.out.print(obj.scheduler(input,n));

	}

}
