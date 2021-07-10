package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_9093 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String str,temp;
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			str=br.readLine();
			st=new StringTokenizer(str);
			
			while(st.hasMoreTokens()) {
				temp=st.nextToken();
				for(int j=temp.length();j>0;j--)
					bw.write(temp.charAt(j-1));
				bw.write(" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
