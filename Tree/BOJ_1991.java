package 백준문제;

import java.util.*;

public class BOJ_1991 {
	public static String [][] tree;
	public static int N;
	public static void pre(String s) {
		int a=s.charAt(0)-'A';
		System.out.print(s);
		if(!tree[a][1].equals("."))
			pre(tree[a][1]);
		if(!tree[a][2].equals("."))
			pre(tree[a][2]);
	}
	public static void in(String s) {
		int a=s.charAt(0)-'A';
		if(!tree[a][1].equals("."))
			in(tree[a][1]);
		System.out.print(s);
		if(!tree[a][2].equals("."))
			in(tree[a][2]);
	}
	public static void post(String s) {
		int a=s.charAt(0)-'A';
		if(!tree[a][1].equals("."))
			post(tree[a][1]);
		if(!tree[a][2].equals("."))
			post(tree[a][2]);
		System.out.print(s);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		StringTokenizer st;
		String s;
		int a;
		
		N=input.nextInt();
		
		tree=new String[N][3];
		
		for(int i=0;i<N;i++) {
			s=input.next();
			a=s.charAt(0)-'A';
			tree[a][0]=s;
			tree[a][1]=input.next();
			tree[a][2]=input.next();
		}
		pre("A");
		System.out.println();
		in("A");
		System.out.println();
		post("A");
		
	}

}
