package 백준문제;

import java.util.Scanner;

public class BOJ_2579 {
	public static int func(int a,boolean b,int [] A, int [][] B) {
		if(a==0) return A[0];
		else if(a<0) return 0; 
		
		int x,y;
		
		if(B[a][1]!=0&&!b) return B[a][1];
		else if(B[a][1]!=0&&B[a][0]!=0&&b) return (B[a][1]>B[a][0])?B[a][1]:B[a][0];
		
		
		if(b) {
			x=A[a]+func(a-1,false,A,B);
			y=A[a]+func(a-2,true,A,B);
			if(x>y) return B[a][0]=x;
			else return B[a][1]=y;
		}
		else return B[a][1]=A[a]+func(a-2,true,A,B);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int [] A=new int[N];
		for(int i=0;i<N;i++)
			A[i]=input.nextInt();
		
		int [][] B=new int[N][2];
		
		int ans=func(N-1,true,A,B);
		
		System.out.println(ans);
		
	}
}
