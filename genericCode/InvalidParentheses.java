/* Remove Invalid Parentheses
 * 
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * 
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * 
 * 
 */


package genericCode;

import java.util.*;

public class InvalidParentheses {
	
	List<String> parenthesesCorrector(String str)
	{
		ArrayList<String> result = new ArrayList<String>();
		
		helper(str,result,0,0,'(',')');
		
		return result;
	}
	
	void helper(String str, List<String> result,int i,int j,char open,char close)
	{
		int closeNum=0; //close bracket counter;
		int openNum=0; // open bracket counter
		for(int k=i;k<str.length();k++)
		{
			
			if(str.charAt(k)==close) closeNum++;
			else if(str.charAt(k)==open) openNum++;
			if(closeNum>openNum)  // when close bracket become more than open bracket, we need to adjust to string. 
			{
				for(int m=j;m<k;m++) 
				{
					if(str.charAt(m)==close && (str.charAt(m-1)!=close || m==j)) 
					{
						helper(str.substring(0,m)+str.substring(m+1,str.length()),result,i,j,open,close);
					}
				}
				return;
			}
		}
			
			String str1= new StringBuilder(str).reverse().toString();
			
			if(open=='(') helper(str1,result,0,0,')','(');
			else result.add(str1);
			
		}
		


	public static void main(String[] args) {
		InvalidParentheses obj = new InvalidParentheses();
//		String str = "()())()";
		String str = "(()(()";
		List<String> result=obj.parenthesesCorrector(str);
		System.out.print(result.toString());
		

	}

}
