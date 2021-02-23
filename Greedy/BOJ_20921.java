package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_20921 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		boolean [] visited=new boolean[N+1];
		int [] remain=new int[N+1];
		for(int i=2;i<=N;i++)
			remain[i]=i-1;
		
		int max=N;
		int min=1;
		
		while(K>0) {
			for(int i=N;i>=1;i--) {
				if(K>=remain[i]&&!visited[i]) {
					bw.write(i+" ");
					for(int j=i+1;j<=N;j++)
						remain[j]--;
					visited[i]=true;
					K-=remain[i];
				}
			}
		}
		for(int i=1;i<=N;i++)
			if(!visited[i]) bw.write(i+" ");
		bw.write("\n");
		bw.flush();
		bw.close();
	}

}
