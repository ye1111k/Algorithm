package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_9009 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int [] fibo = new int[46]; //피보나치 수열 값 저장할 배열
		fibo[1] = 1;
		for(int i=2;i<=45;i++) //fibo[45]=1,134,903,170
			fibo[i] = fibo[i-1] + fibo[i-2]; 
		
		int T = Integer.parseInt(br.readLine());
		int n;
		
		StringBuilder sb;
		
		LinkedList<Integer> stack;
		
		for(int t=0;t<T;t++) {
			n = Integer.parseInt(br.readLine());
			stack = new LinkedList<Integer>();
			
			for(int i=45;i>0;i--) { //큰 거부터 빼기
				if(n>=fibo[i]) {
					n-=fibo[i]; //n이 fibo[i]보다 큰 경우 빼주기
					stack.addLast(fibo[i]); //fibo[i]값 stack에 push 
				}
				if(n==0) break; //n이 0이 된 경우 반복문 탈출
			}
			
			while(!stack.isEmpty()) {
				bw.write(stack.removeLast()+" "); //stack에서 하나씩 pop하면서 출력
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
