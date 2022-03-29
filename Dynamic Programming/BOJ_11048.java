package 백준문제;

import java.util.Scanner;

public class BOJ_11048 {
	public static int func(int a,int b,int c) {
		if(a>=b&&a>=c) return a;
		else if(b>=a&&b>=c) return b;
		else return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int M=input.nextInt();
		
		int [][] A=new int[N+1][M+1];
		int temp;
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				temp=input.nextInt();
				A[i][j]=temp+func(A[i-1][j],A[i][j-1],A[i-1][j-1]);
			}
		}
		
		
		System.out.println(A[N][M]);
	}

}
