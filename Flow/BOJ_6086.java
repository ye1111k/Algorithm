package 백준문제;

import java.util.*;
import java.io.*;

class Edge{
	int end;
	int capacity;
	int flow;
	
	Edge reverse;
	
	Edge(){}

	int residualCapacity() {
		return this.capacity-this.flow;
	}
	
	void push(int amt) {
		this.flow+=amt;
		this.reverse.flow-=amt;
	}
}

public class BOJ_6086 {
	static LinkedList<Edge> [] graph;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringTokenizer st;
		
		s=br.readLine();
		int N=Integer.parseInt(s);
		
		graph=new LinkedList[52];
		
		for(int i=0;i<52;i++)
			graph[i]=new LinkedList<Edge>();
			
		char a,b;
		int c;
		Edge e,e1;
		
		for(int i=0;i<N;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			a=st.nextToken().charAt(0);
			b=st.nextToken().charAt(0);
			c=Integer.parseInt(st.nextToken());
			
			if(b>='a'&&b<='z') {
				e=new Edge();
				e1=new Edge();
				
				e.end=b-'A'-6;
				e.capacity=c;
				e.flow=0;
				
				e1.capacity=c;
				e1.flow=0;
				
				if(a>='a'&&a<='z') {
					e1.end=a-'A'-6;
					
					graph[a-'A'-6].addLast(e);
					graph[b-'A'-6].addLast(e1);
					
					graph[a-'A'-6].getLast().reverse=graph[b-'A'-6].getLast();
		            graph[b-'A'-6].getLast().reverse=graph[a-'A'-6].getLast();
				}
				else {
					e1.end=a-'A';
					
					graph[a-'A'].addLast(e);
					graph[b-'A'-6].addLast(e1);
					
					graph[a-'A'].getLast().reverse=graph[b-'A'-6].getLast();
		            graph[b-'A'-6].getLast().reverse=graph[a-'A'].getLast();
				}
			}
			else {
				e=new Edge();
				e1=new Edge();
				
				e.end=b-'A';
				e.capacity=c;
				e.flow=0;
				
				e1.capacity=c;
				e1.flow=0;
				
				if(a>='a'&&a<='z') {
					e1.end=a-'A'-6;
					
					graph[a-'A'-6].addLast(e);
					graph[b-'A'].addLast(e1);
					
					graph[a-'A'-6].getLast().reverse=graph[b-'A'].getLast();
		            graph[b-'A'].getLast().reverse=graph[a-'A'-6].getLast();
				}
				else {
					e1.end=a-'A';
					
					graph[a-'A'].add(e);
					graph[b-'A'].add(e1);
					
					graph[a-'A'].getLast().reverse=graph[b-'A'].getLast();
		            graph[b-'A'].getLast().reverse=graph[a-'A'].getLast();
				}
			}
		}
		
		int totalFlow=0, amount, temp;
		
		int [] parent;
		Edge [] back_edge;
		
		LinkedList<Integer> queue;
		
		while(true) {
			queue=new LinkedList<Integer>();
			parent=new int[52];
			back_edge=new Edge[52];
			for(int i=0;i<52;i++)
				parent[i]=-1;
			parent[0]=0;
			queue.add(0);
			while(!queue.isEmpty()&&parent[25]==-1) {
				int here=queue.removeFirst();
				for(Edge e2: graph[here]) {
					if(e2.capacity-e2.flow>0&&parent[e2.end]==-1) {
						queue.addLast(e2.end);
						parent[e2.end]=here;
						back_edge[e2.end]=e2;
					}
				}
			}
			
			if(parent[25]==-1) break;
			
			amount=987654321;
			for(int p=25;p!=0;p=parent[p]) {
				temp=back_edge[p].residualCapacity();
				if(amount>temp) amount=temp;
			}
			for(int p=25;p!=0;p=parent[p]) {
				back_edge[p].push(amount);
			}
			totalFlow+=amount;
		}
		System.out.println(totalFlow);
	}

}
