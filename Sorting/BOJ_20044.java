package 백준문제;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_20044 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int n=input.nextInt();
		
		int [] w=new int[2*n];
		for(int i=0;i<2*n;i++)
			w[i]=input.nextInt();
		
		Arrays.sort(w);
		
		int min = 200000;
		
		for(int i=0;i<n;i++)
			if((w[i]+w[2*n-i-1])<min) min = (w[i]+w[2*n-i-1]); 
		
		System.out.println(min);
	}

}
