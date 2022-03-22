package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_9076 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int [] score;
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			
			score = new int[5];
			
			for(int i=0;i<5;i++) 
				score[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(score);
		
			if(score[3]-score[1]>=4) System.out.println("KIN");
			else System.out.println(score[1]+score[2]+score[3]);
		}
	}

}
