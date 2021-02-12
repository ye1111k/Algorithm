package 백준문제;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2188 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		LinkedList<edge> [] graph=new LinkedList[N+M+2];
		for(int i=0;i<N+M+2;i++)
			graph[i]=new LinkedList<edge>();
		
		int a,b;
		edge e,e1;
		
		for(int i=1;i<=N;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			a=Integer.parseInt(st.nextToken());
			for(int j=0;j<a;j++) {
				b=Integer.parseInt(st.nextToken());
				
				e=new edge();
				e1=new edge();
				
				e.capacity=1;
				e.end=b+N;
				e.flow=0;
				
				e1.capacity=0;
				e1.end=i;
				e1.flow=0;
				
				graph[i].addLast(e);
				graph[b+N].addLast(e1);
				graph[i].getLast().reverse=graph[b+N].getLast();
				graph[b+N].getLast().reverse=graph[i].getLast();
			}
		}
		
		for(int i=1;i<=N;i++) {
			e=new edge();
			e1=new edge();
			
			e.end=i;
			e.capacity=1;
			e.flow=0;
			
			e1.end=0;
			e1.capacity=0;
			e1.flow=0;
			
			graph[0].addLast(e);
			graph[i].addLast(e1);
			
			graph[0].getLast().reverse=graph[i].getLast();
			graph[i].getLast().reverse=graph[0].getLast();
		}
		
		for(int i=N+1;i<=N+M;i++) {
			e=new edge();
			e1=new edge();
			
			e.end=N+M+1;
			e.capacity=1;
			e.flow=0;
			
			e1.end=i;
			e1.capacity=0;
			e1.flow=0;
			
			graph[i].addLast(e);
			graph[N+M+1].addLast(e1);
			
			graph[i].getLast().reverse=graph[N+M+1].getLast();
			graph[N+M+1].getLast().reverse=graph[i].getLast();
		}
		
		int [] parent;
		edge [] back_edge;
		int totalFlow=0,source=0,sink=N+M+1;
		LinkedList<Integer> queue;
		
		while(true) {
			queue=new LinkedList<Integer>();
			parent=new int[N+M+2];
			back_edge=new edge[N+M+2];
			for(int i=0;i<N+M+2;i++)
				parent[i]=-1;
			parent[source]=source;
			queue.addLast(source);
			while(!queue.isEmpty()&&parent[sink]==-1) {
				int here=queue.removeFirst();
				for(edge e2:graph[here]) {
					if(e2.capacity-e2.flow>0&&parent[e2.end]==-1) {
						queue.addLast(e2.end);
						back_edge[e2.end]=e2;
						parent[e2.end]=here;
					}
				}
			}
			if(parent[sink]==-1) break;
			int amount=987654321,temp;
			for(int p=sink;p!=source;p=parent[p]) {
				temp=back_edge[p].residualCapacity();
				if(amount>temp) amount=temp;
			}
			for(int p=sink;p!=source;p=parent[p]) {
				back_edge[p].push(amount);
				graph[parent[p]].remove(back_edge[p].reverse);
				graph[p].remove(back_edge[p]);
			}
			totalFlow+=amount;
		}
		System.out.println(totalFlow);
	}

}
