package 백준문제;

import java.util.*;
import java.io.*;

public class SUAPC_2022_winter_C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] A = new int[N];
		int [] B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		long a=0,b=0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			a+=A[i];
			if(st.nextToken().contentEquals("0")) b+=A[i];
		}
		
		System.out.println(a);
		System.out.println(b);
		
	
		
	}

}
