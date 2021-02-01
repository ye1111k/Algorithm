package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_1849 {
	public static int [] segtree;
	
	public static int init(int node, int start, int end) {
		if(start==end) return segtree[node]=1;
		else return segtree[node]=init(node*2,start,(start+end)/2)+init(node*2+1,(start+end)/2+1,end);
	}
	
	public static int find(int node, int start, int end, int k) {
		segtree[node]--;
		if(start==end) return start;
		if(segtree[2*node]>k)
			return find(node*2,start,(start+end)/2,k);
		else return find(node*2+1,(start+end)/2+1,end,k-segtree[node*2]);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s=br.readLine();
		int N=Integer.parseInt(s);
		
		int [] arr=new int[N+1];
		int [] ans=new int[N+1];
		
		int h=(int) Math.ceil(Math.log(N)/Math.log(2));
		
		segtree=new int[1<<(h+1)];
		init(1,1,N);
		
		for(int i=1;i<=N;i++) {
			s=br.readLine();
			arr[i]=Integer.parseInt(s);
		}
		
		int k;
		
		for(int i=1;i<=N;i++) {
			k=find(1,1,N,arr[i]);
			ans[k]=i;
		}
		
		for(int i=1;i<=N;i++)
			bw.write(ans[i]+"\n");
		
		bw.flush();
		bw.close();
	}

}
