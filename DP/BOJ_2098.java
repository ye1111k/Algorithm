package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_2098 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		int N=Integer.parseInt(s);
		
		int [][] D=new int[1<<N][N+1];
		int [][] W=new int[N+1][N+1];
		
		for(int i=0;i<N;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			for(int j=0;j<N;j++)
				W[i][j]=Integer.parseInt(st.nextToken());
		}
		
		int temp, min=987654321;
		
		for(int i=0;i<(1<<N);i++) {		
			for(int j=0;j<N;j++)
				D[i][j]=987654321;
		}
		
		D[1][0]=0;
		
		for(int vst=0;vst<(1<<N);vst++) {
			for(int i=0;i<N;i++) {
				if(((vst>>i)&1)==0) continue;
				for(int j=0;j<N;j++) {
					if(W[j][i]!=0&&((vst>>j)&1)==1) {
						temp=D[vst-(1<<i)][j]+W[j][i];
						if(temp<D[vst][i]) D[vst][i]=temp;
					}
				}
			}
		}
		
		min=987654321;
		
		for(int i=0;i<N;i++) {
			if(W[i][0]!=0) {
				if(min>D[(1<<N)-1][i]+W[i][0])
					min=D[(1<<N)-1][i]+W[i][0];
			}
		}
		
		System.out.println(min);
	}

}
