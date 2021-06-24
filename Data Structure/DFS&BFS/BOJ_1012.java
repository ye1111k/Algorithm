package 백준문제;

import java.util.*;

public class BOJ_1012 {
	public static int count(boolean [][] A,int M,int N) {
		int cnt=0;
		for(int i=0;i<N;i++) { //좌측 상단부터 훑기
			for(int j=0;j<M;j++) {
				if(A[i][j]) {
					dfs(A,i,j,M,N);
					cnt++;  //배추가 심어져있는 구역 수 count
				}
			}
		}
		return cnt; //결과 리턴
	}
	public static void dfs(boolean [][] A,int i,int j,int M,int N) {
		if(i<N-1) {
			if(A[i+1][j]) { //아래로
				A[i+1][j]=false;
				dfs(A,i+1,j,M,N);
			}
		}
	
		if(j<M-1) { 
			if(A[i][j+1]) { //오른쪽으로
				A[i][j+1]=false;
				dfs(A,i,j+1,M,N);
			}
		}
		
		if(j>0) {
			if(A[i][j-1]) { //왼쪽으로
				A[i][j-1]=false;
				dfs(A,i,j-1,M,N);
			}
		}
		if(i>0) {
			if(A[i-1][j]) { //위로
				A[i-1][j]=false;
				dfs(A,i-1,j,M,N);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int T=input.nextInt();
		
		boolean [][] A;
		
		int M,N,a,tmp1,tmp2;
		
		for(int t=0;t<T;t++) {
			M=input.nextInt();
			N=input.nextInt();
			a=input.nextInt();
			
			A=new boolean[N][M]; //배추밭 만들기
			
			for(int i=0;i<a;i++) {
				tmp1=input.nextInt();
				tmp2=input.nextInt();
				
				A[tmp2][tmp1]=true; //배추가 심어져있는 곳 true로 설정
			}
			
			System.out.println(count(A,M,N));
		}
	}

}
