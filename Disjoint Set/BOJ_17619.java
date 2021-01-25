package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_17619 {
	public static int [] par;
	public static int [][] log;
	public static int [] size;
	
	public static int find(int x) {
		if(par[x]==x) return x;
		else return par[x]=find(par[x]);
	}
	
	public static void union(int x,int y) {
		int a=find(x);
		int b=find(y);
		int temp;
		if(a==b) return;
		if(size[a]>size[b]) {
			temp=a;
			a=b;
			b=temp;
		}
		par[a]=b;
		size[b]+=size[a];
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(st.nextToken());
		int Q=Integer.parseInt(st.nextToken());
		
		par=new int[N+1];
		log=new int[N+1][3];
		size=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			par[i]=i;
			size[i]=1;
			s=br.readLine();
			st=new StringTokenizer(s);
			log[i][1]=Integer.parseInt(st.nextToken());
			log[i][2]=Integer.parseInt(st.nextToken());
			log[i][0]=i;
		}
		
		Arrays.sort(log,new Comparator<int[]>() {
			public int compare(int [] o1, int [] o2) {
				if(o1[1]==o2[1]) return o1[2]-o2[2];
				return o1[1]-o2[1];
			}
		});
		
		for(int i=2;i<=N;i++) {
			if(log[i][1]<=log[i-1][2]) {
				union(log[i][0],log[i-1][0]);
				if(log[i][2]<log[i-1][2]) log[i][2]=log[i-1][2];
			}
		}
		
		int a,b;
		
		for(int i=0;i<Q;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			if(find(a)==find(b)) sb.append("1\n");
			else sb.append("0\n");
		}
		
		System.out.println(sb.toString());
	}

}
