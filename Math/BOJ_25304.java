package 백준문제;

import java.util.Scanner;

public class BOJ_25304 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int X = input.nextInt();
		
		int N = input.nextInt();
		
		int sum = 0, a, b;
		
		for(int i=0;i<N;i++) {
			a = input.nextInt();
			b = input.nextInt();
			
			sum += a*b;
		}
		
		if(sum==X) System.out.println("Yes");
		else System.out.println("No");
	}

}
