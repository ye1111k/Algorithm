package 백준문제;

import java.util.Scanner;

public class BOJ_18428 {
	public static String [][] arr;
	public static int ans=0;
	public static int [][] T;
	public static int t;
	
	public static void ck(int N) {
		int x,y,cnt=0;
		for(int i=0;i<t;i++) {
			x=T[i][0];
			y=T[i][1];
			for(int j=x-1;j>=0;j--) {//상
				if(arr[j][y].equals("S")) cnt++;
				if(arr[j][y].equals("O")||arr[j][y].equals("T")) break;
			}
			for(int j=x+1;j<N;j++) {//하
				if(arr[j][y].equals("S")) cnt++;
				if(arr[j][y].equals("O")||arr[j][y].equals("T")) break;
			}
			for(int j=y-1;j>=0;j--) {//좌
				if(arr[x][j].equals("S")) cnt++;
				if(arr[x][j].equals("O")||arr[x][j].equals("T")) break;
			}
			for(int j=y+1;j<N;j++) {//우
				if(arr[x][j].equals("S")) cnt++;
				if(arr[x][j].equals("O")||arr[x][j].equals("T")) break;
			}
		}
		
		if(cnt==0) ans++;
	}
	
	public static void dfs(int n,int r,int c,int N) {
		if(r>=N||c>=N) return;
		
		if(n==3) {
			ck(N);
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j].equals("X")) {
					arr[i][j]="O";
					dfs(n+1,i,j,N);
					arr[i][j]="X";
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		arr=new String[10][10];
		T=new int[10][2];
		t=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=input.next();
				if(arr[i][j].equals("T")) {
					T[t][0]=i;
					T[t][1]=j;
					t++;
				}
			}
		}
		
		dfs(0,0,0,N);
		
		if(ans==0) System.out.println("NO");
		else System.out.println("YES");
	}

}
