package 백준문제;

import java.util.Scanner;

public class BOJ_7677 {
	public static short [][][] dp;
	public static short [][] func(int N){
		short [][] a=new short[2][2];
		short [][] b=new short[2][2];
		short [][] c=new short[2][2];
		
		if(N==1) {//N==1일 경우
			a[0][0]=1;
			a[0][1]=1;
			a[1][0]=1;
			a[1][1]=0;
		}
		else if(N%2==1) {//N이 홀수일 경우
			b=func(N-1);
			c=func(1);
			a[0][0]=(short) ((b[0][0]*c[0][0]+b[0][1]*c[1][0])%10000);
			a[0][1]=(short) ((b[0][0]*c[0][1]+b[0][1]*c[1][1])%10000);
			a[1][0]=(short) ((b[1][0]*c[0][0]+b[1][1]*c[1][0])%10000);
			a[1][1]=(short) ((b[1][0]*c[0][1]+b[1][1]*c[1][1])%10000);
		}
		else {//N이 짝수일 경우
			b=func(N/2);
			a[0][0]=(short) ((b[0][0]*b[0][0]+b[0][1]*b[1][0])%10000);
			a[0][1]=(short) ((b[0][0]*b[0][1]+b[0][1]*b[1][1])%10000);
			a[1][0]=(short) ((b[1][0]*b[0][0]+b[1][1]*b[1][0])%10000);
			a[1][1]=(short) ((b[1][0]*b[0][1]+b[1][1]*b[1][1])%10000);
		}
		
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int N;
		
		short [][] a=new short[2][2]; //함수 결과 받을 배열
		
		while(true) {
			N=input.nextInt();
			if(N==-1) break;
			if(N!=0) {
				a=func(N);
				System.out.println(a[0][1]);
			}
			else System.out.println(0); //N=0일 경우 그냥 0 출력
		}
	}

}
