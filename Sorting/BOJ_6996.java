package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_6996 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int T=input.nextInt();
		
		String s1, s2;
		char [] c1;
		char [] c2;
		boolean ck;
		
		for(int t=0;t<T;t++) {
			ck=false;
			s1=input.next();
			s2=input.next();
			
			c1=s1.toCharArray();
			c2=s2.toCharArray();
			
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			if(s1.length()==s2.length()) {
				int j;
				for(j=0;j<s1.length();j++) {
					if(c1[j]!=c2[j]) break;
				}
				if(j==s1.length()) ck=true;
			}
			
			if(ck) System.out.println(s1+" & "+s2+" are anagrams.");
			else System.out.println(s1+" & "+s2+" are NOT anagrams.");
		} 
		
	}

}
