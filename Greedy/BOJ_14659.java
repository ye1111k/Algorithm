package 백준문제;

import java.util.Scanner;

public class BOJ_14659 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int [] h=new int[N];
		
		for(int i=0;i<N;i++)
			h[i]=input.nextInt();
		
		int max=0;
		for(int i=0;i<N;i++) {
			int j;
			for(j=i+1;j<N;j++)
				if(h[i]<h[j]) break;
			if(max<j-i) max=j-i-1;
		}
		
		System.out.println(max);
	}

}
