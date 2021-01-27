package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		String s = br.readLine();
		int N=Integer.parseInt(s);
		
		int [] arr=new int[10001];
		int a;
	
		for(int i=0;i<N;i++) {
			s=br.readLine();
			a=Integer.parseInt(s);
			arr[a]++;
		}
		
		for(int i=1;i<=10000;i++) {
			for(int j=0;j<arr[i];j++)
				sb.append(i+"\n");
		}
		System.out.println(sb.toString());
	}

}
