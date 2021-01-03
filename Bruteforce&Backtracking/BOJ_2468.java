package 백준문제;

import java.util.Scanner;

public class BOJ_2468 {
	static int N;
	static int [][] A=new int[101][101];

	static int max=0;
	
	static void dfs(int x,int y,int a,boolean [][] B) {
		if(x<0||y<0||x>=N||y>=N) return;//범위 벗어날 경우
		if(A[y][x]<=a||B[y][x]) return;//이미 참고한 칸이거나 물에 잠기는 경우
		
		B[y][x]=true;//이미 참고한 영역으로 상태 바꾸기
		
		dfs(x,y+1,a,B);//아래칸
		dfs(x,y-1,a,B);//위칸
		dfs(x-1,y,a,B);//왼쪽칸
		dfs(x+1,y,a,B);//오른쪽칸
		
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		N=input.nextInt();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				A[i][j]=input.nextInt();
		}
		
		int max=0;
		
		for(int i=0;i<=100;i++) {//물에 잠기지 않는 경우부터 비가 100만큼 오는 경우까지 체크
			int temp=0;//강수량별로 초기화
			boolean [][] B=new boolean[101][101];//강수량별로 초기화22
			for(int j=0;j<N;j++) {//모든 칸 체크
				for(int k=0;k<N;k++) {
					if(!B[k][j]&&A[k][j]>i) {//아직 참고하지 않은 칸이거나 비에 잠기지 않을 경우에만 체크
						dfs(j,k,i,B);//닿아있는 모든 부분 상태 바꾸기(코드 돌고 나오면 여기서 상태 바뀐 부분이 하나의 안전 영역)
						temp++;//안전영역 개수 추가
					}
				}
					
			}
			if(max<temp) max=temp;//최댓값 체크
		}
		
		System.out.println(max);
	}

}
