package 백준문제;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_9252 {

	public static String [][] A=new String[1010][1010];
	public static String s1,s2;
	
	public static String max(String a,String b) {
		if(a.length()>b.length()) return a;
		else return b;
	}
	
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		
		s1=input.next();
		s2=input.next();
		
		for(int i=0;i<1010;i++) {
			for(int j=0;j<1010;j++)
				A[i][j]="";
		}
		
		
		for(int i=0;i<s1.length();i++) {
			for(int j=0;j<s2.length();j++) {
				if(s2.charAt(j)==s1.charAt(i)) A[i+1][j+1]=A[i][j]+Character.toString(s2.charAt(j));
				else A[i+1][j+1]=max(A[i][j+1],A[i+1][j]);
			}
		}
		
		System.out.println(A[s1.length()][s2.length()].length());
		if(A[s1.length()][s2.length()].length()!=0) System.out.println(A[s1.length()][s2.length()]);
	}

}
