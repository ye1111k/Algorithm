package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_11657 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		long [] path=new long[N+1];
		ArrayList<int []> edge=new ArrayList<int []>();
		
		for(int i=1;i<=N;i++) path[i]=987654321;
		path[1]=0;
		
		int [] temp;
		
		for(int i=0;i<M;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			temp=new int[3];
			
			temp[0]=Integer.parseInt(st.nextToken());
			temp[1]=Integer.parseInt(st.nextToken());
			temp[2]=Integer.parseInt(st.nextToken());
			
			edge.add(temp);
		}
		
		long a;
		
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<edge.size();j++) {
				temp=edge.get(j);
				if(path[temp[0]]==987654321) continue;
				a=path[temp[0]]+temp[2];
				if(path[temp[1]]>a) path[temp[1]]=a;
			}
		}
		
		boolean ck=false;
		for(int j=0;j<edge.size();j++) {
			temp=edge.get(j);
			if(path[temp[0]]==987654321) continue;
			a=path[temp[0]]+temp[2];
			if(path[temp[1]]>a) {
				ck=true;
				path[temp[1]]=a;
				break;
			}
		}
		
		if(ck) bw.write(-1+"\n");
		else {
			for(int i=2;i<=N;i++) {
				if(path[i]!=987654321) bw.write(path[i]+"\n");
				else bw.write(-1+"\n");
			}
		}
		bw.flush();
		bw.close();
		
		
	}

}
