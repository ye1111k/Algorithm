package 백준문제;
import java.io.*;
import java.util.*;
public class BOJ_11780 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		String s=br.readLine();
		int n=Integer.parseInt(s);
		
		s=br.readLine();
		int m=Integer.parseInt(s);
		
		int [][] path=new int[n+1][n+1];
		ArrayList<Integer> [][] path2=new ArrayList[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i!=j) path[i][j]=987654321;
				path2[i][j]=new ArrayList<Integer>();
			}
		}
		
		int d,b,c;
		
		for(int i=0;i<m;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			d=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			
			if(path[d][b]>c) {
				path[d][b]=c;
				path2[d][b]=new ArrayList<Integer>();
				path2[d][b].add(d);
				path2[d][b].add(b);
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=n;k++) {
					if(path[j][k]>path[j][i]+path[i][k]) {
						path[j][k]=path[j][i]+path[i][k];
						path2[j][k]=new ArrayList<Integer>();
						for(int a=0;a<path2[j][i].size()-1;a++)
							path2[j][k].add(path2[j][i].get(a));
						for(int a=0;a<path2[i][k].size();a++)
							path2[j][k].add(path2[i][k].get(a));
					}
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(path[i][j]==987654321) bw.write("0 ");
				else bw.write(path[i][j]+" ");
			}
			bw.write("\n");
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(path[i][j]==987654321||i==j) {
					bw.write("0\n");
					continue;
				}
				bw.write(path2[i][j].size()+" ");
				for(int k=0;k<path2[i][j].size();k++)
					bw.write(path2[i][j].get(k)+" ");
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
