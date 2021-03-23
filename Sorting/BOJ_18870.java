package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_18870 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		String s=br.readLine();
		st=new StringTokenizer(s);
		int [][] arr=new int[N][3];
		for(int i=0;i<N;i++) {
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=i;
		}
		
		Arrays.sort(arr, new Comparator<int []>() {
			public int compare(int [] o1,int [] o2) {
				return o1[0]-o2[0];
			}
		});
		
		arr[0][2]=0;
		
		int temp=0;
		
		for(int i=1;i<N;i++) {
			if(arr[i][0]>arr[i-1][0]) temp++;
			arr[i][2]=temp;
		}
		
		Arrays.sort(arr, new Comparator<int []>() {
			public int compare(int [] o1,int [] o2) {
				return o1[1]-o2[1];
			}
		});
		
		for(int i=0;i<N;i++)
			bw.write(arr[i][2]+" ");
		
		bw.flush();
		bw.close();
	}

}
