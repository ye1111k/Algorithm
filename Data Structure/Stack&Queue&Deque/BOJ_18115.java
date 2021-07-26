package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_18115 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		int [] arr = new int[N+1];
		
		for(int i=N;i>0;i--)
			arr[i]=Integer.parseInt(st.nextToken());
			
		for(int i=1;i<=N;i++) {
			if(arr[i]==1) deque.addLast(i);
			else if(arr[i]==2) {
				int temp=deque.removeLast();
				deque.addLast(i);
				deque.addLast(temp);
			}
			else deque.addFirst(i);
		}
		
		while(!deque.isEmpty()) 
			bw.write(deque.removeLast()+" ");
		
		bw.flush();
		bw.close();
	}

}
