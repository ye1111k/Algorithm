package 백준문제;

import java.util.Scanner;

public class BOJ_2749 {
	public static long [][] func(long N){
		long [][] a=new long[2][2];
		long [][] b=new long[2][2];
		long [][] c=new long[2][2];
		
		if(N==1) {//N==1일 경우
			a[0][0]=1;
			a[0][1]=1;
			a[1][0]=1;
			a[1][1]=0;
		}
		else if(N%2==1) {//N이 홀수일 경우
			b=func(N-1);
			c=func(1);
			a[0][0]= (b[0][0]*c[0][0]+b[0][1]*c[1][0])%1000000;
			a[0][1]=(b[0][0]*c[0][1]+b[0][1]*c[1][1])%1000000;
			a[1][0]=(b[1][0]*c[0][0]+b[1][1]*c[1][0])%1000000;
			a[1][1]=(b[1][0]*c[0][1]+b[1][1]*c[1][1])%1000000;
		}
		else {//N이 짝수일 경우
			b=func(N/2);
			a[0][0]=(b[0][0]*b[0][0]+b[0][1]*b[1][0])%1000000;
			a[0][1]=(b[0][0]*b[0][1]+b[0][1]*b[1][1])%1000000;
			a[1][0]=(b[1][0]*b[0][0]+b[1][1]*b[1][0])%1000000;
			a[1][1]=(b[1][0]*b[0][1]+b[1][1]*b[1][1])%1000000;
		}
		
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		long N;
		
		long [][] a=new long[2][2]; //함수 결과 받을 배열
		
		N=input.nextLong();
		if(N!=0) {
			a=func(N);
			System.out.println(a[0][1]);
		}
		else System.out.println(0); //N=0일 경우 그냥 0 출력
	}

}
