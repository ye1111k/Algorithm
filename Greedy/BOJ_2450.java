package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_2450 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [][] Case = {{1,2,3}, {1,3,2},
						{2,1,3}, {2,3,1},
						{3,1,2}, {3,2,1}};
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[N];
		
		int [] shape = new int[4];
		int [][] a;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			shape[arr[i]]++;
		}
		
		int min = 987654321;
		int temp;
		
		for(int i=0;i<6;i++) {
			a = new int[4][4];
			
			for(int j=0;j<shape[Case[i][0]];j++)
				if(arr[j]!=Case[i][0]) a[Case[i][0]][arr[j]]++;
			
			for(int j=shape[Case[i][0]];j<shape[Case[i][1]]+shape[Case[i][0]];j++)
				if(arr[j]!=Case[i][1]) a[Case[i][1]][arr[j]]++;;
			
			for(int j=shape[Case[i][0]]+shape[Case[i][1]];j<N;j++)
				if(arr[j]!=Case[i][2]) a[Case[i][2]][arr[j]]++;
			
			temp = (a[2][3]>a[3][2])?a[2][3] + a[1][2] + a[1][3]:a[3][2] + a[1][2] + a[1][3];
			
			if(temp<min) min = temp;
		}
		
		System.out.println(min);
	}

}
