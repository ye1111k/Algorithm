package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_2294 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] coin = new int[n];
		
		for(int i=0;i<n;i++)
			coin[i] = Integer.parseInt(br.readLine());
		
		int [] arr = new int[k+1]; //k원 만드는 데 필요한 동전의 개수 저장할 배열
		for(int i=1;i<=k;i++)
			arr[i] = 10101; //초기화
		
		for(int i=0;i<n;i++) {
			for(int j=coin[i];j<k+1;j++) {
				arr[j] = Math.min(arr[j], arr[j-coin[i]]+1);
			}
		}
		
		int answer = (arr[k]!=10101)?arr[k]:-1;
		
		System.out.println(answer);
	}

}
