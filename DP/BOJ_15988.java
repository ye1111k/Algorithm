package 백준문제;

import java.util.Scanner;

public class BOJ_15988 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		long b=1000000009;
		
		int T=input.nextInt();
		
		int [] a=new int[T];
		
		for(int i=0;i<T;i++)
			a[i]=input.nextInt();
		
		long [] dp=new long[1010101];
		
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		for(int i=4;i<=1000000;i++) {
			dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%b;
		}
		
		for(int i=0;i<T;i++)
			System.out.println(dp[a[i]]);
		
	}

}
