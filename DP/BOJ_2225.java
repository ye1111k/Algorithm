package 백준문제;

import java.util.Scanner;

public class BOJ_2225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int K=input.nextInt();
		
		int [][] dp=new int[210][210];
		
		for(int i=0;i<N;i++) dp[i][0]=1;
		for(int i=0;i<K;i++) dp[0][i]=i+1;
		for(int i=1;i<N;i++) {
			for(int j=1;j<K;j++)
				dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000000;
		}
		System.out.println(dp[N-1][K-1]);
	}

}
