package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_2204 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n;
		String [] arr;
		
		while(true) {
			n = Integer.parseInt(br.readLine());

			if(n==0) break;
			
			arr = new String[n];
			
			for(int i=0;i<n;i++)
				arr[i] = br.readLine();
			
			Arrays.sort(arr, new Comparator<String>() {
				public int compare(String o1, String o2) {
					String a = o1.toUpperCase();
					String b = o2.toUpperCase();
					
					return a.compareTo(b);
				}
			});
			
			bw.write(arr[0]+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
