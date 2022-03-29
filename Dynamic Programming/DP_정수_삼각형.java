package 이취코;

import java.util.Scanner;

public class DP_정수_삼각형 {
	public static int max(int a,int b) {
		if(a>b) return a;
		else return b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int n=input.nextInt();
		
		int [][] a=new int[510][510];
		int [][] b=new int[510][510];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				a[i][j]=input.nextInt();
				b[i][j]=a[i][j]+max(b[i-1][j-1],b[i-1][j]);
			}
		}
		
		int max=b[n][1];
		
		for(int i=2;i<=n;i++)
			if(max<b[n][i]) max=b[n][i];
		
		System.out.println(max);
		
	}

}
