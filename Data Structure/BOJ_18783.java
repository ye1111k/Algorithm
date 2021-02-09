package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ_18783 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int [][] f=new int[N+1][31];
		int [] arr=new int[N+1];
		
		for(int i=1;i<=N;i++) arr[i]=i;
		
		int a,b,temp;
		
		for(int i=0;i<M;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			for(int j=0;j<(b-a+1)/2;j++) {
				temp=arr[a+j];
				arr[a+j]=arr[b-j];
				arr[b-j]=temp;
			}
		}
		
		for(int i=1;i<=N;i++)
			f[i][0]=arr[i];
		
		for(int k=1;k<=30;k++) {
			for(int i=1;i<=N;i++) {
				f[i][k]=f[f[i][k-1]][k-1];
			}
		}
		
		int [] answer=new int[N+1];
		for(int i=1;i<=N;i++)
			answer[i]=i;
		
		while(true) {
			if(K==0) {
				for(int i=1;i<=N;i++)
					System.out.println(answer[i]);
				break;
			}
			a=(int) (Math.log(K)/Math.log(2));
			K-=(1<<a);
			
			for(int i=1;i<=N;i++) {
				temp=f[answer[i]][a];
				answer[i]=temp;
			}
		}
	}

}
