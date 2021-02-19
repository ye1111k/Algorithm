package 백준문제;

import java.util.*;

public class BOJ_14490 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		String s=input.next();
		StringTokenizer st=new StringTokenizer(s,":");
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int N=n,M=m,temp;
		if(N>M) {
			while(M!=0) {
				temp=N%M;
				N=M;
				M=temp;
			}
			
			System.out.println(n/N+":"+m/N);
		}
		else {
			while(N!=0) {
				temp=M%N;
				M=N;
				N=temp;
			}
			
			System.out.println(n/M+":"+m/M);
		}
	}

}
