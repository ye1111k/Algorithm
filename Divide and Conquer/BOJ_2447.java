package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_2447 {

	public static String [] star(int n) {
		String [] a=new String[n];
		String [] b=new String[n/3];
		
		if(n==3) {
			a[0]="***";
			a[1]="* *";
			a[2]="***";
		}		
		else {
			for(int i=0;i<n;i++)
				a[i]="";

			b=star(n/3);
			for(int i=0;i<n/3;i++) {
				a[i]=b[i]+b[i]+b[i];
				a[n-i-1]=b[i]+b[i]+b[i];
				a[i+n/3]=b[i];
				for(int j=0;j<n/3;j++)
					a[i+n/3]+=" ";
				a[i+n/3]+=b[i];
			}
		}
		return a;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String s=br.readLine();
		
		int n=Integer.parseInt(s);
		
		String [] a=new String[n];
		
		a=star(n);
		
		for(int i=0;i<n;i++) { 
			bw.write(a[i]);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
