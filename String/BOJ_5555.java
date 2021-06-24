package 백준문제;

import java.util.*;

public class BOJ_5555 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		String s=input.next();
		int n=input.nextInt();
		int count=0,k,len=s.length();
		String str;
		
		for(int i=0;i<n;i++) {
			str=input.next();
			str+=str;
			for(int j=0;j<10;j++) {
				for(k=0;k<len;k++) {
					if(str.charAt(j+k)!=s.charAt(k)) break;
				}
				if(k==len) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
		
	}

}
