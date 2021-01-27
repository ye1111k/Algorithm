package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16401 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s=br.readLine();
		st=new StringTokenizer(s);
		
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		int [] L=new int[N];
		
		s=br.readLine();
		st=new StringTokenizer(s);
		for(int i=0;i<N;i++)
			L[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(L);
		
		int low=1;
		int high=L[N-1];
		int temp,mid,ans=0;
		
		while(low<=high) {
			temp=0;
			mid=(low+high)/2;
			for(int i=0;i<N;i++)
				temp+=L[i]/mid;
			if(M<=temp) {
				low=mid+1;
				ans=mid;
			}
			else high=mid-1;
		}
		
		System.out.println(ans);
	}

}
