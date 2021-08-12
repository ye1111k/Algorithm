package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_9372 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int N,M;
		ArrayList<Integer> [] graph;
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<M;i++)
				br.readLine();
			
			System.out.println(N-1);
		}
	}

}
