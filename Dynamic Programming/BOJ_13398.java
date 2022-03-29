package 백준문제;

import java.util.Scanner;

public class BOJ_13398 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int n=input.nextInt();
		
		int [] A=new int[n];
		int [][] B=new int[n][2];
		
		int maxsum;
		
		for(int i=0;i<n;i++)
			A[i]=input.nextInt();
		
		maxsum=A[0];
		B[0][0]=A[0];
		B[0][1]=0;
		
		for(int i=1;i<n;i++) {
			B[i][0]=(A[i]+B[i-1][0]>A[i])?A[i]+B[i-1][0]:A[i];
			B[i][1]=(B[i-1][0]>B[i-1][1]+A[i])?B[i-1][0]:B[i-1][1]+A[i]; 
			if(maxsum<B[i][0]) maxsum=B[i][0];
			else if(maxsum<B[i][1]) maxsum=B[i][1];
		}
		System.out.println(maxsum);
		
		
		
	}

}
