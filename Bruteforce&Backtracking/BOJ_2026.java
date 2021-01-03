package 백준문제;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2026 {
	static boolean [][] friends=new boolean[901][901];
	static boolean [] taken=new boolean[901];
	static LinkedList<Short> ans=new LinkedList<Short>();
	static short [] arr=new short[901];
	
	static short N,F,K;
	
	static void func(short a) {
		if(ans.size()==K) return;
		if(a>N) return;
		short temp;
		boolean ck=false;
		for(short i=a;i<=N;i++) {
			ck=true;
			for(int j=0;j<ans.size();j++) {
				temp=ans.get(j);
				if(friends[temp][i]==false) {
					ck=false;
					break;
				}
			}
			if(ck) {
				ans.addLast(i);
				func((short)(i+1));
				if(ans.size()==K) return;
				ans.removeLast();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		K=input.nextShort();
		N=input.nextShort();
		F=input.nextShort();
		
		int a,b;
		
		for(int i=0;i<F;i++) {
			a=input.nextInt();
			b=input.nextInt();
			friends[a][b]=true;
			friends[b][a]=true;
			arr[a]++;
			arr[b]++;
		}
		for(short i=1;i<=N;i++) {
			if(arr[i]<K-1) continue;
			ans.addLast(i);
			if(K==ans.size()) break;
			func((short)(i+1));
			if(K==ans.size()) break;
			ans.removeLast();
		}
		if(ans.size()==K)
			for(int i=0;i<K;i++) System.out.println(ans.get(i));
		else System.out.println(-1);
	}

}
