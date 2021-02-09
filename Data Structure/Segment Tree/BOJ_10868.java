package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10868 {
	public static long [] segtree;
	public static long [] a;
	public static long MAX=1000000001;
	
	public static long min(long a, long b) {
		if(a<=b) return a;
		return b;
	}

	public static long init(int node, int start, int end) {
		if(start==end) return segtree[node]=a[start];
		else return segtree[node]=min(init(node*2,start,(start+end)/2),init(node*2+1,(start+end)/2+1,end));
	}
	
	public static long findMin(int node, int start, int end, int l, int r) {
		if(start>r||end<l) return MAX;
		if(start>=l&&end<=r) return segtree[node];
		return min(findMin(node*2,start,(start+end)/2,l,r),findMin(node*2+1,(start+end)/2+1,end,l,r));
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int h=(int) Math.ceil(Math.log(N)/Math.log(2));
		
		segtree=new long[1<<(h+1)];
		a=new long[1000100];
		
		for(int i=1;i<=N;i++) {
			s=br.readLine();
			a[i]=Long.parseLong(s);
		}
		
		init(1,1,N);
		int a,b;
		
		for(int i=0;i<M;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			System.out.println(findMin(1,1,N,a,b));
		}
		
	}

}
