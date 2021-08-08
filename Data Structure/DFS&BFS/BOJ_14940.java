package 백준문제;

import java.io.*;
import java.util.*;

class Point{
	int r,c,count;
	
	public Point(int r, int c, int count) {
		this.r = r;
		this.c = c;
		this.count = count;
	}
}

public class BOJ_14940 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [][] dis = new int[n][m];
		int [] dx = {-1,1,0,0};
		int [] dy = {0,0,-1,1};
		
		int a = 0, b = 0, temp;
		
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < m;j++) {
				temp = Integer.parseInt(st.nextToken());
				if(temp!=0) dis[i][j] = -1;
				if(temp==2) {
					a = i;
					b = j;
				}
			}
		}
		
		LinkedList<Point> Queue = new LinkedList<Point>();
		
		Queue.addLast(new Point(a,b,0));
		dis[a][b] = 0;
		
		Point point;
		
		while(!Queue.isEmpty()) {
			point = Queue.removeFirst();
			for(int i=0;i<4;i++) {
				if(0 <= point.r+dx[i] && point.r+dx[i] < n && 0 <= point.c+dy[i] && point.c+dy[i] < m) {
					if(dis[point.r+dx[i]][point.c+dy[i]] == -1) {
						dis[point.r+dx[i]][point.c+dy[i]] = point.count+1;
						Queue.addLast(new Point(point.r+dx[i],point.c+dy[i],point.count+1));
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				bw.write(dis[i][j]+" ");
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}

}
