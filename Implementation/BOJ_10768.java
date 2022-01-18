package 백준문제;

import java.util.*;

public class BOJ_10768 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int m = input.nextInt();
		int d = input.nextInt();
		
		if(m==2) {
			if(d==18) System.out.println("Special");
			else if(d<18) System.out.println("Before");
			else System.out.println("After");
		}
		else if(m<2) System.out.println("Before");
		else System.out.println("After");
	}

}
