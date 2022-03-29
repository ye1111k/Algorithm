package 백준문제;

import java.util.Scanner;

public class BOJ_9251 {
	
	public static int [][] A=new int[1010][1010];
	public static String s1,s2;
	
	public static int max(int a,int b) {
		if(a>b) return a;
		else return b;
	}
	
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		
		s1=input.next();
		s2=input.next();
		
		for(int i=0;i<s1.length();i++) {
			for(int j=0;j<s2.length();j++) {
				if(s2.charAt(j)==s1.charAt(i)) A[i+1][j+1]=A[i][j]+1;
				else A[i+1][j+1]=max(A[i][j+1],A[i+1][j]);
			}
		}
		System.out.println(A[s1.length()][s2.length()]);
		
	}

}
