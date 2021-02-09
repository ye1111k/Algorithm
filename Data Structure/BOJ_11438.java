package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_11438 {
	static int [][] par;
	static int [] dep;
	static ArrayList<Integer> [] tree;
	
	static void dfs(int u,int p,int d) {
		par[u][0]=p;
		dep[u]=d;
		
		for(int v: tree[u]) {
			if(v==p) continue;
			dfs(v,u,d+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		int N=Integer.parseInt(s);
		
		tree=new ArrayList[N+1];
		par=new int[N+1][20];
		dep=new int[N+1];
		
		for(int i=1;i<=N;i++)
			tree[i]=new ArrayList<Integer>();
		
		int a,b;
		
		for(int i=0;i<N-1;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		dfs(1,0,0);
		
		for(int k=1;k<=19;k++) {
			for(int i=1;i<=N;i++)
				par[i][k]=par[par[i][k-1]][k-1];
		}
		
		s=br.readLine();
		int M=Integer.parseInt(s);
		
		for(int i=0;i<M;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			if(dep[a]<dep[b]) {
				for(int j=19;j>=0;j--) {
					if(1<<j<=dep[b]-dep[a]) b=par[b][j];
				}
			}
			else {
				for(int j=19;j>=0;j--) {
					if(1<<j<=dep[a]-dep[b]) a=par[a][j];
				}
			}
			
			if(a==b) System.out.println(a);
			else {
				for(int j=19;j>=0;j--) {
					if(par[a][j]!=par[b][j]) {
						a=par[a][j];
						b=par[b][j];
					}
				}
				System.out.println(par[a][0]);
			}
		}
		
	}

}
