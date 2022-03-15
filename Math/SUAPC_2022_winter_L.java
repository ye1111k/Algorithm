package 백준문제;

import java.util.*;
import java.io.*;

public class SUAPC_2022_winter_L {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		long n;
		
		for(int i=0;i<T;i++) {
			n = Long.parseLong(br.readLine());
			
			if(n%10==0) bw.write(1+"\n");
			else bw.write(0+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
