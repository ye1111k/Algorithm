package 백준문제;

import java.util.*;
import java.io.*;
public class BOJ_17412 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		
		LinkedList<edge> [] graph=new LinkedList[N+1];
		for(int i=1;i<=N;i++) graph[i]=new LinkedList<edge>();
		
		int a,b;
		edge e,e1;
		
		for(int i=0;i<P;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			e=new edge();
			e1=new edge();
			
			e.capacity=1;
			e.flow=0;
			e.end=b;
			
			e1.capacity=0;
			e1.end=a;
			e1.flow=0;
			
			graph[a].addLast(e);
			graph[b].addLast(e1);
			
			graph[a].getLast().reverse=graph[b].getLast();
			graph[b].getLast().reverse=graph[a].getLast();
		}
		
		int totalFlow=0;
		
		int source=1,sink=2;
		int [] parent;
		
		edge [] back_edge;
		LinkedList<Integer> queue;
		
		while(true) {
			queue=new LinkedList<Integer>();
			parent=new int[N+1];
			back_edge=new edge[N+1];
			for(int i=1;i<=N;i++)
				parent[i]=-1;
			parent[source]=source;
			queue.addLast(source);
			while(parent[sink]==-1&&!queue.isEmpty()) {
				int here=queue.removeFirst();
				for(edge e2:graph[here]) {
					if(parent[e2.end]==-1&&e2.capacity-e2.flow>0) {
						queue.addLast(e2.end);
						back_edge[e2.end]=e2;
						parent[e2.end]=here;
					}
				}
			}
			if(parent[sink]==-1) break;
			for(int p=sink;p!=source;p=parent[p])
				back_edge[p].push(1);
			totalFlow++;
		}
		System.out.println(totalFlow);
	}

}
