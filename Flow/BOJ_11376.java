package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_11376 {
	static ArrayList<Integer> [] graph;
	static boolean [] visited;
	static int [] parent;
	
	static boolean B_Matching(int x) {
		for(int i:graph[x]) {
			int y=i;
			if(visited[y]) continue;
			visited[y]=true;
			if(parent[y]==0||B_Matching(parent[y])) {
				parent[y]=x;
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		graph=new ArrayList[N+1];
		
		parent=new int[M];
		
		int a,b;
		
		for(int i=1;i<=N;i++) {
			graph[i]=new ArrayList<Integer>();
			s=br.readLine();
			st=new StringTokenizer(s);
			a=Integer.parseInt(st.nextToken());
			
			for(int j=0;j<a;j++) {
				b=Integer.parseInt(st.nextToken());
				graph[i].add(b-1);
			}
		}
		
		int ans=0; 
		for(int i=1;i<=N;i++) {
			visited=new boolean[M];
			if(B_Matching(i)) ans++;
			if(ans>=M) break;
		}
		if(ans<M) {
			for(int i=1;i<=N;i++) {
				visited=new boolean[M];
				if(B_Matching(i)) ans++;
				if(ans>=M) break;
			}
		}
		System.out.println(ans);
	}

}
