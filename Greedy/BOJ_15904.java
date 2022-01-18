package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_15904 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int ck = 0;
		
		for(int i=0;i<s.length();i++) {
			if(ck==0) {
				if(s.charAt(i)=='U') ck++;
			}
			else if(ck==1) {
				if(s.charAt(i)=='C') ck++;
			}
			else if(ck==2) {
				if(s.charAt(i)=='P') ck++;
			}
			else if(ck==3) {
				if(s.charAt(i)=='C') {
					ck++;
					break;
				}
			}
		}
		
		if(ck==4) System.out.println("I love UCPC");
		else System.out.println("I hate UCPC");
	}

}
