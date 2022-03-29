package 백준문제;

import java.util.Scanner;

public class BOJ_1562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		long [][][] D=new long[1<<12][N+1][10];
		
		for(int i=1;i<10;i++)
			D[1<<i][1][i]=1;
		
		for(int n=2;n<=N;n++) {
			for(int vst=0;vst<(1<<11);vst++) {
				if((vst&1)==1) D[vst][n][0]=(D[vst-1][n-1][1]+D[vst][n-1][1])%1000000000;
				for(int i=1;i<=8;i++) {
					if(((vst>>i)&1)==1) {
						D[vst][n][i]=(D[vst-(1<<i)][n-1][i-1]+D[vst-(1<<i)][n-1][i+1])%1000000000;
						D[vst][n][i]+=((D[vst][n-1][i-1]+D[vst][n-1][i+1])%1000000000);
					}
				}
				if(((vst>>9)&1)==1) D[vst][n][9]=(D[vst-(1<<9)][n-1][8]+D[vst][n-1][8])%1000000000;
			}
		}
		
		long sum=0;
		
		for(int i=0;i<10;i++)
			sum=(sum+D[(1<<10)-1][N][i])%1000000000;
		
		System.out.println(sum);
	}
}