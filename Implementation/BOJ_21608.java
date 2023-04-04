package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_21608 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int [][] arr = new int[N][N]; //교실에 앉을 학생 배열
		boolean [][] like = new boolean[N*N+1][N*N+1]; //i번째 학생이 j번째 학생을 좋아하는지 확인할 수 있는 배열
		int stu, blank, a;
		int tempR, tempC;
		int [] best;
		
		int [] dr = {-1,1,0,0};
		int [] dc = {0,0,1,-1};
		
		for(int i=1;i<=N*N;i++) {
			st = new StringTokenizer(br.readLine());
			stu = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<4;j++) //각 학생이 좋아하는 학생 정보 저장 
				like[stu][Integer.parseInt(st.nextToken())] = true;
		
			best = new int[4]; //가장 좋은 칸의 행 번호, 가장 좋은 칸의 열 번호, 인접하는 칸에 앉아있는 좋아하는 학생 수, 인접하는 칸의 빈칸 수
			best[0] = -1;//주변에 좋아하는 학생도 없고, 빈 자리도 없는 자리만 남았을 경우 방지
			
			//모든 자리 탐색하면서 best 자리 찾기
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					blank = 0;
					a = 0;
					
					if(arr[r][c] != 0) continue; //이미 누가 앉아있을 경우 넘어가기
					
					if(best[0] == -1) { //주변에 좋아하는 학생도 없고, 빈 자리도 없는 자리만 남았을 경우 방지
						best[0] = r;
						best[1] = c;
						best[2] = 0;
						best[3] = 0;
					}
					
					for(int j=0;j<4;j++) { //주변 자리 둘러보면서 좋아하는 학생의 수, 빈 자리 수 체크
						tempR = r+dr[j];
						tempC = c+dc[j];
						if(tempR<0 || tempR>=N || tempC<0 || tempC>=N) continue;
						if(like[stu][arr[tempR][tempC]]) a++;
						if(arr[tempR][tempC]==0) blank++;
					}
					if(a>best[2] || (a==best[2] && blank>best[3])) {//1번 조건 만족
							best[0] = r;
							best[1] = c;
							best[2] = a;
							best[3] = blank;
					}
				}
			}
			
			arr[best[0]][best[1]] = stu;
		}
		
		int answer = 0;
		
		//각 학생의 만족도 합 계산
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				stu = arr[r][c];
				a=0;
				
				for(int i=0;i<4;i++) {
					tempR = r+dr[i];
					tempC = c+dc[i];
					if(tempR<0 || tempR>=N || tempC<0 || tempC>=N) continue;
					if(like[stu][arr[tempR][tempC]]) a++;
				}
				
				if(a==1) answer++;
				else if(a==2) answer += 10;
				else if(a==3) answer += 100;
				else if(a==4) answer += 1000;
				
				System.out.print(arr[r][c]+" ");
			}
			System.out.println();
		}
		
		System.out.println(answer);
	}

}
