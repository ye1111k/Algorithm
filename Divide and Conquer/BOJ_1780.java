package 백준문제;

import java.util.Scanner;

public class BOJ_1780 {
	public static int a=0,b=0,c=0;
	public static int func(int y,int x,int N,int [][] paper){
		if(N==0)
			return paper[y][x];
		
		int t1=0,t2=0,t3=0,temp;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				temp=func(y+i*N,x+j*N,N/3,paper);
				if(temp==-1) t1++;
				else if(temp==0) t2++;
				else if(temp==1) t3++;
			}
		}
		if(t1==9) return -1;
		else if(t2==9) return 0;
		else if(t3==9) return 1;
		else {
			a+=t1;
			b+=t2;
			c+=t3;
			return 999;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int temp;
		
		int [][] paper=new int[3000][3000];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				paper[i][j]=input.nextInt();
		}
		
		temp=func(0,0,N/3,paper);
		
		if(temp==1) c++;
		else if(temp==0) b++;
		else if(temp==-1)a++;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
	}

}
