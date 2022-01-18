package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_4583 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1, s2;
		
		char [] arr = new char[26];
		
		for(int i=0;i<26;i++)
			arr[i] = '0';
		
		arr[1] = 'd';
		arr[3] = 'b';
		arr[8] = 'i';
		arr[14] = 'o';
		arr[15] = 'q';
		arr[16] = 'p';
		arr[21] = 'v';
		arr[22] = 'w';
		arr[23] = 'x';
		
		while(true) {
			s1 = br.readLine();
			if(s1.contentEquals("#")) break;
			
			s2 = "";
			
			for(int i=s1.length()-1;i>=0;i--) {
				if(arr[s1.charAt(i)-'a']=='0') {
					s2 = "INVALID";
					break;
				}
				s2 += arr[s1.charAt(i)-'a'];
			}
			
			bw.write(s2+"\n");
		}
		bw.flush();
		bw.close();
	}

}
