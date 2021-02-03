package 백준문제;

import java.util.*;
import java.io.*;
class LSMR{
	long L;
	long S;
	long M;
	long R;
	
	LSMR(){
		
	}
	
	LSMR(long L,long S,long M,long R){
		this.L=L;
		this.S=S;
		this.M=M;
		this.R=R;
	}
}
public class BOJ_16993 {
	public static LSMR [] segtree;
	public static long MIN=-100000000;
	public static LSMR zero=new LSMR(MIN,MIN,MIN,MIN);
	public static long [] arr;
	
	public static long max(long a,long b) {
		if(a>=b) return a;
		return b;
	}
	public static long max(long a,long b,long c) {
		if(a>=b&&a>=c) return a;
		else if(b>=a&&b>=c) return b;
		return c;
	}
	
	public static LSMR init(int node, int start, int end) {
		LSMR temp,temp1;
		if(start==end) {
			long a=arr[start];
			segtree[node]=new LSMR(a,a,a,a);
		}
		else {
			temp=init(node*2,start,(start+end)/2);
			temp1=init(node*2+1,(start+end)/2+1,end);
			long S=temp.S+temp1.S;
			long L=max(temp.L,temp.S+temp1.L);
			long R=max(temp1.R,temp1.S+temp.R);
			long M=max(temp.M,temp1.M,temp.R+temp1.L);
			segtree[node]=new LSMR(L,S,M,R);
		}
		return segtree[node];
	}
	
	public static LSMR find(int node, int start, int end, int l, int r) {
		LSMR temp,temp1,temp2;
		long L,S,M,R;
		if(start>r||end<l) return zero;
		if(start>=l&&end<=r) return segtree[node];
		int mid=(start+end)/2;
		temp=find(2*node,start,mid,l,r);
		temp1=find(2*node+1,mid+1,end,l,r);
		S=temp.S+temp1.S;
		L=max(temp.L,temp.S+temp1.L);
		R=max(temp1.R,temp1.S+temp.R);
		M=max(temp.M,temp1.M,temp.R+temp1.L);
		temp2=new LSMR(L,S,M,R);
		
		return temp2;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		int N=Integer.parseInt(s);
		
		s=br.readLine();
		st=new StringTokenizer(s);
		
		int h=(int) Math.ceil(Math.log(N)/Math.log(2));
		
		segtree=new LSMR[1<<(h+1)];
		
		arr=new long[N+1];
		
		for(int i=1;i<=N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		init(1,1,N);
		
		s=br.readLine();
		int M=Integer.parseInt(s);
		
		int a,b;
		LSMR temp;
		
		for(int i=0;i<M;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			temp=find(1,1,N,a,b);
			bw.write(temp.M+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}
