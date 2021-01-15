package 백준문제;

import java.util.Scanner;

public class BOJ_1074 {
	public static int func(int r,int c,int N) {
		if(N==0) {
			if(r==0&&c==0) return 0;
			else if (r==0&&c==1) return 1;
			else if (r==1&&c==0) return 2;
			else return 3;
		}
		else {
			if(r<N&&c<N) return func(r,c,N/2);
			else if(r<N&&c>=N) return N*N+func(r,c-N,N/2);
			else if(r>=N&&c<N) return 2*N*N+func(r-N,c,N/2);
			else return 3*N*N+func(r-N,c-N,N/2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int r=input.nextInt();
		int c=input.nextInt();
		
		int a=(int)Math.pow(2, N);
		
		System.out.println(func(r,c,a));
	}

}
