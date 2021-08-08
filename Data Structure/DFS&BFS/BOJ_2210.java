package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_2210 {
	public static int [] dx = {-1,1,0,0};
	public static int [] dy = {0,0,-1,1};
	public static String [][] arr;
	public static void dfs(int count, String str, LinkedList<String> s, int r, int c) {
		if(count == 6) {
			if(!s.contains(str)) s.addLast(str);
			return;
		}
		
		int x,y;
		for(int i=0;i<4;i++) {
			x = r+dx[i];
			y = c+dy[i];
			if(0<=x && x<5 && 0<=y && y<5)
				dfs(count+1, str + arr[x][y], s, x, y);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new String[5][5];
		
		StringTokenizer st;
		
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++)
				arr[i][j] = st.nextToken();
		}
		
		LinkedList<String> s = new LinkedList<String>();
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				dfs(1, arr[i][j], s, i, j);
			}
		}
		
		System.out.println(s.size());
	}

}
