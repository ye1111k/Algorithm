package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_1449 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int [] hole = new int[N];
		st = new StringTokenizer(br.readLine());
		
		
		for(int i=0;i<N;i++)
			hole[i] = Integer.parseInt(st.nextToken());
	
		Arrays.sort(hole);
	
		int tape = 1;
		double now = hole[0]-0.5+L;
		
		for(int i=0;i<N;i++) {
			if(hole[i]+0.5>now) {
				now = hole[i]-0.5+L;
				tape++;
			}
		}
		
		System.out.println(tape);
	}
}
