/*
 * Multiply two numbers without using multiple operator and large int.
 * 
 */


package genericCode;


public class muliplyString {
	public String multiply(String num1, String num2) 
	{
		int temp=0;
		int carry=0;
		StringBuilder result = new StringBuilder();
		String str2 = "";
		int value=0;
		int result1=0;
		if(num1.length()<num2.length()) 
	        {
	           multiply(num2,num1);
	           return result.toString();
	        }
	        
		for(int i=num2.length()-1;i>=0;i--)
	        {
			for(int j=num1.length()-1;j>=0;j--)
	            {
	                temp=Character.getNumericValue(num2.charAt(i))*Character.getNumericValue(num1.charAt(j))+carry;
	                carry=temp/10;
	                str2 = temp%10 + str2;
	            }
			if(carry>0)str2 = carry + str2;
			carry=0;
			value = Integer.valueOf(str2) * (int)Math.pow(10, num2.length()-1-i);
			System.out.println(value);
			str2="";
			result1=value + result1;
	        }
	        
			result.append(result1);
	        return result.toString();
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		muliplyString obj = new muliplyString();
		String num1="3";
		String num2="12";
		System.out.print(obj.multiply(num1, num2));
//		System.out.print(obj.reverse(4566));
		

	}

}
