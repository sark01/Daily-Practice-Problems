import java.io.*;
import java.util.*;

public class DPP58
{
	public static void main(String[] ar)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int num = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(s[i]);
		int ans = binarySearch(a,0,n-1,num);
		if(ans != -1)
			out.println(ans);
		else
			out.println("not present");
		out.flush();
	}
	public static int binarySearch(int[] a, int l, int r, int num)
	{
		if(l>r) return -1;
		int mid=l+((r-l)/2);
		if(a[mid]==num)return mid;

		if(a[l]<=a[mid])
		{
			if(num>=a[l] && num<=a[mid])
				return binarySearch(a,l,mid-1,num);
			return binarySearch(a,mid+1,r,num);
		} 
		if(num>=a[mid] && num<=a[r])
			return binarySearch(a,mid+1,r,num);
		return binarySearch(a,l,mid-1,num);
	}
}

