package 백준문제;

import java.util.Scanner;

public class BOJ_2248 {
	public static int [][] dp;
	public static String func(long I,int N,int L) {
		if(L==0) {
			String s="";
			for(int i=0;i<N;i++)
				s+="0";
			return s;
		}
		
		if(N==L) {
			if(I<=dp[N][L]/2) return "0"+func(I,N-1,L-1);
			else return "1"+func(I-dp[N][L]/2,N-1,L-1);
		}
		
		if(N==1) {
			if(I==0) return "0";
			else return "1";
		}
		
		if(I<=dp[N-1][L]) {
			return "0"+func(I,N-1,L);
		}
		else {
			return "1"+func(I-dp[N-1][L],N-1,L-1);
		}
	}
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int L=input.nextInt();
		long I=input.nextLong();
		
		dp=new int[32][32];
		
		dp[1][0]=1;
		dp[1][1]=2;
		dp[2][1]=3;
		dp[2][2]=4;
		for(int i=3;i<32;i++) {
			dp[i][0]=1;
			dp[i][1]=i+1;
			for(int j=2;j<i;j++)
				dp[i][j]=dp[i-1][j-1]+dp[i-1][j]; //앞자리가 1인 경우 -> dp[i-1][j-1], 앞자리가 0인 경우 -> dp[i-1][j]
			dp[i][i]=dp[i][i-1]+1;
		}
		
		if(I==1) {//시간 절약
			for(int i=0;i<N;i++)
				System.out.print("0");
		}
		else if(I==dp[N][L]&&N==L) {//시간 절약
			for(int i=0;i<N;i++) System.out.print("1");
		}
		else System.out.println(func(I,N,L));
		
	}
}
