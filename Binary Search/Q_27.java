package 이취코;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_27 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		
		s=br.readLine();
		st=new StringTokenizer(s);
		
		int [] arr=new int[N+2];
		for(int i=1;i<=N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		int low=1;
		int high=N;
		int start=2;
		int end=0;
		int mid;
		
		while(low<=high) {
			mid=(low+high)/2;
			if(arr[mid]==x&&arr[mid-1]!=x) {
				start=mid;
				break;
			}
			else if((arr[mid]==x&&arr[mid-1]==x)||arr[mid]>x) high=mid-1;
			else low=mid+1;
		}
		
		low=1;
		high=N;
		while(low<=high) {
			mid=(low+high)/2;
			if(arr[mid]==x&&arr[mid+1]!=x) {
				end=mid;
				break;
			}
			else if((arr[mid]==x&&arr[mid+1]==x)||arr[mid]<x) low=mid+1;
			else high=mid-1;
		}
		
		System.out.println(end-start+1);
		
	}

}
