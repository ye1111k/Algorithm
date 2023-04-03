package 백준문제;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_2072 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		int temp, input;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			temp = 0;
			
			for(int i=0;i<10;i++) {
				input = sc.nextInt();
				if(input%2==1) temp += input;
			}
			
			System.out.printf("#%d %d\n", test_case, temp);
		}
	}

}
