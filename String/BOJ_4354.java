package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_4354 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s,s1;
		StringBuilder sb=new StringBuilder();
		int [] f;
		int j,cnt,l;
		
		while(true) {
			s=br.readLine();
			if(s.equals(".")) break;
			
			f=new int[s.length()];
			s1=s+s;
			cnt=1;
			l=s.length();
			
			j=0;
			for(int i=1;i<l;i++) {
				while(j>0&&s.charAt(i)!=s.charAt(j))
					j=f[j-1];
				if(s.charAt(i)==s.charAt(j))
					f[i]=++j;
			}
			
			j=f[l-1];
			
			for(int i=l;i<2*l-1;i++) {
				while(j>0&&s1.charAt(i)!=s.charAt(j))
					j=f[j-1];
				if(s1.charAt(i)==s.charAt(j)) j++;
				if(j==l) {
					cnt++;
					j=f[j-1];
				}
			}
			sb.append(cnt+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
