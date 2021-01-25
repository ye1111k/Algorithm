package 이취코;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_28 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		StringTokenizer st;
		
		int N=Integer.parseInt(s);
		
		s=br.readLine();
		st=new StringTokenizer(s);
		int [] arr=new int[N];
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		int low=0;
		int high=N-1;
		int mid,answer=-1;
		
		while(low<=high) {
			mid=(low+high)/2;
			if(mid==arr[mid]) {
				answer=mid;
				break;
			}
			else if(mid<arr[mid]) high=mid-1;
			else low=mid+1;
		}
		System.out.println(answer);
	}

}
