package 백준문제;

import java.util.*;

public class BOJ_21610 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int M = input.nextInt();
		
		int [][] A = new int[N+1][N+1];
		
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++)
				A[r][c] = input.nextInt();
		}
		
		ArrayList<int []> Cloud = new ArrayList<int []>();
		boolean [][] ck = new boolean[N+1][N+1]; //직전에 구름이 있었는지 체크할 배열
		
		Cloud.add(new int[] {N, 1});
		Cloud.add(new int[] {N, 2});
		Cloud.add(new int[] {N-1, 1});
		Cloud.add(new int[] {N-1, 2});
		
		ck[N][1] = true;
		ck[N][2] = true;
		ck[N-1][1] = true;
		ck[N-1][2] = true;
		
		int d, s, tempR, tempC, count, answer = 0;
		
		int [] dr = {-50, 0, -1, -1, -1, 0, 1, 1, 1};
		int [] dc = {-50, -1, -1, 0, 1, 1, 1, 0, -1};
		
		int [] temp;
		
		for(int m=0;m<M;m++) {
			d = input.nextInt();
			s = input.nextInt();
			
			//구름 이동(1번 과정)
			for(int i=0;i<Cloud.size();i++) {
				temp = Cloud.get(i);
				
				tempR = temp[0];
				tempC = temp[1];
				
				for(int j=1;j<=s;j++) {
					tempR += dr[d];
					tempC += dc[d];
					
					//경계 넘어갈 경우
					if(tempR==0) tempR = N;
					if(tempC==0) tempC = N;
					if(tempR==N+1) tempR = 1;
					if(tempC==N+1) tempC = 1;
				}	
				
				Cloud.set(i, new int[] {tempR, tempC}); //구름 이동
			
				//비 내리기(2번 과정)
				A[tempR][tempC]++;
			}
			
			ck = new boolean[N+1][N+1];
			
			//물복사 버그 마법(4번 과정) - 2에서 증가한 칸 체크하기 위해서 4번 먼저 실행
			for(int i=0;i<Cloud.size();i++) {
				temp = Cloud.get(i);
				
				ck[temp[0]][temp[1]] = true;
				
				count = 0;
				
				for(int j=2;j<=8;j+=2) { //대각선 방향만 체크
					tempR = temp[0]+dr[j];
					tempC = temp[1]+dc[j];
					
					if(tempR==0 || tempC==0 || tempR==N+1 || tempC==N+1) continue; //경계 넘어가는 경우
					
					if(A[tempR][tempC]>=1) count++; //대각선 방향에 물이 있을 경우
				}
				
				A[temp[0]][temp[1]] += count;
			}
			
			//구름 사라지기(3번 과정)
			Cloud = new ArrayList<int []>();
			
			//구름 생기고 2 줄어들기
			for(int r=1;r<=N;r++) {
				for(int c=1;c<=N;c++) {
					if(ck[r][c]) { //전에 구름이 있었던 칸일 경우
						ck[r][c] = false;
						continue;
					}
					if(A[r][c]>=2) {
						A[r][c] -= 2;
						ck[r][c] = true;
						Cloud.add(new int[] {r,c});
					}
					
					
				}
			}
		}
		
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++)
				answer += A[r][c];
		}
		
		System.out.println(answer);
	}

}
