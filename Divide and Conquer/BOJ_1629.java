package 백준문제;

import java.util.Scanner;

public class BOJ_1629 {
	public static int func(int a,int b,int c) {
		if(b==1) return a%c;
		int x=func(a,b/2,c);
		if(b%2==1) return (func(a,b-1,c)*func(a,1,c))%c;
		else return (x*x)%c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int A=input.nextInt();
		int B=input.nextInt();
		int C=input.nextInt();
		
		int ans=func(A,B,C);
		
		System.out.println(ans);
	}

}
