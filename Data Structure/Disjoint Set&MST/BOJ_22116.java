package 백준문제;

import java.util.*;
import java.io.*;
class Edge{
	int a, b, weight;
	
	public Edge(int a, int b, int weight) {
		this.a = a;
		this.b = b;
		this.weight = weight;
	}
}
public class BOJ_22116 {
	public static int [] parent;
	public static int [] size;
	
	public static int find(int a) {
		if(parent[a]==a) return a;
		return parent[a] = find(parent[a]);
	}
	public static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		int temp;
		
		if(size[a]>size[b]) { //깊이가 깊은 쪽이 부모 노드가 된다
			temp=a;
			a=b;
			b=temp;
		}
		parent[a]=b;
		size[b]+=size[a];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] grid = new int[N][N];
		parent = new int[N*N];
		size = new int[N*N];
		int ans = 0;
		
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				grid[i][j] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Edge> edge = new ArrayList<Edge>();
		int right, down, now;
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<N-1;j++) {
				now = i*N + j; //현재 보고 있는 노드의 번호
				parent[now] = now;
				size[now] = 1;
				
				//오른쪽으로 가는 경우
				right = Math.abs(grid[i][j]-grid[i][j+1]);
				edge.add(new Edge(now, now + 1, right)); 
				
				//아래로 가는 경우
				down = Math.abs(grid[i][j]-grid[i+1][j]);
				edge.add(new Edge(now, now+N, down)); 
			}
			now = i * N + N - 1;
			parent[now] = now;
			size[now] = 1;
			
			//가장 오른쪽 칸에서 아래로 가는 경우
			down = Math.abs(grid[i][N-1]-grid[i+1][N-1]);
			edge.add(new Edge(now, now+N, down));
		}
		
		//가장 아랫줄에서 오른쪽으로 가는 경우
		for(int i=0;i<N-1;i++) {
			now = N*(N-1) + i;
			parent[now] = now;
			size[now] = 1;
			
			right = Math.abs(grid[N-1][i]-grid[N-1][i+1]);
			edge.add(new Edge(now, now + 1, right));
		}
		
		parent[N*N-1] = N*N-1; //마지막 노드 초기화
		size[N*N-1] = 1;
		
		Collections.sort(edge, new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});
		
		Edge temp;
		for(int i=0;i<edge.size();i++) {
			temp = edge.get(i);
			if(find(temp.a)!=find(temp.b)) {
				union(temp.a, temp.b);
				ans = temp.weight;
			}
		
			if(find(0)==find(N*N-1)) break; //1,1과 N,N이 같은 집합에 있다면 break
		}
		
		System.out.println(ans);
	}

}
