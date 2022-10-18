package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_13335 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> Queue = new LinkedList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int [] a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			a[i] = Integer.parseInt(st.nextToken());
		
		int answer = 0,now_weight = 0,i=0;
		
		while(true) {
			if(Queue.size()==w) now_weight-=Queue.removeFirst();
			
			if(L-now_weight>=a[i]) {
				Queue.addLast(a[i]);
				now_weight+=a[i];
				i++;
			}
			else Queue.addLast(0);
			
			if(i==n) break;
			
			answer++;
		}
		
		answer += w+1; //마지막 트럭이 지나가는 시간
		
		System.out.println(answer);
		
	}

}
