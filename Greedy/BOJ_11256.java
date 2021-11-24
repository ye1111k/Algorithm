package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_11256 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int [] arr;
		int J, N, a, b, ans;
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			J = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				arr[i] = a*b;
			}
			Arrays.sort(arr);
			
			ans = 0;
			
			while(true) {
				J-=arr[N-ans-1]; //뒤(가장 큰 값)에서부터 체크
				ans++; //박스 수 더하기
				if(J<=0) break;
			}
			
			System.out.println(ans);
		}
	}

}
