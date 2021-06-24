package 백준문제;

import java.util.*;

public class BOJ_14496 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int a=input.nextInt();
		int b=input.nextInt();
		
		int N=input.nextInt();
		int M=input.nextInt();
		
		ArrayList<int []> [] graph=new ArrayList[N+1];
		int [] answer=new int[N+1];
		boolean [] visited=new boolean[N+1];
		for(int i=1;i<=N;i++) {
			graph[i]=new ArrayList<int []>();
			answer[i]=987654321;
		}
		PriorityQueue<int []> pq=new PriorityQueue<int []>(new Comparator<int []>() {
			public int compare(int [] o1, int [] o2) {
				return o1[1]-o2[1];
			}
		});
			
		int [] temp;
		int [] temp1;
		int x,y;
		
		for(int i=0;i<M;i++) {
			temp=new int[2];
			temp1=new int[2];
			
			x=input.nextInt();
			y=input.nextInt();
			
			temp[0]=x;
			temp[1]=1;
			
			temp1[0]=y;
			temp1[1]=1;
			
			graph[x].add(temp1);
			graph[y].add(temp);
		}
		
		temp=new int[2];
		temp[0]=a;
		temp[1]=0;
		answer[a]=0;
		pq.add(temp);
		
		while(!pq.isEmpty()) {
			temp=pq.remove();
			if(visited[temp[0]]) continue;
			visited[temp[0]]=true;
			for(int [] i:graph[temp[0]]) {
				if(visited[i[0]]) continue;
				if(answer[i[0]]>temp[1]+i[1]) answer[i[0]]=temp[1]+i[1];
				temp1=new int[2];
				temp1[0]=i[0];
				temp1[1]=answer[i[0]];
				pq.add(temp1);
			}
		}
		
		if(answer[b]==987654321) System.out.println(-1);
		else System.out.println(answer[b]);
	}

}
