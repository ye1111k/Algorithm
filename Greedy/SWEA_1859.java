package 백준문제;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_1859 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		int N, max;
		long answer;
		int [] arr;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			arr = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			answer = 0;
			max = arr[N-1];
			
			for(int i=N-2;i>=0;i--) {
				if(max<arr[i])
					max = arr[i];
				else answer += (max-arr[i]);
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
			
		}
	}

}
