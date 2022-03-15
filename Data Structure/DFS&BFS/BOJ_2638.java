package 백준문제;

import java.util.*;
import java.io.*;

class Point_2638{
	int r,c;
	public Point_2638(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class BOJ_2638 {

	public static int [] dr = {-1,1,0,0};
	public static int [] dc = {0,0,-1,1};
	public static boolean [][] visited;
	
	
	public static int [][] square;
	public static int N, M;
	
	public static int bfs() {
		LinkedList<Point_2638> Queue = new LinkedList<Point_2638>(); 
		visited = new boolean[N][M];
		int cnt = 0,tr,tc;
		
		Point_2638 p = new Point_2638(0,0);
		Queue.addLast(p);
		
		while(!Queue.isEmpty()) {
			p = Queue.removeFirst();
			
			for(int i=0;i<4;i++) {
				tr = p.r+dr[i];
				tc = p.c+dc[i];
				if(tr<0||tc<0||tr>=N||tc>=M||visited[tr][tc]) continue;
				if(square[tr][tc]==2) { //공기와 두 면이 당아있을 경우
					cnt++;
					square[tr][tc] = 0;
					visited[tr][tc] = true;
				}
				else if(square[tr][tc]==1) square[tr][tc]++; //공기랑 한 면이 닿아있을 경우
				else {
					Queue.addLast(new Point_2638(tr,tc));
					visited[tr][tc] = true;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				if(square[i][j]==2) square[i][j]=1; //공기랑 한 면만 닿아있었을 경우
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
		int cheese = 0,time=0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
				if(square[i][j]==1) cheese++;
			}
		}
		
		while(cheese>0) {
			time++;
			cheese-=bfs();
		}
		
		System.out.println(time);
	}

}
