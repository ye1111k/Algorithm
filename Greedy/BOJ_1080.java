package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_1080 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		boolean [][] A=new boolean[N][M];
		boolean [][] B=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			s=br.readLine();
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)=='0')
					A[i][j]=false;
				else A[i][j]=true;
			}
		}
		
		for(int i=0;i<N;i++) {
			s=br.readLine();
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)=='0')
					B[i][j]=false;
				else B[i][j]=true;
			}
		}
		
		int count=0;
		
		for(int i=0;i<=N-3;i++) {
			for(int j=0;j<=M-3;j++) {
				if(A[i][j]!=B[i][j]) {
					count++;
					for(int k=0;k<3;k++) {
						for(int h=0;h<3;h++) {
							A[i+k][j+h]=!A[i+k][j+h];
						}
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				if(A[i][j]!=B[i][j]) count=-1;
		}
		
		System.out.println(count);
		
	}

}
