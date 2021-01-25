package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
	public static int [] answer;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		
		int [] arr=new int[N];
		
		for(int i=0;i<N;i++) {
			s=br.readLine();
			arr[i]=Integer.parseInt(s);
		}
		
		answer=new int[C];
		
		Arrays.sort(arr);
		
		int low=1;
		int high=arr[N-1]-arr[0];
		int mid,count,temp,answer=high-low;
		
		while(low<=high) {
			count=1;
			mid=(low+high)/2;
			
			temp=arr[0]; //공유기는 첫 번째 집부터 설치
			
			for(int i=1;i<N;i++) {
				if(arr[i]>=temp+mid) {
					count++;
					temp=arr[i];
				}
			}
			
			if(count>=C) {
				low=mid+1;
				answer=mid;
			}
			else high=mid-1;
			
		}
		System.out.println(answer);
			
	}

}
