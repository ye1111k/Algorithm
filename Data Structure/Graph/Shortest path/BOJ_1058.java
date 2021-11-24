package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_1058 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] friend = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				if(s.charAt(j)=='N') friend[i][j] = 54321;
				else friend[i][j] = 1;
			}
		}
		
		int [] friend2 = new int[N];
		
		int max = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(j==i) continue; //자기 자신이랑은 친구x
				if(friend[i][j]==1) { //i와 j가 친구일 경우
					friend2[i]++;
					continue;
				}
				
				for(int k=0;k<N;k++) {
					if(k==i||k==j) continue; //자기 자신이랑은 친구x
					if(friend[i][k]==1&&friend[j][k]==1) { //i와도 친구이고 j와도 친구인 k가 있을 경우
						friend2[i]++;
						break;
					}
				}
			}
			max = Math.max(max, friend2[i]);
		}
		
		System.out.println(max);
	}

}
