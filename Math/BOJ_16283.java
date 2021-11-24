package 백준문제;

import java.util.*;

public class BOJ_16283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int n = input.nextInt();
		int w = input.nextInt();
		
		boolean ck = false;
		
		int x = 1, y = n-1;
		
		for(int i=1;i<n;i++) {
			if(i*a+(n-i)*b==w) {
				if(ck) {
					ck = false;
					break;
				}
				x = i;
				y = n-i;
				ck = true;
			}
		}
		
		if(ck) System.out.println(x+" "+y);
		else System.out.println(-1);
	}

}
