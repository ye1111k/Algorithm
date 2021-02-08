package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_11585 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s=br.readLine();
		
		int N=Integer.parseInt(s);
		
		s=br.readLine();
		String a=s.replace(" ", "");
		String b=a+a;
		
		s=br.readLine();
		
		int [] f=new int[N];
		
		int j=0,cnt=1;
		
		for(int i=1;i<N;i++) {
			while(j>0&&a.charAt(i)!=a.charAt(j))
				j=f[j-1];
			if(a.charAt(i)==a.charAt(j))
				f[i]=++j;
		}
		
		j=f[N-1];
		
		for(int i=N;i<2*N-1;i++) {
			while(j>0&&b.charAt(i)!=a.charAt(j))
				j=f[j-1];
			if(b.charAt(i)==a.charAt(j)) j++;
			if(j==N) {
				cnt++;
				j=f[j-1];
			}
		}

		int temp=cnt,temp1=N,c;
		
		while(temp1>0) {
			c=temp%temp1;
			temp=temp1;
			temp1=c;
		}
		
		
		System.out.println(cnt/temp+"/"+N/temp);
	}

}
