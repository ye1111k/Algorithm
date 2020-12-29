package 백준문제;

import java.util.Scanner;

public class BOJ_2193 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		long [][] A=new long[91][2];
		
		A[1][0]=0;
		A[1][1]=1;
		
		for(int i=2;i<=90;i++) {
			A[i][0]=A[i-1][0]+A[i-1][1];
			A[i][1]=A[i-1][0];
		}
		
		System.out.println(A[N][0]+A[N][1]);
	}

}
