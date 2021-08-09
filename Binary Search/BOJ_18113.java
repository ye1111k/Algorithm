package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_18113 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		long [] kimbap = new long[N];
		
		long start = 1;
		long end = 0;
		long sum = 0;
		
		for(int i=0;i<N;i++) {
			kimbap[i] = Integer.parseInt(br.readLine());
			if(kimbap[i]<=K) kimbap[i] = 0;
			if(K<=kimbap[i]) kimbap[i] -= K;
			if(K<=kimbap[i]) kimbap[i] -= K;
			if(end < kimbap[i]) end = kimbap[i];
			
			sum+=kimbap[i];
		}
		
		long mid, temp, P = 1;
		
		if(sum<M) System.out.println(-1);
		else {
			while(end>=start) {
				mid = (start+end)/2;
				temp = 0;
				for(int i=0;i<N;i++)
					temp+=kimbap[i]/mid;
				if(temp>=M) {
					start = mid+1;
					P = mid;
				}
				else end = mid-1;
			}
			
			System.out.println(P);
		}
	}
}
