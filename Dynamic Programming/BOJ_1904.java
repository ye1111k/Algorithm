package 백준문제;

import java.util.Scanner;

public class BOJ_1904 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		int [] dp=new int[1010101];
		
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3;i<=N;i++)
			dp[i]=(dp[i-1]+dp[i-2])%15746;
		
		System.out.println(dp[N]);
	}

}
