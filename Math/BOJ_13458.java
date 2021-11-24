package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_13458 {
	
	public static long solution(int N, int [] A, int B, int C) {
		long ans = N;
		long temp;
		for(int i=0;i<N;i++) {
			temp = A[i] - B;
			if(temp<0) continue;
			else if(temp%C!=0) ans += temp/C + 1;
			else ans += temp/C;
		}
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] A = new int[N];
		for(int i=0;i<N;i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long ans = solution(N, A, B, C);
		
		System.out.println(ans);
		
	}

}
