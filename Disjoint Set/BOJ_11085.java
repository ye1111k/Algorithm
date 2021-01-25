package 백준문제;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_11085 {
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int p=input.nextInt();
		int w=input.nextInt();
		
		int c=input.nextInt();
		int v=input.nextInt();
		
		int [][] W=new int[w][3];
		par=new int[p];
		size=new int[p];
		for(int i=0;i<p;i++) {
			par[i]=i;
			size[i]=1;
		}
		
		for(int i=0;i<w;i++) {
			W[i][0]=input.nextInt();
			W[i][1]=input.nextInt();
			W[i][2]=input.nextInt();
		}
		
		Arrays.sort(W,new Comparator<int[]>() {
			public int compare(int [] o1, int [] o2) {
				return o2[2]-o1[2];
			}
		});
		
		for(int i=0;i<w;i++) {
			union(W[i][0],W[i][1]);
			if(find(c)==find(v)) {
				System.out.println(W[i][2]);
				break;
			}
		}
	}
}
