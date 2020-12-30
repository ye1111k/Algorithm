package 백준문제;

import java.util.Scanner;

public class BOJ_10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		int ans,temp;
		
		int [][] A=new int[N+1][10];
		
		for(int i=1;i<10;i++)
			A[1][i]=1;
		
		for(int i=2;i<=N;i++) {
			A[i][0]=A[i-1][1];
			for(int j=1;j<=8;j++)
				A[i][j]=(A[i-1][j-1]+A[i-1][j+1])%1000000000;
			A[i][9]=A[i-1][8];
		}
		
		ans=A[N][0];
		
		for(int i=1;i<10;i++) {
			temp=ans+A[N][i];
			ans=temp%1000000000;
		}
		
		System.out.println(ans);
		
	}

}
