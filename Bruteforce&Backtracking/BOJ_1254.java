package 백준문제;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1254 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		LinkedList<Character> aaa=new LinkedList<Character>();
		
		String s=input.next();
		for(int i=0;i<s.length();i++) aaa.add(s.charAt(i));
		
		boolean ck=true;
		String sub=s;
		
		for(int i=0;i<s.length()-1;i++) {
			ck=true;
			for(int j=0;j<=sub.length()/2;j++) {
				if(sub.charAt(j)!=sub.charAt(sub.length()-j-1)) {
					ck=false;
					break;
				}
			}
			if(ck) break;
			sub=s;
			for(int j=i;j>=0;j--) sub+=s.substring(j, j+1);
		}
		System.out.println(sub.length());
	}

}
