package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_17435 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		int m=Integer.parseInt(s);
		int [][] f=new int[m+1][20];
		int [] log2=new int[500001];
		
		for(int i=1;i<=500000;i++)
			log2[i]=(int) (Math.log(i)/Math.log(2));
		
		s=br.readLine();
		st=new StringTokenizer(s);
		for(int i=1;i<=m;i++)
			f[i][0]=Integer.parseInt(st.nextToken());
					
		//전처리
		for(int k=1;k<=19;k++) {
			for(int i=1;i<=m;i++) {
				f[i][k]=f[f[i][k-1]][k-1];
			}
		}
		
		s=br.readLine();
		int Q=Integer.parseInt(s);
		
		int n,x,a,b;
		
		for(int i=0;i<Q;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			n=Integer.parseInt(st.nextToken());
			x=Integer.parseInt(st.nextToken());
			
			while(true) {
				if(n<=0) break;
				a=log2[n];
				n-=(1<<a);
				
				b=f[x][a];
				x=b;
			}
			bw.write(x+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
