package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1761 {
	static int [][] par;
	static int [] dep;
	static int [][] edge;
	static ArrayList<int []> [] tree;
	
	static void dfs(int u,int p,int d,int e) {
		par[u][0]=p;
		edge[u][0]=e;
		dep[u]=d;
		
		for(int [] v: tree[u]) {
			if(v[0]==p) continue;
			dfs(v[0],u,d+1,v[1]);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		int N=Integer.parseInt(s);
		
		tree=new ArrayList[N+1];
		par=new int[N+1][17];
		edge=new int[N+1][17];
		dep=new int[N+1];
		
		for(int i=1;i<=N;i++)
			tree[i]=new ArrayList<int []>();
		
		int [] temp;
		
		int a,b,c;
		
		for(int i=0;i<N-1;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			
			temp=new int[2];
			temp[0]=a;
			temp[1]=c;
			tree[b].add(temp);
			
			temp=new int[2];
			temp[0]=b;
			temp[1]=c;
			tree[a].add(temp);
		}
		
		dfs(1,0,0,0);
		
		for(int k=1;k<=16;k++) {
			for(int i=1;i<=N;i++) {
				par[i][k]=par[par[i][k-1]][k-1];
				edge[i][k]=edge[i][k-1]+edge[par[i][k-1]][k-1];
			}
		}
		
		s=br.readLine();
		int M=Integer.parseInt(s);
		
		for(int i=0;i<M;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=0;
			
			if(dep[a]<dep[b]) {
				for(int j=16;j>=0;j--) {
					if(1<<j<=dep[b]-dep[a]) {
						c+=edge[b][j];
						b=par[b][j];
					}
				}
			}
			else {
				for(int j=16;j>=0;j--) {
					if(1<<j<=dep[a]-dep[b]) {
						c+=edge[a][j];
						a=par[a][j];
					}
				}
			}
			if(a!=b) {
				for(int j=16;j>=0;j--) {
					if(par[a][j]!=par[b][j]) {
						c+=edge[a][j];
						c+=edge[b][j];
						a=par[a][j];
						b=par[b][j];
					}
				}
				c+=edge[a][0];
				c+=edge[b][0];
			}
			System.out.println(c);
		}
	}

}
