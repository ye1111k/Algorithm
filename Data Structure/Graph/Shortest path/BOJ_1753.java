package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
	static PriorityQueue<int []> pq;
	static ArrayList<int []> [] graph;
	static int [] answer;
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		
		s=br.readLine();
		int X=Integer.parseInt(s);
		
		graph=new ArrayList[V+1];
		answer=new int[V+1];
		visited=new boolean[V+1];
		pq=new PriorityQueue<int []>(new Comparator<int []>() {
			public int compare(int [] o1, int [] o2) {
				return o1[1]-o2[1];
			}
		});
		
		for(int i=1;i<=V;i++) {
			graph[i]=new ArrayList<int []>();
			answer[i]=987654321;
		}
		
		int a;
		int [] temp;
		int [] temp1;
		
		for(int i=0;i<E;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			a=Integer.parseInt(st.nextToken());
			temp=new int[2];
			temp[0]=Integer.parseInt(st.nextToken());	
			temp[1]=Integer.parseInt(st.nextToken());
			
			graph[a].add(temp);
		}
		
		temp=new int[2];
		temp[0]=X;
		temp[1]=0;
		answer[X]=0;
		pq.add(temp);
		
		while(!pq.isEmpty()) {
			temp=pq.remove();
			if(visited[temp[0]]) continue;
			visited[temp[0]]=true;
			for(int [] b:graph[temp[0]]) {
				if(visited[b[0]]) continue;
				if(answer[b[0]]>temp[1]+b[1]) answer[b[0]]=temp[1]+b[1];
				temp1=new int[2];
				temp1[0]=b[0];
				temp1[1]=answer[b[0]];
				pq.add(temp1);
			}
		}
		
		for(int i=1;i<=V;i++) {
			if(answer[i]==987654321) bw.write("INF\n");
			else bw.write(answer[i]+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
