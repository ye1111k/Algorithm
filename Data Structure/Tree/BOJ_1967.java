package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_1967 {
	static int max=0;
	static int N;
	static ArrayList<int []> [] graph;
	
	static void dfs(int r,int now,boolean [] ck) {
		int [] temp;
		for(int i=0;i<graph[r].size();i++) {
			temp=graph[r].get(i);
			if(!ck[temp[0]]) {
				if(max<temp[1]+now) max=temp[1]+now;
				ck[temp[0]]=true;
				dfs(temp[0],now+temp[1],ck);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		N=Integer.parseInt(s);
		
		graph=new ArrayList[N+1];
		
		for(int i=1;i<=N;i++)
			graph[i]=new ArrayList<int []>();
			
		int [] temp;
		
		for(int i=0;i<N-1;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			temp=new int[2];
			temp[0]=b;
			temp[1]=c;
			graph[a].add(temp);
			
			temp=new int[2];
			temp[0]=a;
			temp[1]=c;
			graph[b].add(temp);
		}
		
		boolean [] ck;
		
		for(int i=1;i<=N;i++) {
			ck=new boolean[N+1];
			ck[i]=true;
			dfs(i,0,ck);
		}
		System.out.println(max);
	}

}
