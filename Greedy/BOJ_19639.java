package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_19639 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		LinkedList<int []> queue=new LinkedList<int []>();
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int X=Integer.parseInt(st.nextToken());
		int Y=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int [][] x=new int[X][2];
		int [][] y=new int[Y][2];
		
		for(int i=0;i<X;i++) {
			s=br.readLine();
			x[i][0]=Integer.parseInt(s);
			x[i][1]=i+1;
		}
		
		for(int i=0;i<Y;i++) {
			s=br.readLine();
			y[i][0]=Integer.parseInt(s);
			y[i][1]=i+1;
		}
		
		Arrays.sort(x,new Comparator<int []>(){
			public int compare(int [] o1, int [] o2) {
				return o2[0]-o1[0];
			}
		});

		Arrays.sort(y,new Comparator<int []>(){
			public int compare(int [] o1, int [] o2) {
				return o2[0]-o1[0];
			}
		});
		
		int now=M,nX=0,nY=0;
		int [] temp;
		boolean ck=false;
		
		while(true) {
			if(nY>=Y||nX>=X) break;
				
			if(now<=x[nX][0]) {
				temp=new int[2];
				now+=y[nY][0];
				if(now>M) now=M;
				temp[0]=y[nY][1];
				temp[1]=0;
				nY++;
				queue.addLast(temp);
			}
			else {
				temp=new int[2];
				now-=x[nX][0];
				temp[0]=x[nX][1];
				temp[1]=1;
				nX++;
				queue.addLast(temp);
			}
		}
		if(nX!=X) {
			for(int i=nX;i<X;i++) {
				temp=new int[2];
				temp[0]=x[i][1];
				temp[1]=1;
				now-=x[i][0];
				if(now<=0) ck=true;
				queue.addLast(temp);
			}
		}
		else if(nY!=Y) {
			for(int i=nY;i<Y;i++) {
				temp=new int[2];
				temp[0]=y[i][1];
				temp[1]=0;
				queue.addLast(temp);
			}
		}
		if(ck) bw.write(0+"\n");
		else{
			while(!queue.isEmpty()) {
				temp=queue.removeFirst();
				if(temp[1]==1)
					bw.write("-"+temp[0]+"\n");
				else bw.write(temp[0]+"\n");
			}
		}
			
		bw.flush();
		bw.close();
	}

}
