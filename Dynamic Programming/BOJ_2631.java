package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_2631 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] children = new int[N];
		
		for(int i=0;i<N;i++)
			children[i] = Integer.parseInt(br.readLine());
		
		//주어진 배열에서 가장 긴 증가하는 부분 수열을 제외한 원소들을 알맞은 위치에 넣어주면 된다.
		//즉, 가장 긴 증가하는 부분 수열에 속하지 않는 원소의 개수를 구해주면 되는 문제!
		
		int [] arr = new int[N];
		int max = 1; //가장 긴 증가하는 부분 수열의 크기 저장할 변수
		
		Arrays.fill(arr, 1);
		
		
		//i번째 원소까지의 가장 긴 증가하는 부분 수열의 크기 구하기
		for(int i=1;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(children[i]>children[j]) {
					if(arr[j]>=arr[i]) {
						arr[i] = arr[j]+1;
						max = (arr[i]>max)?arr[i]:max;
					}
				}
			}
		}
		
		
		System.out.println(N-max);
	}

}
