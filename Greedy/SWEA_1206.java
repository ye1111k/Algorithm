package 백준문제;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_1206 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		int N, answer, diff_min;
		int [] arr;
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			arr = new int[N];
			answer = 0;
			
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			for(int i=2;i<N-2;i++) {
				diff_min = arr[i] - arr[i-2]; //왼쪽 두 칸 옆
				if(diff_min>arr[i]-arr[i-1]) diff_min = arr[i]-arr[i-1]; //왼쪽 한 칸 옆
				if(diff_min>arr[i]-arr[i+1]) diff_min = arr[i]-arr[i+1]; //오른쪽 한 칸 옆
				if(diff_min>arr[i]-arr[i+2]) diff_min = arr[i]-arr[i+2]; //오른쪽 두 칸 옆
				
				if(diff_min>0) answer += diff_min; //조망권이 확보된 세대가 있으면
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

}
