import java.util.*;
import java.io.*;

public class CF_1485B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		int [] arr=new int[101010];
		int [] dp=new int[101010];

		s=br.readLine();
		st=new StringTokenizer(s);
		
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		for(int i=2;i<n;i++)
			dp[i]=dp[i-1]+(arr[i]-arr[i-2]-2);
		
		int a,b,ans,temp;
		
		for(int i=0;i<q;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			if(a==b) {
				ans=k-1;
			}
			
			else {
				ans=(arr[a]-2)+(k-arr[b-2]-1);
				
				temp=dp[b-1]-dp[a];
				ans+=temp;
			}
			bw.write(ans+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
