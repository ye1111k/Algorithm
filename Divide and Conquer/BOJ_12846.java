package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12846 {
	static long [] arr;
	static long func(int b,int e) {
		int mid=(b+e)/2;
		int temp=mid-2,temp1=mid+1;
		long nowMin;
		int i=3;
		
		if(e-b==1) return arr[b];
		
		long x=func(b,mid);
		long y=func(mid,e);
		long z;
		if(arr[mid-1]>arr[mid]) {
			z=arr[mid]*2;
			nowMin=arr[mid];
		}
		else {
			z=arr[mid-1]*2;
			nowMin=arr[mid-1];
		}
		
		while(temp>=b||temp1<e) {
			if(temp<b) {
				if(arr[temp1]<nowMin) nowMin=arr[temp1];
				temp1++;
			}
			else if(temp1>=e) {
				if(arr[temp]<nowMin) nowMin=arr[temp];
				temp--;
			}
			else if(arr[temp]>=arr[temp1]) {
				if(arr[temp]<nowMin) nowMin=arr[temp];
				temp--;
			}
			else {
				if(arr[temp1]<nowMin) nowMin=arr[temp1];
				temp1++;
			}
			if(nowMin*i>z) z=nowMin*i;
			i++;
		}
		
		if(x>=y&&x>=z) return x;
		else if(y>=x&&y>=z) return y;
		return z;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s=br.readLine();
		
		int n=Integer.parseInt(s);
		arr=new long[n];
		
		s=br.readLine();
		st=new StringTokenizer(s);
		
		for(int i=0;i<n;i++)
			arr[i]=Long.parseLong(st.nextToken());
		System.out.println(func(0,n));
		
			
		
	}

}
