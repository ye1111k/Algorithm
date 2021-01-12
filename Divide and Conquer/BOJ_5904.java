package 백준문제;

import java.util.Scanner;

public class BOJ_5904 {
	public static int [] dp;
	public static String func(int n,int i) {
		if(i==0) {
			if(n==1) return "m";
			else return "o";
		}
		if(n<=dp[i-1])
			return func(n,i-1);
		else if(n>dp[i-1]&&n<=dp[i-1]+i+3) {
			if(n==dp[i-1]+1) return "m";
			else return "o";
		}
		else
			return func(n-(dp[i-1]+i+3),i-1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		dp=new int[100];
		
		dp[0]=3;
		int i=0;
		
		for(i=1;i<27;i++) {
			dp[i]=2*dp[i-1]+i+3;
			if(dp[i]>=N) break;
		}
		
		if(N<=3) i=0;
		
		System.out.println(func(N,i));
	}

}
