package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1922 {
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
		StringTokenizer st;
		int sum=0;
		
		int N=Integer.parseInt(s);
		
		s=br.readLine();
		int M=Integer.parseInt(s);
		
		par=new int[N+1];
		size=new int[N+1];
		int [][] arr=new int[M][3];
		
		for(int i=1;i<=N;i++) {
			par[i]=i;
			size[i]=1;
		}
		
		for(int i=0;i<M;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			arr[i][2]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,new Comparator<int[]>() {
			public int compare(int [] o1, int [] o2) {
				return o1[2]-o2[2];
			}
		});
		
		for(int i=0;i<M;i++) {
			if(find(arr[i][0])==find(arr[i][1])) continue;
			union(arr[i][0],arr[i][1]);
			sum+=arr[i][2];
		}
		
		System.out.println(sum);
	}

}
