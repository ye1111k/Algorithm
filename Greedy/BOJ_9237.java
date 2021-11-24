package 백준문제;

import java.util.*;

public class BOJ_9237 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		
		StringTokenizer st = new StringTokenizer(input.nextLine());
		
		Integer [] arr = new Integer[n];
		
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr, Collections.reverseOrder()); //자라는 데 가장 오래 걸리는 나무부터 체크
		
		int max = 0;
		
		for(int i=0;i<n;i++) {
			arr[i]+=i; //심는 순서 더하기
			if(max<arr[i]) max = arr[i];
		}
		
		System.out.println(max+2); //2 더하는 이유: 처음 나무를 산 날 1일, 처음 나무 심는 시간 1일
		
		
	}

}
