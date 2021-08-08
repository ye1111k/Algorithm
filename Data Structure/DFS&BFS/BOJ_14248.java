package 백준문제;

import java.util.*;

public class BOJ_14248 {
	public static int [] arr;
	public static boolean [] visited;
	public static void dfs(int n, int now) {
		if(now + arr[now] < n+1) {
			if(!visited[now + arr[now]]) {
				visited[now + arr[now]] = true;
				dfs(n, now + arr[now]);
			}
		}
		if(now - arr[now] > 0) {
			if(!visited[now - arr[now]]) {
				visited[now - arr[now]] = true;
				dfs(n, now - arr[now]);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = Integer.parseInt(input.nextLine());
		
		arr = new int[n+1];
		visited = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(input.nextLine());
		for(int i=1;i<=n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(input.nextLine());
		
		visited[start] = true;
		
		dfs(n, start);
		
		int ans = 0;
		
		for(int i=1;i<=n;i++) {
			if(visited[i]) ans++;
		}
		
		System.out.println(ans);
	}

}
