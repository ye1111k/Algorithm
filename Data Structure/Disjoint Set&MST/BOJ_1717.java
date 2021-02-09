package 백준문제;
import java.io.*;
import java.util.*;
public class BOJ_1717 {
	public static int [] par;
	
	public static int find(int A) {
		if(par[A]==A) return A;
		return par[A]=find(par[A]);
	}
	
	public static void union(int A,int B) {
		int x=find(A);
		int y=find(B);
		
		if(x==y) return;
		
		if(x<=y) par[y]=x;
		else par[x]=y;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		par=new int[n+1];
		
		for(int i=1;i<=n;i++)
			par[i]=i;
		
		int a,b,c;
		
		for(int i=0;i<m;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			
			if(a==0) 
				union(b,c);
			else {
				if(find(b)!=find(c)) bw.write("NO\n");
				else bw.write("YES\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

}
