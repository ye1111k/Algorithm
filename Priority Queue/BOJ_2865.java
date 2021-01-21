package 백준문제;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2865 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int M=input.nextInt();
		int K=input.nextInt();
		
		double [] arr=new double[N];
		
		int temp;
		double temp1;
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				temp=input.nextInt();
				temp1=input.nextDouble();
				if(arr[temp-1]<temp1) arr[temp-1]=temp1;
			}
		}
		
		Arrays.sort(arr);
		
		double sum=0;
		
		for(int i=0;i<K;i++)
			sum+=arr[N-1-i];
		
		System.out.printf("%.1f",sum);
	}

}
