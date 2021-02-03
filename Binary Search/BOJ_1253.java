package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_1253 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		int N=Integer.parseInt(s);
		
		long [] a=new long[N];
		
		s=br.readLine();
		st=new StringTokenizer(s);
		
		for(int i=0;i<N;i++)
			a[i]=Long.parseLong(st.nextToken());		
		
		Arrays.sort(a);
		
		long temp;
		int start,end,cnt=0;
		
		for(int i=0;i<N;i++) {
			start=0;
			end=N-1;
			while(start<end) {
				temp=a[start]+a[end];
				if(start==i) start++;
				else if(end==i) end--;
				else if(a[i]==temp) {
					cnt++;
					break;
				}
				else if(a[i]<temp) end--;
				else start++;
			}
		}
		
		System.out.println(cnt);
	}

}
