package 백준문제;

import java.util.*;

public class BOJ_15666 {
	static int N,M;
	static ArrayList<Integer> A;
	static LinkedList<Integer> seq=new LinkedList<Integer>();
	
	static void backtracking(int n,int r) {
		if(r==M) {
			for(int i=0;i<M;i++)
				System.out.print(seq.get(i)+" ");
			System.out.println();
			return;
		}
		for(int i=n;i<A.size();i++) {
			seq.addLast(A.get(i));
			backtracking(i,r+1);
			seq.removeLast();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		N=input.nextInt();
		M=input.nextInt();
		
		A=new ArrayList<Integer>();
		
		int temp;
		
		for(int i=0;i<N;i++) {
			temp=input.nextInt();
			if(!A.contains(temp))
				A.add(temp);
		}
			
		Collections.sort(A);
		
		backtracking(0,0);
	}

}
