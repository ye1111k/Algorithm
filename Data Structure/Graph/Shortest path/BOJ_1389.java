package 백준문제;

import java.util.Scanner;

public class BOJ_1389 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int M=input.nextInt();
		
		int [][] path=new int[N+1][N+1];
		
		int a,b;
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++)
				if(i!=j) path[i][j]=987654321;
		}
		
		for(int i=0;i<M;i++) {
			a=input.nextInt();
			b=input.nextInt();
			
			path[a][b]=1;
			path[b][a]=1;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				for(int k=1;k<=N;k++) {
					if(path[j][k]>path[j][i]+path[i][k])
						path[j][k]=path[j][i]+path[i][k];
				}
			}
		}
		
		int min=987654321;
		int ans=1;
		int temp;
		for(int i=1;i<=N;i++) {
			temp=0;
			for(int j=1;j<=N;j++)
				temp+=path[i][j];
			if(min>temp) {
				min=temp;
				ans=i;
			}
		}
		System.out.println(ans);
	}

}
