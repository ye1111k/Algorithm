package 백준문제;

import java.util.Scanner;

public class BOJ_2630 {
	public static int w=0,b=0;
	public static int [][] square;
	public static int func(int y,int x,int n) {
		if(n==1) {
			int i=0,j=0;
			if(square[y][x]==0) i++;
			else j++;
			if(square[y+1][x]==0) i++;
			else j++;
			if(square[y][x+1]==0) i++;
			else j++;
			if(square[y+1][x+1]==0) i++;
			else j++;
			if(i==0||i==4)
				return 1;
			else {
				w+=i;
				b+=j;
				return 0;
			}
		}
		else {
			 int i=func(y,x,n/2);
			 int j=func(y,x+n,n/2);
			 int k=func(y+n,x,n/2);
			 int h=func(y+n,x+n,n/2);
			 
			 int temp=square[y][x]+square[y][x+n]+square[y+n][x]+square[y+n][x+n];
			 
			 if(i==1&&j==1&&k==1&&h==1) {
				 if(temp==0||temp==4)
					 return 1;
			 }
			 if(i==1) {
				 if(square[y][x]==0) w++;
				 else b++;
			 }
			 if(j==1) {
				 if(square[y][x+n]==0) w++;
				 else b++;
			 }
			 if(k==1) {
				 if(square[y+n][x]==0) w++;
				 else b++;
			 }
			 if(h==1) {
				 if(square[y+n][x+n]==0) w++;
				 else b++;
			 }
			 
			 return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		square=new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				square[i][j]=input.nextInt();
		}
		
		int temp=func(0,0,N/2);
		if(temp==1) {
			if(square[0][0]==0) System.out.printf("1\n0");
			else System.out.println("0\n1");
		}
		else System.out.printf("%d\n%d",w,b);
	}

}
