package 백준문제;

import java.util.Scanner;

public class BOJ_16916 {
	public static boolean kmp(int [] f,String S,String P) {
		boolean ck=false;
		
		int j=0;
		
		for(int i=0;i<S.length();i++) {
			while(j>0&&S.charAt(i)!=P.charAt(j))
				j=f[j-1];
			if(S.charAt(i)==P.charAt(j))
				j++;
			if(j==P.length()) {
				ck=true;
				break;
			}
		}
		
		return ck;
	}
	
	public static void getf(int [] f,String P) {
		int j=0;
		for(int i=1;i<P.length();i++) {
			while(j>0&&P.charAt(i)!=P.charAt(j))
				j=f[j-1];
			if(P.charAt(i)==P.charAt(j))
				f[i]=++j;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		String S=input.nextLine();
		String P=input.nextLine();
		
		int [] f=new int[P.length()];
		getf(f,P);
		if(kmp(f,S,P)) System.out.println(1);
		else System.out.println(0);
		
		
		
		
	}

}
