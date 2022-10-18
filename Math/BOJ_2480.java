package 백준문제;

import java.util.Scanner;

public class BOJ_2480 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		
		if(a==b&&a==c) System.out.println(10000+1000*a);
		else if(a==b||a==c) System.out.println(1000+100*a);
		else if(b==c) System.out.println(1000+100*b);
		else System.out.println(100*Math.max(a, Math.max(b, c)));
	}

}
