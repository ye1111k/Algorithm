package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_1259 {
	
	public static ArrayList<String> solution(ArrayList<String> str) {
		int N = str.size();
		ArrayList<String> answer = new ArrayList<String>();
		
		String temp;
		boolean ck;
		
		for(int i=0;i<N;i++) {
			temp = str.get(i);
			ck = true;
			for(int j=0;j<temp.length()/2;j++) {
				if(temp.charAt(j)!=temp.charAt(temp.length()-j-1)) {
					ck = false;
					break;
				}
			}
			if(ck) answer.add("yes");
			else answer.add("no");
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<String> str = new ArrayList<String>();
		
		String temp;
		
		while(true) {
			temp = br.readLine();
			if(temp.contentEquals("0")) break;
			str.add(temp);
		}
		
		ArrayList<String> answer = solution(str);
		
		for(int i=0;i<answer.size();i++)
			bw.write(answer.get(i)+"\n");
		
		bw.flush();
		bw.close();
	}	

}
