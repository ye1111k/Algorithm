package 백준문제;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_10971 {
	static int func(int [][] W,LinkedList<Integer> path,boolean [] taken,int currentLength,int N) {
		if(path.size()==N) {
			if(W[path.getLast()][0]!=0) return currentLength+W[path.getLast()][0];
			else return 2000000000;
		}
		int ret=2000000000;
		
		for(int i=1;i<N;i++) {
			if(taken[i]) continue;
			int here=path.getLast();
			if(W[here][i]==0) continue;
			path.addLast(i);
			taken[i]=true;
			int cand=func(W,path,taken,currentLength+W[here][i],N);
			if(ret>cand) ret=cand;
			taken[i]=false;
			path.removeLast();
		}
		
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int [][] W=new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				W[i][j]=input.nextInt();
		}
		
		boolean [] taken=new boolean[N];
		LinkedList<Integer> path=new LinkedList<Integer>();
		path.addLast(0);
		taken[0]=true;
		
		int ans=func(W,path,taken,0,N);
		
		System.out.println(ans);
	}

}
