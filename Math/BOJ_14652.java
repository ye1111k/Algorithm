package 백준문제;

import java.util.*;

public class BOJ_14652 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int M = input.nextInt();
		int K = input.nextInt();
		
		int a = K/M;
		int b = K%M;
		
		System.out.println(a+" "+b);
	}

}
