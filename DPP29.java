/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
*/



import java.io.*;
import java.util.*;

class DPP29
{
	public static void main(String[] ar)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		System.out.println(decoding(encoding(s)));
	}
	public static String encoding(String str)
	{
		int len = str.length(),i=0,j=0,c=0;
		String e="";
		while(i<len && j<len)
		{
			if(str.charAt(i)==str.charAt(j))
			{
				c++;
				j++;
			}
			else
			{
				e+=Integer.toString(c)+Character.toString(str.charAt(i));
				c=0;
				i=j;
			}
		}
		if(c!=0)
			e+=Integer.toString(c)+Character.toString(str.charAt(i));
		return e;
	}
	public static String decoding(String str)
	{
		int len = str.length();
		String d = "";
		for (int i=0;i<len;i+=2)
		{
			int j=i+1;
			for(int k=0;k<Character.getNumericValue(str.charAt(i));k++)
				d+=Character.toString(str.charAt(j));
		}
		return d;
	}
}

