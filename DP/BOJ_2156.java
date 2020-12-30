package 백준문제;

import java.util.Scanner;

public class BOJ_2156 {
	public static int func(int a,boolean b,int [] A, int [][] B) {
		if(a==0) return A[0];
		else if(a<0) return 0; 
		
		int x,y,z;
		
		if(B[a][1]!=-1&&!b) return B[a][1];
		else if(B[a][1]!=-1&&B[a][0]!=-1&&b) return (B[a][1]>B[a][0])?B[a][1]:B[a][0];
		
		
		if(b) {
			x=A[a]+func(a-1,false,A,B);
			y=A[a]+func(a-2,true,A,B);
			z=A[a]=func(a-3,true,A,B);
			if(x>=y&&x>=z) return B[a][0]=x;
			else return B[a][1]=(y>z)?y:z;
		}
		else {
			x=A[a]+func(a-2,true,A,B);
			y=A[a]+func(a-3,true,A,B);
			return B[a][1]=(x>y)?x:y;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int n=input.nextInt();
		
		int [] A=new int[n];
		
		for(int i=0;i<n;i++)
			A[i]=input.nextInt();
		
		int [][] B=new int[n][3];
		
		for(int i=0;i<n;i++) {
			B[i][0]=-1;
			B[i][1]=-1;
			B[i][2]=-1;
		}
		
		if(n==1) System.out.println(A[0]);
		else {
			int temp1=func(n-1,true,A,B);
			int temp2=func(n-2,false,A,B);
		
			int ans=(temp1>temp2)?temp1:temp2;
			
			System.out.println(ans);
		}
		
	}
}
