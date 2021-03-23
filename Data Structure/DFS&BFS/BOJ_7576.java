package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_7576 {
	public static int Solution(int [][] arr, int n, int m) {
		int answer=0;
		int [] dx= {-1,1,0,0};
		int [] dy= {0,0,-1,1};
		
		int x,y,tmpx,tmpy;
		
		LinkedList<int []> queue=new LinkedList<int []>();
		
		int [] temp;
		int [] temp1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1) {
					temp=new int[3];
					temp[0]=i;
					temp[1]=j;
					queue.addLast(temp);
				}
			}
		}
		
		while(!queue.isEmpty()) {
			temp=queue.removeFirst();
			x=temp[0];
			y=temp[1];
			for(int i=0;i<4;i++) {
				tmpx=x+dx[i];
				tmpy=y+dy[i];
				if(tmpx>=n||tmpy>=m||tmpx<0||tmpy<0) continue;
				if(arr[tmpx][tmpy]==0) {
					arr[tmpx][tmpy]=1;
					temp1=new int[3];
					temp1[0]=tmpx;
					temp1[1]=tmpy;
					temp1[2]=temp[2]+1;
					if(temp1[2]>answer) answer=temp1[2];
					queue.addLast(temp1);
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) answer=-1;
			}
		}
		
		return answer;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		
		int [][] arr=new int[N][M];
		
		for(int i=0;i<N;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			for(int j=0;j<M;j++)
				arr[i][j]=Integer.parseInt(st.nextToken());
		}
		
		bw.write(Solution(arr,N,M)+"\n");
		bw.flush();
		bw.close();
	}
}
