package 백준문제;

import java.util.*;

public class BOJ_16395 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int k = input.nextInt();
		
		int [][] arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			arr[i][0] = 1;
			arr[i][i] = 1;
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<i;j++)
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
		}
		
		System.out.println(arr[n-1][k-1]);
	}

}
