package 백준문제;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10090 {
	public static int [] arr;
	public static int func(int b, int e) {
		int res=0,ans1=0,ans2=0,ans3=0;
		int mid=(b+e)/2;
		int temp;
		if(e==b) return 0;
		else if(e-b==1) {
			if(arr[e]<arr[b]) return 1;
			return 0;
		}
		else if(e-b==2) {
			if(arr[b]>arr[b+1]&&arr[b+1]>arr[e]) return 3;
			else if(arr[b]<arr[b+1]&&arr[b+1]<arr[e]) return 0;
			else if(arr[b]<arr[e]&&arr[e]<arr[b+1]) return 1;
			else if(arr[b+1]<arr[b]&&arr[b]<arr[e]) return 1;
			else if(arr[e]<arr[b]&&arr[b]<arr[b+1]) return 2;
			else return 2;
		}
		
		ans1=func(b,mid);
		ans2=func(mid+1,e);
			
		Arrays.sort(arr,b,mid+1);
		Arrays.sort(arr,mid+1,e+1);
			
		temp=mid+1;
		int j;
		
		for(int i=b;i<=mid;i++) {
			for(j=temp;j<=e;j++) {
				if(arr[i]<arr[j]) break;
			}
			temp=j;
			ans3+=temp-(mid+1);
		}
		
		res=ans1+ans2+ans3;
		
		return res;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s=br.readLine();
		
		int N=Integer.parseInt(s);
		arr=new int[N];
		
		s=br.readLine();
		st=new StringTokenizer(s);
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		int ans=func(0,N-1);
		
		System.out.println(ans);
	}

}
