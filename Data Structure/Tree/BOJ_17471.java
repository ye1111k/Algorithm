package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_17471 {
	public static int min = -1, N;
	public static int [] population;
	public static ArrayList<Integer>[] graph;
	
	public static boolean [] visited;
	public static boolean [] connected;
	public static ArrayList<Integer> ward;
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer pop = new StringTokenizer(br.readLine());
		StringTokenizer st;
		
		population = new int[N+1];
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		int n;
		
		for(int i=1;i<=N;i++) {
			population[i] = Integer.parseInt(pop.nextToken());
			
			graph[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			for(int j=0;j<n;j++)
				graph[i].add(Integer.parseInt(st.nextToken()));
		}
		
		ward = new ArrayList<Integer>();
		ward.add(1);
		visited[1] = true;
		
		for(int i=1;i<N;i++)
			dfs(1,i,1);
		
		System.out.println(min);
	}                                                                       
	
	public static void dfs(int now, int n, int size) {
		if(size==n) {
			int a = 0, b = 0;
			ArrayList<Integer> nward = new ArrayList<Integer>();
			for(int i=1;i<=N;i++) {
				if(!visited[i]) {
					a+=population[i];
					nward.add(i);
				}
				else b+=population[i];
			}
			
			connected = new boolean[N+1];
			
			bfs(ward); //선거구 연결되어있는지 확인
			bfs(nward); //비선거구 연결되어있는지 확인
			
			for(int i=1;i<=N;i++)
				if(!connected[i]) return;
			
			int temp = Math.abs(a-b);
			if(min==-1 || min > temp) min = temp; 
			
			return;
		}
		for(int i = now + 1;i<=N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				ward.add(i);
				dfs(i, n, size+1);
				ward.remove(size);
				visited[i] = false;
			}
		}
	}
	public static void bfs(ArrayList<Integer> arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int temp = arr.get(0);
		pq.add(temp);
		connected[temp] = true;
		
		while(!pq.isEmpty()) {
			temp = pq.remove();
			for(int i:graph[temp]) {
				if(!arr.contains(i)) continue;
				if(!connected[i]) pq.add(i);
				connected[i] = true;
			}
		}
	}
}
