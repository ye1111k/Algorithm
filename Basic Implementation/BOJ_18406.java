package 백준문제;

import java.util.Scanner;

public class BOJ_18406 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		String s=input.next();
		
		int a=0,b=0;
		for(int i=0;i<s.length()/2;i++)
			a+=s.charAt(i)-'0';
		for(int i=s.length()/2;i<s.length();i++)
			b+=s.charAt(i)-'0';
		
		if(a==b) System.out.println("LUCKY");
		else System.out.println("READY");
	}

}
