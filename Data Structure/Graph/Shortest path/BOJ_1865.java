package 백준문제;
import java.io.*;
import java.util.*;
public class BOJ_1865 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		int T=Integer.parseInt(s);
		
		int N,M,W;
		
		long a;
		
		long [] path;
		ArrayList<int []> edge;
		int [] temp;
		int [] temp1;
		boolean ck;
		
		for(int t=0;t<T;t++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			
			path=new long[N+1];
			edge=new ArrayList<int []>();
			ck=false;
			for(int i=2;i<=N;i++)
				path[i]=987654321;
			for(int i=0;i<M;i++) {
				s=br.readLine();
				st=new StringTokenizer(s);
				
				temp=new int[3];
				temp[0]=Integer.parseInt(st.nextToken());
				temp[1]=Integer.parseInt(st.nextToken());
				temp[2]=Integer.parseInt(st.nextToken());
				temp1=new int[3];
				temp1[0]=temp[1];
				temp1[1]=temp[0];
				temp1[2]=temp[2];
				
				edge.add(temp);
				edge.add(temp1);
			}
			for(int i=0;i<W;i++) {
				s=br.readLine();
				st=new StringTokenizer(s);
				
				temp=new int[3];
				temp[0]=Integer.parseInt(st.nextToken());
				temp[1]=Integer.parseInt(st.nextToken());
				temp[2]=(-1)*Integer.parseInt(st.nextToken());
				edge.add(temp);
			}
			
			for(int i=0;i<N;i++) {
				if(ck) break;
				for(int j=0;j<edge.size();j++) {
					temp=edge.get(j);
					a=path[temp[0]]+temp[2];
					if(path[temp[1]]>a) {
						path[temp[1]]=a;
						if(i==N-1) {
							ck=true;
							break;
						}
					}
				}
			}
			if(ck) bw.write("YES\n");
			else bw.write("NO\n");
		}
		bw.flush();
		bw.close();
	}

}
