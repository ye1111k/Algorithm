package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2887 {
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
	
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		int n=Integer.parseInt(s);
		
		int [][] x=new int[n][2];
		int [][] y=new int[n][2];
		int [][] z=new int[n][2];
		par=new int[n];
		
		for(int i=0;i<n;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			par[i]=i;
			
			x[i][0]=i;
			y[i][0]=i;
			z[i][0]=i;
			
			x[i][1]=Integer.parseInt(st.nextToken());
			y[i][1]=Integer.parseInt(st.nextToken());
			z[i][1]=Integer.parseInt(st.nextToken());
		}
		
		//x좌표 정렬
		Arrays.sort(x,new Comparator<int []>() {
			public int compare(int [] o1,int [] o2) {
				return o1[1]-o2[1];
			}
		});
		
		//y좌표 정렬
		Arrays.sort(y,new Comparator<int []>() {
			public int compare(int [] o1,int [] o2) {
				return o1[1]-o2[1];
			}
		});
		
		//z좌표 정렬
		Arrays.sort(z,new Comparator<int []>() {
			public int compare(int [] o1,int [] o2) {
				return o1[1]-o2[1];
			}
		});
		
		int [][] total=new int[3*(n-1)][3];
		int index=0;
		
		//간선의 가중치 저장하기
		
		for(int i=0;i<n-1;i++) {
			total[index][0]=x[i][0];
			total[index][1]=x[i+1][0];
			total[index][2]=x[i+1][1]-x[i][1];
			
			total[index+1][0]=y[i][0];
			total[index+1][1]=y[i+1][0];
			total[index+1][2]=y[i+1][1]-y[i][1];
			
			total[index+2][0]=z[i][0];
			total[index+2][1]=z[i+1][0];
			total[index+2][2]=z[i+1][1]-z[i][1];
			
			index+=3;
		}
		
		//가중치 정렬
		Arrays.sort(total, new Comparator<int []>() {
			public int compare(int [] o1,int [] o2) {
				return o1[2]-o2[2];
			}
		});
		
		
		long cnt=0;
		
		//크루스칼 알고리즘
		for(int i=0;i<3*(n-1);i++) {
			if(find(total[i][0])!=find(total[i][1])) {
				union(total[i][0],total[i][1]);
				cnt+=(int)total[i][2];
			}
		}
		System.out.println(cnt);
	}

}
