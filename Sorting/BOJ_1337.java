package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_1337 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(br.readLine());
	
		Arrays.sort(arr); //배열 정렬
		
		int ck, answer=4;
		
		for(int i=0;i<N;i++) {
			ck = 4;
			
			for(int j=1;j<5;j++) {
				if(i+j>=N) break;
				
				if(arr[i+j]-arr[i]<=4) ck--;
			}
			
			if(answer>ck) answer = ck; //답 update
		}
		
		System.out.println(answer);
	}

}
