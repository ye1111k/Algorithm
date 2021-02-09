package 백준문제;
import java.util.*;
import java.io.*;
public class BOJ_1197 {
	public static int [] par;
	
	public static int find(int A) {
		if(par[A]==A) return A;
		else return par[A]=find(par[A]);
	}
	public static void union(int A,int B) {
		int x=find(A);
		int y=find(B);
		if(x==y) return;
		
		if(x<=y) par[B]=x;
		else par[A]=y;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		
		LinkedList<int []> edge=new LinkedList<int []>();
		par=new int[V+1];
		int [] temp;
		int a,b,e=0;
		
		
		for(int i=1;i<=V;i++)
			par[i]=i;
		
		for(int i=0;i<E;i++) {
			temp=new int[3];
			s=br.readLine();
			st=new StringTokenizer(s);
			temp[0]=Integer.parseInt(st.nextToken());
			temp[1]=Integer.parseInt(st.nextToken());
			temp[2]=Integer.parseInt(st.nextToken());
			edge.addLast(temp);
		}
		
		Collections.sort(edge,new Comparator<int []>(){
			public int compare(int [] o1,int [] o2) {
				return o1[2]-o2[2];
			}
		});
		
		for(int i=0;i<E;i++) {
			temp=edge.removeFirst();
			a=find(temp[0]);
			b=find(temp[1]);
			if(a!=b) {
				e+=temp[2];
				union(a,b);
			}
		}
		System.out.println(e);
	}

}
