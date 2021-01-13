package 백준문제;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1931 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		int [][] A=new int[N][2];
		
		for(int i=0;i<N;i++) {
			A[i][0]=input.nextInt();
			A[i][1]=input.nextInt();
		}
		
		Arrays.sort(A,new Comparator<int[]>() {
			public int compare(int [] o1, int [] o2) {
				if(o1[1]==o2[1])
					return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		
		int ans=0;
		int temp=0;
		
		for(int i=0;i<N;i++) {
			if(temp<A[i][0]) {
				temp=A[i][1];
				ans++;
			}
		}
		
		System.out.printf("%d",ans);
	}

}
