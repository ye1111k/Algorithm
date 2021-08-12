package 백준문제;

import java.util.*;
import java.io.*;


public class BOJ_2869 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int temp = V - A;
		int day = A - B;
		
		int ans = 0;
		if(temp%day==0)
			ans = temp/day + 1;
		else
			ans = temp/day + 2;
		
		
		System.out.println(ans);
	}

}
