package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_9095 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		int [] arr = new int[12];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i=4;i<=11;i++)
			arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
		
		int n;
		
		for(int t = 0;t < T;t++) {
			n = Integer.parseInt(br.readLine());
			bw.write(arr[n]+"\n");
		}
		bw.flush();
		bw.close();
	}

}
