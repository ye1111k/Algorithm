package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3079 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		long M=Integer.parseInt(st.nextToken());
		
		long [] T=new long[N];
		
		for(int i=0;i<N;i++) {
			s=br.readLine();
			T[i]=Long.parseLong(s);
		}
		
		Arrays.sort(T);
		
		long low=1;
		long high=T[N-1]*M;
		long mid,answer=high,count;
		
		while(low<=high) {
			mid=(low+high)/2;
			count=0;
			for(int i=0;i<N;i++)
				count+=mid/T[i];
			if(M<=count) {
				answer=mid;
				high=mid-1;
			}
			else low=mid+1;
		}
		
		System.out.println(answer);
	}

}
