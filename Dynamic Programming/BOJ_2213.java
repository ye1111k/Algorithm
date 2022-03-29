package 백준문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2213 {
public static ArrayList<Integer>[] tree;
public static ArrayList<Integer>[][] ans;
	
	public static int func(int n, int a, int [] w, int [][] dp, int root, int b) {
		int ret=dp[n][a];
		if(ret!=-1) return ret;
			
		
		if(a==1) {
			ret=w[n];
			ans[n][a].add(n);
			for(int i=0;i<tree[n].size();i++) {
				int temp=tree[n].get(i);
				if(temp==root) continue;
				dp[temp][0]=func(temp,0,w,dp,n,b);
				ret+=dp[temp][0];
				for(int j=0;j<ans[temp][0].size();j++)
					ans[n][a].add(ans[temp][0].get(j));
			}	
		}
		
		else {
			ret=0;
			for(int i=0;i<tree[n].size();i++) {
				int temp=tree[n].get(i);
				if(temp==root) continue;
				dp[temp][0]=func(temp,0,w,dp,n,b);
				dp[temp][1]=func(temp,1,w,dp,n,b);
				if(dp[temp][0]>dp[temp][1]) {
					ret+=dp[temp][0];
					for(int j=0;j<ans[temp][0].size();j++)
						ans[n][a].add(ans[temp][0].get(j));
				}
				else {
					ret+=dp[temp][1];
					for(int j=0;j<ans[temp][1].size();j++)
						ans[n][a].add(ans[temp][1].get(j));
				}
			}
		}
		
		return dp[n][a]=ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		int [] w=new int[10101];
		int [][] dp=new int[10101][2];
		
		tree=new ArrayList[10101];
		ans=new ArrayList[10101][2];
		
		for(int i=1;i<=N;i++) {
			w[i]=input.nextInt();
			tree[i]=new ArrayList<Integer>();

			ans[i][0]=new ArrayList<Integer>();
			ans[i][1]=new ArrayList<Integer>();
			
			dp[i][0]=-1;
			dp[i][1]=-1;
		}
		
		int x,y;
		
		for(int i=1;i<N;i++) {
			x=input.nextInt();
			y=input.nextInt();
			tree[x].add(y);
			tree[y].add(x);	
		}
		
		x=func(1,0,w,dp,0,1);
		y=func(1,1,w,dp,0,2);
		
		if(x>y) {
			System.out.println(x);
			Collections.sort(ans[1][0]);
			for(int i=0;i<ans[1][0].size();i++)
				System.out.printf("%d ",ans[1][0].get(i));
		}
		
		else {
			System.out.println(y);
			Collections.sort(ans[1][1]);
			for(int i=0;i<ans[1][1].size();i++)
				System.out.printf("%d ",ans[1][1].get(i));
		}
	}
}
