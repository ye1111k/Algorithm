package 백준문제;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2042 {
	public static long [] segtree;
	public static long [] a;

	public static long init(int node, int start, int end) {
		if(start==end) return segtree[node]=a[start];
		else return segtree[node]=init(node*2,start,(start+end)/2)+init(node*2+1,(start+end)/2+1,end);
	}
	
	public static void update(int node, int start, int end, int i, long x) {
		if(i<start||end<i) return;
		segtree[node]-=a[i];
		segtree[node]+=x;
		if(start!=end) {
			update(node*2,start,(start+end)/2,i,x);
			update(node*2+1,(start+end)/2+1,end,i,x);
		}
	}
	
	public static long sum(int node, int start, int end, int l, int r) {
		if(start>r||end<l) return 0;
		if(start>=l&&end<=r) return segtree[node];
		return sum(node*2,start,(start+end)/2,l,r)+sum(node*2+1,(start+end)/2+1,end,l,r);
		
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
		int K=Integer.parseInt(st.nextToken());
		
		int h=(int) Math.ceil(Math.log(N)/Math.log(2));
		
		segtree=new long[1<<(h+1)];
		a=new long[1000100];
		
		for(int i=1;i<=N;i++) {
			s=br.readLine();
			a[i]=Long.parseLong(s);
		}
		
		init(1,1,N);
		
		int b,l,r,index;
		long tempsum,x;
		
		for(int i=0;i<M+K;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			b=Integer.parseInt(st.nextToken());
			if(b==1) {
				index=Integer.parseInt(st.nextToken());
				x=Long.parseLong(st.nextToken());
				update(1,1,N,index,x);
				a[index]=x;
			}
			else {
				l=Integer.parseInt(st.nextToken());
				r=Integer.parseInt(st.nextToken());
				tempsum=sum(1,1,N,l,r);
				System.out.println(tempsum);
			}
		}
	}

}
