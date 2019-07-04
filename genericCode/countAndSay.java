/*The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 */

package genericCode;

public class countAndSay {
	
	String builder(int num) 
	{
		StringBuilder str = new StringBuilder();
		int count =0;
		char temp =' ';
		
		
		for(int i=1;i<=num;i++) 
		{
			StringBuilder tempStr = new StringBuilder();
			if(i==1) 
			{
				str.append("1");
				tempStr.append(str);
			}
			else 
			{
				int j =0;
				
				while(j<str.length()) 
				{
					temp = str.charAt(j);
					while(j<str.length() && temp==str.charAt(j))
					{
						count++;
						j++;
					}
					tempStr.append(count);
					count=0;
					tempStr.append(temp);
				}
			}
			
			str.setLength(0);
			str.append(tempStr);
		}
		
		return str.toString();
	}

	public static void main(String[] args) {
		countAndSay obj = new countAndSay();
		int num =30;
		System.out.print(obj.builder(num));
	
	}

}
