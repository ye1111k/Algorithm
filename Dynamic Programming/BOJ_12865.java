package 백준문제;

import java.util.Scanner;

public class BOJ_12865 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int K=input.nextInt();
		
		int [] W=new int[110];
		int [] V=new int[110];
		
		for(int i=1;i<=N;i++) {
			W[i]=input.nextInt();
			V[i]=input.nextInt();
		}
		
		int [][] dp=new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(W[i]<=j) {
					if(dp[i-1][j]<V[i]+dp[i-1][j-W[i]]) dp[i][j]=V[i]+dp[i-1][j-W[i]];
					else dp[i][j]=dp[i-1][j];
				}
				else dp[i][j]=dp[i-1][j];
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
