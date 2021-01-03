package 백준문제;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_14888 {
	static int [] A=new int[12];
	static ArrayList<Character> oper=new ArrayList<Character>();
	static ArrayList<Character> uo=new ArrayList<Character>();
	static int N;
	static boolean [] taken=new boolean[12];
	
	static int max=-1000000000;
	static int min=1000000000;
	
	
	static void func(int ans) {
		if(uo.size()==N-1) {
			if(max<ans) max=ans;
			if(min>ans) min=ans;
			return;
		}
		for(int i=0;i<N-1;i++) {
			if(!taken[i]) {
				taken[i]=true;
				uo.add(oper.get(i));
				if(oper.get(i)=='+') func(ans+A[uo.size()]);
				else if(oper.get(i)=='-') func(ans-A[uo.size()]);
				else if(oper.get(i)=='*') func(ans*A[uo.size()]);
				else func(ans/A[uo.size()]);
				taken[i]=false;
				uo.remove(uo.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		N=input.nextInt();
		
		for(int i=0;i<N;i++)
			A[i]=input.nextInt();
		
		int a=input.nextInt();//+
		int b=input.nextInt();//-
		int c=input.nextInt();//*
		int d=input.nextInt();///
		
		for(int i=0;i<a;i++) oper.add('+');
		for(int i=0;i<b;i++) oper.add('-');
		for(int i=0;i<c;i++) oper.add('*');
		for(int i=0;i<d;i++) oper.add('/');
		
		func(A[0]);
		
		System.out.println(max);
		System.out.println(min);
		
	}

}
