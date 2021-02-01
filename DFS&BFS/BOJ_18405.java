package 백준문제;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_18405 {
	public static int [][] arr;
	public static ArrayList<int []> queue;
	public static int [] dx= {-1,1,0,0};
	public static int [] dy= {0,0,-1,1};
	public static int S;
	public static int N;
	public static int X,Y;
	
	public static void bfs() {
		int [] a;
		int [] b=new int[4];
		
		int nx,ny;
		while(!queue.isEmpty()) {
			a=queue.remove(0);
			if(a[1]==S) return;
			for(int i=0;i<4;i++) {
				b=new int[4];
				nx=a[2]+dx[i];
				ny=a[3]+dy[i];
				if(nx<=0||ny<=0||nx>N||ny>N) continue;
				if(arr[nx][ny]==0) {
					arr[nx][ny]=a[0];
					b[0]=a[0];
					b[1]=a[1]+1;
					b[2]=nx;
					b[3]=ny;
					queue.add(b);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		N=input.nextInt();
		int K=input.nextInt();
		
		arr=new int[220][220];
		queue=new ArrayList<int []>();
		int [] a=new int[10];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j]=input.nextInt();
				if(arr[i][j]!=0) {
					a=new int[4];
					a[0]=arr[i][j];
					a[1]=0;
					a[2]=i;
					a[3]=j;
					queue.add(a);
				}
			}
		}
		
		
		Collections.sort(queue, new Comparator<int []>() {
			public int compare(int [] o1,int [] o2) {
				return o1[0]-o2[0];
			}
		});
		
		S=input.nextInt();
		X=input.nextInt();
		Y=input.nextInt();
		
		bfs();
		
		System.out.println(arr[X][Y]);
		
	}

}
