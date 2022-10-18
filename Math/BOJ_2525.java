package 백준문제;

import java.util.*;

public class BOJ_2525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int A = input.nextInt();
		int B = input.nextInt();
		int C = input.nextInt();
		
		int hour = (A+(B+C)/60)%24;
		int min = (B+C)%60;
		
		System.out.println(hour+" "+min);
	}

}