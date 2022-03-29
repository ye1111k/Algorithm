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
		arr[1] = 1; //1이 되는 경우의 수 - 1 총 한 가지
		arr[2] = 2; //2가 되는 경우의 수  - 1+1,2 총 두 가지
		arr[3] = 4; //3이 되는 경우의 수 - 1+1+1, 1+2, 2+1, 3 총 네 가지
		for(int i=4;i<=11;i++) //조건이 11까지밖에 없으니까 미리 다 구해놓고 시작
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
