package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_1647 {
	static int [] par;
	static int find(int A) {
		if(par[A]==A) return A;
		else return par[A]=find(par[A]);
	}
	
	static void union(int A,int B) {
		int x=find(A);
		int y=find(B);
		
		if(x<=y) par[y]=x;
		else par[x]=y;
	
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int [][] path=new int[M][3];
		
		for(int i=0;i<M;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			path[i][0]=Integer.parseInt(st.nextToken());
			path[i][1]=Integer.parseInt(st.nextToken());
			path[i][2]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(path,new Comparator<int []>() {
			public int compare(int [] o1,int [] o2) {
				return o1[2]-o2[2];
			}
		});
		
		par=new int[N+1];
		for(int i=1;i<=N;i++)
			par[i]=i;
		
		int a,b,c,cnt=0;
		int max=path[M-1][2];
		
		for(int i=0;i<M;i++) {
			a=path[i][0];
			b=path[i][1];
			c=path[i][2];
			
			if(find(a)!=find(b)) {
				union(a,b);
				cnt+=c;
				max=c;
			}
		}
		
		System.out.println(cnt-max);
		
	}

}
