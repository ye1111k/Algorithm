package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_19538 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		int N=Integer.parseInt(s);
		
		ArrayList<Integer> [] near=new ArrayList[N+1];
		ArrayList<Integer> [] near1=new ArrayList[N+1];
		LinkedList<int []> queue=new LinkedList<int []>();
		
		int [][] arr=new int[N+1][3];
		
		int x,j;
		
		for(int i=1;i<=N;i++) {
			near[i]=new ArrayList<Integer>();
			near1[i]=new ArrayList<Integer>();
			
			arr[i]=new int[3];
			arr[i][0]=i;
			arr[i][1]=0;
			arr[i][2]=-1;
		}
		
		for(int i=1;i<=N;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			while(st.hasMoreTokens()) {
				x=Integer.parseInt(st.nextToken());
				if(x!=0) {
					near[x].add(i);
					near1[i].add(x);
				}
			}
		}
		
		s=br.readLine();
		int M=Integer.parseInt(s);
		
		s=br.readLine();
		st=new StringTokenizer(s);
		
		int temp;
		
		for(int i=0;i<M;i++) {
			temp=Integer.parseInt(st.nextToken());
			arr[temp][2]=0;
			queue.addLast(arr[temp]);
		}
		
		int [] atemp;
		int [] b;
		int index;
		
		while(!queue.isEmpty()) {
	         atemp=queue.removeFirst();
	         index=atemp[0];
	         if(arr[index][2]>0) continue;
	         if(arr[index][2]==0||(near1[index].size()+1)/2<=atemp[1]) {
	        	 if(arr[index][2]!=0) arr[index][2]=atemp[2];
	        	 for(int i=0;i<near[index].size();i++) {
	        		 temp=near[index].get(i);
	        		 arr[temp][1]++;
	        	 }
	        	 for(int i=0;i<near1[index].size();i++) {
	 	            temp=near1[index].get(i);
	 	            if(arr[temp][2]<0) {
	 	            	b=new int[3];
	 	            	b[0]=temp;
	 	            	b[1]=arr[temp][1];
	 	            	b[2]=atemp[2]+1;
	 	            	queue.addLast(b);
	 	            }
	 	         }
	         }
		}
	         
		for(int i=1;i<=N;i++)
			bw.write(arr[i][2]+" ");
		
		bw.flush();
		bw.close();
	}

}
