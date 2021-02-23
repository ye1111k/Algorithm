package 백준문제;

import java.util.Scanner;

public class BOJ_1439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		String s=input.next();
		int count=0;
		
		boolean ck=false; //false: 이전 문자가 첫번째 문자와 같음, true: 이전 문자가 첫번째 문자와 다름
		
		if(s.charAt(0)==s.charAt(s.length()-1)&&s.charAt(0)=='1') {//양끝이 1인 경우, 0 구간의 개수 세기
			for(int i=0;i<s.length();i++) {
				if(ck) {
					if(s.charAt(i)=='1')
						ck=false;
				}
				else {
					if(s.charAt(i)=='0') {
						ck=true;
						count++;
					}
				}
			}
		}
		else {//아닌 경우 1구간의 개수 세기
			for(int i=0;i<s.length();i++) {
				if(ck) {
					if(s.charAt(i)=='0')
						ck=false;
				}
				else {
					if(s.charAt(i)=='1') {
						ck=true;
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

}
