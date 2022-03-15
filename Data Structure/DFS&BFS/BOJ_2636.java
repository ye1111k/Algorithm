package 백준문제;

import java.util.*;
import java.io.*;
class Point_2636{
	int r,c;
	public Point_2636(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class BOJ_2636 {
	public static int [] dr = {-1,1,0,0};
	public static int [] dc = {0,0,-1,1};
	public static boolean [][] visited;
	
	
	public static int [][] square;
	public static int N, M;
	
	public static int bfs() {
		LinkedList<Point_2636> Queue = new LinkedList<Point_2636>(); 
		visited = new boolean[N][M];
		int cnt = 0,tr,tc;
		
		Point_2636 p = new Point_2636(0,0);
		Queue.addLast(p);
		
		while(!Queue.isEmpty()) {
			p = Queue.removeFirst();
			
			for(int i=0;i<4;i++) {
				tr = p.r+dr[i];
				tc = p.c+dc[i];
				if(tr<0||tc<0||tr>=N||tc>=M||visited[tr][tc]) continue;
				if(square[tr][tc]==1) {
					cnt++;
					square[tr][tc] = 0;
				}
				else {
					Queue.addLast(new Point_2636(tr,tc));
				}
				visited[tr][tc] = true;
			}
		}
		
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		square = new int[N][M];
		int cheese = 0,time=0,cnt=0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
				if(square[i][j]==1) cheese++;
			}
		}
		
		while(cheese>0) {
			cnt = cheese;
			time++;
			cheese-=bfs();
		}
		
		System.out.println(time);
		System.out.println(cnt);
		
	}

}
