package 백준문제;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13306 {
	public static int [] par;
	public static int [] size;
	
	public static int [] par2;
	
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
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int Q=Integer.parseInt(st.nextToken());
		
		String [] Query=new String[N+Q];
		String [] ans=new String[Q];
		
		par=new int[N+1];
		par2=new int[N+1];
		size=new int[N+1];
		
		par[1]=1;
		par2[1]=1;
		size[1]=1;
		
		for(int i=2;i<=N;i++) {
			s=br.readLine();
			par[i]=i;
			par2[i]=Integer.parseInt(s);
			size[i]=1;
		}
		
		int a,b,c,q=0;
		
		for(int i=0;i<N+Q-1;i++)
			Query[i]=br.readLine();
		
		for(int i=N+Q-2;i>=0;i--) {
			s=Query[i];
			st=new StringTokenizer(s);
			a=Integer.parseInt(st.nextToken());
			if(a==0) {
				b=Integer.parseInt(st.nextToken());
				union(b,par2[b]);
			}
			else {
				b=Integer.parseInt(st.nextToken());
				c=Integer.parseInt(st.nextToken());
				if(find(b)==find(c)) ans[q]="YES\n";
				else ans[q]="NO\n";
				q++;
			}
		}
		
		for(int i=Q-1;i>=0;i--) bw.write(ans[i]);
		bw.flush();
		bw.close();
	}

}
