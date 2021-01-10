package 백준문제;

import java.util.Scanner;

public class BOJ_2847 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		int [] level=new int[N];
		
		for(int i=0;i<N;i++)
			level[i]=input.nextInt();
		int ans=0,gap;
		for(int i=N-1;i>0;i--) {
			if(level[i-1]>=level[i]) {
				gap=level[i-1]-level[i]+1;
				ans+=gap;
				level[i-1]-=gap;
				
			}
		}
		System.out.println(ans);
		
	}

}
