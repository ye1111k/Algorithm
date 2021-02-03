package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_1484 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		long N=Long.parseLong(s);
		
		long [] arr=new long[50010];
		
		for(int i=1;i<=50009;i++)
			arr[i]=(long)i*(long)i;
		
		int start=1,end=1;
		
		int cnt=0;
		long temp;
		int [] ans=new int[50010];
		
		while(end<=50009&&start<=50009) {
			temp=arr[end]-arr[start];
			if(temp==N) {
				ans[cnt]=end;
				cnt++;
				end++;
				start++;
			}
			else if(temp<N) end++;
			else start++;
		}
		
		if(cnt==0) System.out.println(-1);
		else {
			Arrays.sort(ans,0,cnt);
			for(int i=0;i<cnt;i++)
				System.out.println(ans[i]);
		}
	}

}
