package 백준문제;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1949 {
	public static ArrayList<Integer>[] tree;
	
	public static int max(int a,int b) {
		if(a>b) return a;
		return b;
	}
	
	public static int func(int n,int a,int [] per, int [][] dp,int root) {
		int ret=dp[n][a];
		if(ret!=-1) return ret;
		
		if(tree[n].isEmpty()) {
			if(a==0) return dp[n][0]=0;
			else return dp[n][1]=per[n];
		}
		
		if(a==1) {
			ret=per[n];
			for(int i=0;i<tree[n].size();i++) {
				int temp=tree[n].get(i);
				if(temp==root) continue; //루트노드 무시해주기
				dp[temp][0]=func(temp,0,per,dp,n);
				ret+=dp[temp][0];
			}	
		}
		else {
			ret=0;
			for(int i=0;i<tree[n].size();i++) {
				int temp=tree[n].get(i);
				if(temp==root) continue; //루트노드 무시해주기
				dp[temp][0]=func(temp,0,per,dp,n);
				dp[temp][1]=func(temp,1,per,dp,n);
				ret+=max(dp[temp][0],dp[temp][1]);
			}
		}
		
		return dp[n][a]=ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int [] per=new int[10101];
		
		tree=new ArrayList[10101];
		
		int [][] dp=new int[10101][2];
		
		for(int i=1;i<=N;i++) {
			per[i]=input.nextInt();
			tree[i]=new ArrayList<Integer>();
			dp[i][0]=-1;
			dp[i][1]=-1;
		}
		
		int x,y;
		
		for(int i=0;i<N-1;i++) {
			x=input.nextInt();
			y=input.nextInt();
			tree[x].add(y);
			tree[y].add(x);
		}
		
		x=func(1,0,per,dp,0);
		y=func(1,1,per,dp,0);
		
		System.out.println(max(x,y));
		
	}

}
