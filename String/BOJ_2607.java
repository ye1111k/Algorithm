package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_2607 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String [] s = new String[n];
		
		for(int i=0;i<n;i++)
			s[i] = br.readLine();
	
		int [] character = new int[26];
		int [] character2;
		
		for(int i=0;i<s[0].length();i++)
			character[s[0].charAt(i)-'A']++;
		
		int countM,countP,answer=0; //countM은 character2쪽에서 하나 더 많은 경우, countP는 character쪽에서 하나 더 많은 경우
		boolean ck;
		
		for(int i=1;i<n;i++){
			countP = 0;
			countM = 0;
			ck = false;
			character2 = new int[26];
			
			for(int j=0;j<s[i].length();j++){
				character2[s[i].charAt(j)-'A']++;
			}
			
			for(int j=0;j<26;j++){
				if(character[j]-character2[j]==1) countP++;
				if(character2[j]-character[j]==1) countM++;
				if(Math.abs(character[j]-character2[j])>=2) ck = true;
			}
			
			if(!ck&&countM==1&&countP==1) answer++; //한 단어에서 한 문자를 바꾸는 경우
			if(!ck&&countM==1&&countP==0) answer++; //character 문자열에 한 문자 추가하는 경우
			if(!ck&&countM==0&&countP==1) answer++; //character2 문자열에 한 문자 추가하는 경우
			if(!ck&&countM==0&&countP==0) answer++; //이미 같은 구성의 문자열인 경우
		}
		
		System.out.println(answer);
	}

}
