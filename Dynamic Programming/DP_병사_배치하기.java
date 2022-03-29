package 이취코;

import java.util.Scanner;

public class DP_병사_배치하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		int [] a=new int[N];
		
		for(int i=0;i<N;i++)
			a[i]=input.nextInt();
		
		int [] dp=new int[2020];
		dp[0]=1;
		
		int temp,max=dp[0];
		
		for(int i=1;i<N;i++) {
			temp=1;
			for(int j=0;j<i;j++)
				if(a[j]>a[i]&&temp<=dp[j]) temp=dp[j]+1;
			dp[i]=temp;
			if(dp[i]>max) max=dp[i];
		}
		System.out.println(N-max);
	}

}
