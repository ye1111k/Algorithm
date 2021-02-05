package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_5829 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int [][] port=new int[N+1][2];
		int [] dp=new int[N+1];
		int [] dir=new int[M];
		
		for(int i=1;i<=N;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			port[i][0]=Integer.parseInt(st.nextToken());
			port[i][1]=Integer.parseInt(st.nextToken());
		}
		
		s=br.readLine();
		st=new StringTokenizer(s);
		
		for(int i=0;i<M;i++) {
			if(st.nextToken().equals("L")) dir[i]=0;
			else dir[i]=1;
		}
		
		int now=1,temp,temp1=1;
		
		for(int i=0;i<K;i++) {
			if(dp[now]>0) now=dp[now];
			else {
				for(int j=0;j<M;j++) {
					temp=port[temp1][dir[j]];
					temp1=temp;
				}
				dp[now]=temp1;
				now=temp1;
			}
		}
		System.out.println(now);
	}

}
