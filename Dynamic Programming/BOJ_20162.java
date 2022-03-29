package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_20162 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] desert = new int[N];
		int [] arr = new int[N];
		
		for(int i=0;i<N;i++)
			desert[i] = Integer.parseInt(br.readLine());
		
		int max = 0;
		for(int i=0;i<N;i++) {
			arr[i] = desert[i];
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					if(arr[i]+desert[j]>desert[i])
						desert[i] = arr[i]+desert[j];
				}
			}
			if(desert[i]>max) max = desert[i];
		}
		
		System.out.println(max);
	}

}
