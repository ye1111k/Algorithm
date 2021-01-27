package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040 {
	public static int [] par;
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
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		par=new int[n+1];
		size=new int[n+1];
		size[0]=1;
		
		for(int i=1;i<=n;i++) {
			par[i]=i;
			size[i]=1;
		}
		
		int a,b,answer=0;
		int [][] M=new int[m][2];
		
		for(int i=0;i<m;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			M[i][0]=Integer.parseInt(st.nextToken());
			M[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<m;i++) {
			if(find(M[i][0])==find(M[i][1])) {
				answer=i+1;
				break;
			}
			union(M[i][0],M[i][1]);
		}
		System.out.println(answer);
	}

}
