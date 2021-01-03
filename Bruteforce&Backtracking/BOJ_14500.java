package 백준문제;

import java.util.Scanner;

public class BOJ_14500 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][][] type={
				{{0,0},{0,1},{0,2},{0,3}},
				{{0,0},{1,0},{2,0},{3,0}},
				{{0,0},{1,0},{2,0},{2,1}},
				{{0,0},{1,0},{1,1},{1,2}},
				{{0,0},{0,1},{0,2},{1,0}},
				{{0,0},{0,1},{1,0},{2,0}},
				{{0,0},{0,1},{0,2},{1,2}},
				{{0,0},{0,1},{1,1},{2,1}},
				{{0,0},{1,-2},{1,-1},{1,0}},
				{{0,0},{1,0},{2,0},{2,-1}},
				{{0,0},{0,1},{1,0},{1,1}},
				{{0,0},{1,-1},{1,0},{1,1}},
				{{0,0},{1,0},{2,0},{1,1}},
				{{0,0},{1,-1},{1,0},{2,0}},
				{{0,0},{0,1},{0,2},{1,1}},
				{{0,0},{-1,1},{0,1},{1,0}},
				{{0,0},{1,0},{1,1},{2,1}},
				{{0,0},{0,1},{1,1},{1,2}},
				{{0,0},{0,1},{1,0},{1,-1}}
		};
		
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int M=input.nextInt();
		
		int [][] A=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				A[i][j]=input.nextInt();
		}
		
		int max=0,x,y,temp,a,b;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int k=0;k<19;k++) {
					x=j;
					y=i;
					temp=0;
					for(int h=0;h<4;h++) {
						a=x+type[k][h][1];
						b=y+type[k][h][0];
						if(a>=0&&b>=0&&a<M&&b<N) temp+=A[b][a];
					}
					if(max<temp) max=temp;	
				}
			}
		}
		System.out.println(max);
	}
}
