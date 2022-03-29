package 백준문제;

import java.util.Scanner;

public class BOJ_11049 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		int [][] A=new int[510][2];
		
		for(int i=0;i<N;i++) {
			A[i][0]=input.nextInt();
			A[i][1]=input.nextInt();
		}
		
		int [][] dp=new int[510][510];
		int min;
		int temp,temp1;
		
		for(int i=1;i<N;i++)
			dp[i-1][i]=A[i-1][0]*A[i-1][1]*A[i][1];
		
		if(N!=1) {
			for(int i=1;i<N-1;i++) {
				temp=dp[i-1][i]+A[i-1][0]*A[i][1]*A[i+1][1];
				temp1=dp[i][i+1]+A[i-1][0]*A[i][0]*A[i+1][1];
				dp[i-1][i+1]=(temp>temp1)?temp1:temp;
			}
		}
		
		for(int i=3;i<N;i++) {
			for(int j=0;j<N-i;j++) {
				min=(int) (Math.pow(2, 31)-1);
				for(int k=1;k<i-1;k++) {
					temp=dp[j][j+k]+dp[j+k+1][j+i]+A[j][0]*A[j+k][1]*A[j+i][1];
					if(min>temp) min=temp;
				}
				dp[j][j+i]=min;
			}
		}
		System.out.println(dp[0][N-1]);
		
	}

}
