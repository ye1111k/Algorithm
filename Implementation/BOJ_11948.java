package 백준문제;

import java.util.*;

public class BOJ_11948 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int [] science = new int[4];
		int [] society = new int[2];
		
		for(int i=0;i<4;i++)
			science[i] = input.nextInt();
		for(int i=0;i<2;i++)
			society[i] = input.nextInt();
		
		Arrays.sort(science);
		Arrays.sort(society);
		
		int total = science[1] + science[2] + science[3] + society[1];
		System.out.println(total);
	}

}
