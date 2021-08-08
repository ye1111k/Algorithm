package 백준문제;

import java.util.*;
import java.io.*;
class A {
	int count;
	int now;
	
	public A(int count, int now) {
		this.count = count;
		this.now = now;
	}
}

public class BOJ_6118 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> [] graph = new ArrayList[N+1];
		int [] dis = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<Integer>();
			dis[i] = -1;
		}
		
		int a,b;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		LinkedList<A> Queue = new LinkedList<A>();
		
		Queue.addLast(new A(0,1));
		
		A temp;
		int ans1 = 1, ans2 = 0, ans3 = 1, count = 1;
		dis[1] = 0;
		
		while(!Queue.isEmpty()) {
			temp = Queue.removeFirst();
			if(count==N) break;
			for(int i: graph[temp.now]) {
				if(dis[i]==-1) {
					Queue.addLast(new A(temp.count+1, i));
					count++;
					dis[i] = temp.count+1;
					if(ans2 == temp.count+1) {
						ans3++;
						if(ans1>i) ans1 = i;
					}
					if(ans2<temp.count+1) {
						ans1 = i;
						ans2 = temp.count+1;
						ans3 = 1;
					}
				}
			}
		}
		System.out.println(ans1+" "+ans2+" "+ans3);
	}

}
