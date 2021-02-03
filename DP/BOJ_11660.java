package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_11660 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int [][] pSum=new int[N+1][N+1];
		int [][] a=new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			for(int j=1;j<=N;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
				pSum[i][j]=a[i][j]+pSum[i-1][j]+pSum[i][j-1]-pSum[i-1][j-1];
			}
		}
		int x1,y1,x2,y2;
		for(int i=0;i<M;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			x1=Integer.parseInt(st.nextToken());
			y1=Integer.parseInt(st.nextToken());
			x2=Integer.parseInt(st.nextToken());
			y2=Integer.parseInt(st.nextToken());
			
			System.out.println(pSum[x2][y2]+pSum[x1-1][y1-1]-pSum[x1-1][y2]-pSum[x2][y1-1]);
		}
	}

}
