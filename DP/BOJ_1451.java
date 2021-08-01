package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_1451 {
	public static long cal1(int r,int c, int N, int M, int [][] area) { //r!=0&&c!=0인 경우(네 구역으로 나눠지는 경우)
		long max = 0;
		long temp;
		
		//area1     area2
		//     (r,c)
		//area3     area4
		
		//각 구역의 넓이 저장
		int area1 = area[r][c];
		int area2 = area[r][M] - area[r][c];
		int area3 = area[N][c] - area[r][c];
		int area4 = area[N][M] - area[N][c] - area[r][M] + area[r][c];
		
		//1번 경우 - 1,2,3+4
		temp = area1 * area2 * (area3 + area4);
		if(max < temp) max = temp;
		
		//2번 경우 - 1,3,2+4
		temp = area1 * area3 * (area2 + area4);
		if(max < temp) max = temp;
		
		//3번 경우 - 2,4,1+3
		temp = area2 * area4 * (area1 + area3);
		if(max < temp) max = temp;
	
		//4번 경우 - 3,4,1+2
		temp = area3 * area4 * (area1 + area2);
		if(max < temp) max = temp;
		
		return max;
	}
	
	public static long cal2(int r1, int r2, int N, int M, int [][] area) { //세로로 세 개 쪼갰을 때
		long max = 0;
		
		int area1 = area[r1][M]; //제일 위 직사각형
		int area2 = area[r2][M] - area1; //중간 직사각형
		int area3 = area[N][M] - area2 - area1; //제일 아래 직사각형
		
		max = area1 * area2 * area3;
		
		return max;
	}
	public static long cal3(int c1, int c2, int N, int M, int [][] area) { //가로로 세 개 쪼갰을 때
		long max = 0;
		
		int area1 = area[N][c1]; //제일 왼쪽 직사각형
		int area2 = area[N][c2] - area1; //중간 직사각형
		int area3 = area[N][M] - area2 - area1; //제일 오른쪽 직사각형
		
		max = area1 * area2 * area3;
		
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int[N][M];
		
		String s;
		
		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0;j<M;j++)
				arr[i][j] = s.charAt(j) - '0';
		}
		
		int [][] area = new int[N][M]; //(r,c)까지의 수들의 합 저장할 배열
		
		area[0][0] = arr[0][0];
		
		for(int i=1;i<M;i++)
			area[0][i] = area[0][i-1] + arr[0][i]; //가로 (0,i) 저장
		for(int i=1;i<N;i++)
			area[i][0] = area[i-1][0] + arr[i][0]; //세로 (i,0) 저장
		
		//나머지 부분들 저장 - area[r][c] = area[r][c-1] + area[r-1][c] - area[r-1][c-1] + arr[r][c]
		//area[r-1][c-1]은 겹치는 부분
		for(int i=1;i<N;i++) { 
			for(int j=1;j<M;j++) {
				area[i][j] = area[i][j-1] + area[i-1][j] - area[i-1][j-1] + arr[i][j];
			}
		}
		
		long max = 0;
		long temp;
		
		for(int i=0;i<N;i++) { //네 구역으로 쪼개기
			for(int j=0;j<M;j++) {
				temp = cal1(i,j,N-1,M-1,area);
				if(max<temp) max = temp;
			}
		}
		
		for(int i=0;i<N;i++) { //세로로 쪼개기
			for(int j=i+1;j<N;j++) {
				temp = cal2(i,j,N-1,M-1,area);
				if(max<temp) max = temp;
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=i+1;j<M;j++) {
				temp = cal3(i,j,N-1,M-1,area);
				if(max<temp) max = temp;
			}
		}
		
		System.out.println(max);
		
	}

}
