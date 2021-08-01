package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_11568 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int[N][2];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j][0]<arr[i][0]&&arr[j][1]>=arr[i][1]) //해당 원소(arr[j])의 값이 현재 원소(arr[i])의 값보다 작고, 해당 원소까지의 최대 증가 부분 수열이 현재까지 계산했던 값보다 더 길 경우 
					arr[i][1] = arr[j][1]+1; //업데이트
			}
			if(max<arr[i][1]) max = arr[i][1]; //최댓값 갱신
		}
		
		System.out.println(max);
	}

}
