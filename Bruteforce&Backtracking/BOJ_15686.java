package 백준문제;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_15686 {
	public static int func(int N,int M,LinkedList<Integer> A,boolean [] taken, int [][] Arr,int [][] chicken,int ck,int [][] house,int ck1,int now) {
		int min=2000000000,temp;
		if(A.size()==M) {
			int ans=dis(A,house,ck1,chicken);
			return ans;
		}
		for(int i=now;i<ck;i++) {
			if(!taken[i]) {
				taken[i]=true;
				A.addLast(i);
				temp=func(N,M,A,taken,Arr,chicken,ck,house,ck1,i+1);
				if(min>temp) min=temp;
				taken[i]=false;
				A.removeLast();
			}
		}
		return min;
	}
	static int dis(LinkedList<Integer> A,int [][] house,int ck1,int [][] chicken) {
		int ans=0,min,temp;
		for(int i=0;i<ck1;i++) {
			min=2000000000;
			for(int j=0;j<A.size();j++){	
				temp=Math.abs(chicken[A.get(j)][0]-house[i][0])+Math.abs(chicken[A.get(j)][1]-house[i][1]);
				if(temp<min) min=temp;
			}
			ans+=min;
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int M=input.nextInt();
		
		int [][] Arr=new int[N][N];
		int [][] chicken=new int[15][2];
		int [][] house=new int[100][2];
		int ck=0,ck1=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				Arr[i][j]=input.nextInt();
				if(Arr[i][j]==2) {
					chicken[ck][0]=i;
					chicken[ck][1]=j;
					ck++;
				}
				if(Arr[i][j]==1) {
					house[ck1][0]=i;
					house[ck1][1]=j;
					ck1++;
				}
			}
		}
		
		LinkedList<Integer> A=new LinkedList<Integer>();
		boolean [] taken=new boolean[15];
		
		int min=func(N,M,A,taken,Arr,chicken,ck,house,ck1,0);
		
		System.out.println(min);
		
	}

}
