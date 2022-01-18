package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_14594 {
	public static int [] par;
	public static int find(int A) {
		if(par[A]==A) return A;
		else return par[A] = find(par[A]);
	}
	public static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x==y) return;
		
		if(x<=y) par[b] = x;
		else par[a] = y;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		par = new int[N+1];
		for(int i=1;i<=N;i++)
			par[i] = i;
		
		int x,y;
		StringTokenizer st;
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for(int i=x+1;i<=y;i++)
				union(x, i);
		}
		
		int answer = 1;
		
		for(int i=2;i<=N;i++) {
			if(par[i]==i) answer++;
		}
		
		System.out.println(answer);
	}
}
