package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_17298 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		int [] answer = new int[N];
		int [] Stack = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int a, top = 0;
		
		for(int i=0;i<N;i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=N-1;i>=0;i--) {
			while(top>0) {
				a = Stack[top-1];
				
				if(a>arr[i]) {
					answer[i] = a;
					break;
				}
				
				top--;
			}
			if(top==0) answer[i] = -1;
			Stack[top++] = arr[i];
		}
			
		for(int i=0;i<N;i++)
			bw.write(answer[i]+" ");
		
		bw.write("\n");
		bw.flush();
		bw.close();
		
		
	}

}
