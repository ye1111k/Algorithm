package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_1707 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int t=0;t<K;t++) {
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			
			//그래프 초기화
			ArrayList<Integer> [] graph = new ArrayList[V+1];
			for(int i=1;i<=V;i++)
				graph[i] = new ArrayList<Integer>();
			
			int a,b;
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			
			//bfs용 queue 생성
			LinkedList<Integer> Queue = new LinkedList<Integer>();
			boolean ck = false;
			int [] visited = new int[V+1]; //각 정점이 어느 집합에 속하는지 저장할 배열
			
			Queue.add(1);
			visited[1] = 1;
			
			for(int g=1;g<=V;g++) { //연결그래프가 아닐 경우 대비
				if(visited[g]==0) Queue.addLast(g);
				while(!Queue.isEmpty()) {
					a = Queue.removeFirst();
					for(int i:graph[a]) {
						if(visited[i]!=0) {//이미 방문한 적 있는 정점일 경우
							if(visited[i]!=visited[a]) continue;
							else {
								ck = true; //i번 정점이 a번 정점과 같은 집합에 속해있음
								break;
							}
						}
						if(ck) break;
						visited[i] = visited[a]%2+1; //a가 1번에 속해있으면 i는 2번, a가 2번에 속해있으면 i는 1번으로 저장
						Queue.addLast(i);
					}
				}
				if(ck) break;
			}
			if(!ck) System.out.println("YES");
			else System.out.println("NO");
			
		}
	}

}