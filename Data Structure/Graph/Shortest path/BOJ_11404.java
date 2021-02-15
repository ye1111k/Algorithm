package 백준문제;
import java.io.*;
import java.util.*;
public class BOJ_11404 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		int n=Integer.parseInt(s);
		
		s=br.readLine();
		int m=Integer.parseInt(s);
		
		int [][] path=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++)
				if(i!=j) path[i][j]=987654321;
		}
		
		int a,b,c;
		
		for(int i=0;i<m;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			if(c<path[a][b])
				path[a][b]=c;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=n;k++) {
					if(path[j][k]>path[j][i]+path[i][k])
						path[j][k]=path[j][i]+path[i][k];
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
		bw.flush();
		bw.close();
	}

}
