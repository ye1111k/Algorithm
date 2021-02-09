package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_19646 {
	public static int [] segtree;
	public static int [] w;
	public static int [] p;
	
	public static int init(int node, int start, int end) {
		if(start==end) return segtree[node]=w[start];
		else return segtree[node]=init(node*2,start,(start+end)/2)+init(node*2+1,(start+end)/2+1,end);
	}
	
	public static int find(int node, int start, int end, int W) {
		if(start==end) {
			segtree[node]=0;
			return start;
		}
		int temp;
		if(segtree[2*node]>=W) {
			temp=find(node*2,start,(start+end)/2,W);
			segtree[node]-=w[temp];
			return temp;
		}
		else {
			temp=find(node*2+1,(start+end)/2+1,end,W-segtree[node*2]);
			segtree[node]-=w[temp];
			return temp;
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		String s1;
		StringTokenizer st1;
		int N=Integer.parseInt(s);
		
		w=new int[N+1];
		p=new int[N+1];
		int h=(int) Math.ceil(Math.log(N)/Math.log(2));
		
		segtree=new int[1<<(h+1)];
		
		s=br.readLine();
		st=new StringTokenizer(s);
		
		s1=br.readLine();
		st1=new StringTokenizer(s1);
		
		for(int i=1;i<=N;i++) {
			w[i]=Integer.parseInt(st.nextToken());
			p[i]=Integer.parseInt(st1.nextToken());
		}
		
		init(1,1,N);
		
		for(int i=1;i<=N;i++) {
			bw.write(find(1,1,N,p[i])+" ");
		}
		bw.flush();
		bw.close();
		
	}

}
