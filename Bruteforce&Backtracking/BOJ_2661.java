package 백준문제;

import java.util.Scanner;

public class BOJ_2661 {
	public static String s;
	public static int N;
	public static void func() {
		if(s.length()==N) {
			System.out.println(s);
			System.exit(0);
		}
		
		boolean ck;
		String s1,s2;
		
		for(int i=1;i<=3;i++) {
			ck=true;
			for(int j=1;j<=(s.length()+1)/2;j++) {
				s1=s.substring(s.length()-j+1, s.length())+Integer.toString(i);
				s2=s.substring(s.length()-2*j+1,s.length()-j+1);
				//System.out.println(s1+" "+s2);
				if(s1.equals(s2)) ck=false;
			}
			if(ck) {
				s+=Integer.toString(i);
				func();
				s=s.substring(0,s.length()-1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		N=input.nextInt();
		
		s="";
		
		if(N==1) System.out.println(1);
		else if(N==2) System.out.println(12);
		else {
			s="12";
			func();
		}
	}

}
