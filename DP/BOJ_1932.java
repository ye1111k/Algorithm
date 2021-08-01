package 백준문제;
import java.util.*;
import java.io.*;

public class BOJ_1932 {
	public static int max(int a, int b) {
		if(a>=b) return a;
		return b;
	}
 	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N=Integer.parseInt(br.readLine());
		
		int [][] arr = new int[N][N];
		arr[0][0] = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				if(j==0) arr[i][0] = Integer.parseInt(st.nextToken()) + arr[i-1][0]; //제일 왼쪽 원소 - 오른쪽
				else if(j==i) arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i-1][j-1]; //중간 원소들 - 왼쪽 혹은 오른쪽 중에 더 큰 값 더하기
				else arr[i][j] = Integer.parseInt(st.nextToken()) + max(arr[i-1][j-1],arr[i-1][j]); //제일 오른쪽 원소 - 왼쪽 
			}
		}
		
		int max = 0;
		for(int i=0;i<N;i++)
			if(max < arr[N-1][i]) max = arr[N-1][i];
			
		System.out.println(max);
	}

}
