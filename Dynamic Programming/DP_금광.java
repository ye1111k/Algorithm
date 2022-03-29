package 이취코;

import java.util.Scanner;

public class DP_금광 {
	public static int max(int a,int b,int c) {
		if(a>=b&&a>=c) return a;
		else if(b>=a&&b>=c) return b;
		else return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int T=input.nextInt();
		
		int n,m;
		int [][] a;
		int [][] b;
		int [] ans=new int[1010];
		
		for(int i=0;i<T;i++) {
			n=input.nextInt();
			m=input.nextInt();
			
			a=new int[25][25];
			b=new int[25][25];
			
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=m;k++)
					a[j][k]=input.nextInt();
			}
			
			for(int k=1;k<=m;k++) {
				for(int j=1;j<=n;j++) {
					b[j][k]=a[j][k]+max(b[j-1][k-1],b[j][k-1],b[j+1][k-1]);
				}
			}
			ans[i]=b[1][m];
			for(int j=2;j<=n;j++)
				if(b[j][m]>ans[i]) ans[i]=b[j][m];
		}
		for(int i=0;i<T;i++)
			System.out.println(ans[i]);
	}

}
