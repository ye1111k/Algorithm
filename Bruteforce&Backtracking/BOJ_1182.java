package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_1182 {
	static boolean [] ck;
	static int [] arr;
	static int N, S, answer;
	static ArrayList<Integer> used;
	
	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		ck = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		answer = 0;
		
		for(int i=1;i<=N;i++) {
			used = new ArrayList<Integer>();
			func(i, 0); //i개의 숫자로 만들 수 있는 조합
		}
		
		System.out.println(answer);
	}
	
	public static void func(int n, int now) {
		if(used.size()==n) {//n개 만큼 뽑았을 때
			int temp = 0;
			for(int i=0;i<n;i++) 
				temp+=used.get(i); //조합에 있는 원소의 합 구하기
			if(temp == S) answer++; //그 합이 S와 같을 경우
			return;
		}
		
		if(now >= N) return;
		
		for(int i=now;i<N;i++) { //조합 구하는 백트래킹
			if(!ck[i]) {
				ck[i] = true;
				used.add(arr[i]);
				func(n, i+1);
				used.remove(used.size() - 1);
				ck[i] = false;
			}
		}
	}

}
