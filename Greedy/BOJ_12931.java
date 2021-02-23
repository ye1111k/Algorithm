package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_12931 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		int N=Integer.parseInt(s);
		
		int [] B=new int[N];
		
		s=br.readLine();
		st=new StringTokenizer(s);
		
		for(int i=0;i<N;i++)
			B[i]=Integer.parseInt(st.nextToken());
		
		int count=0;
		
		boolean ck=false,even=false;
		
		while(true) {
			ck=false;
			even=false;
			for(int i=0;i<N;i++) {
				if(B[i]!=0) ck=true;
				if(B[i]%2==1) even=true;
			}
			if(!ck) break;
			for(int i=0;i<N;i++) {
				if(B[i]%2==1) {
					B[i]--;
					count++;
				}
				if(!even) B[i]/=2;
			}
			if(!even) count++;
		}
		System.out.println(count);
	}
}
