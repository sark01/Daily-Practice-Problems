/*Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.
*/


import java.io.*;
import java.util.*;

class DPP27
{
	public static void main(String[] ar)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		System.out.println(isBalanced(s));
	}
	public static boolean isBalanced(String str)
	{
		int len = str.length();
		Stack<Character> s = new Stack<>();
		for(int i=0;i<len;i++)
		{
			if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='[')
				s.push(str.charAt(i));
			else
			{
				if(!s.empty()&&((str.charAt(i)==')'&&s.peek()=='(')||(s.peek()=='{'&&str.charAt(i)=='}')||(s.peek()=='['&&str.charAt(i)==']')))
					s.pop();
				else
					return false;
			}
		}
		if(s.empty())
			return true;
		return false;
	}
}
