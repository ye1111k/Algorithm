package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_18352 {
	public static ArrayList<Integer> [] graph;
	public static int [] path;
	public static LinkedList<Integer> queue;
	
	public static void bfs(int X) {
		queue.addLast(X);
		int a,b;
		while(!queue.isEmpty()) {
			a=queue.removeFirst();
			for(int i=0;i<graph[a].size();i++) {
				b=graph[a].get(i);
				if(path[b]==0) {
					path[b]+=path[a]+1;
					queue.add(b);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		
		graph=new ArrayList[N+1];
		path=new int[N+1];
		queue=new LinkedList<Integer>();
		
		for(int i=1;i<=N;i++)
			graph[i]=new ArrayList<Integer>();
		
		int a,b;
		
		for(int i=0;i<M;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		
		bfs(X);
		
		int cnt=0;
		
		for(int i=1;i<=N;i++) {
			if(path[i]==K&&i!=X) { 
				System.out.println(i);
				cnt++;
			}
		}
		if(cnt==0) System.out.println(-1);
	}

}
