package 백준문제;

import java.util.*;

public class BOJ_20058 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int Q = input.nextInt();
		
		int n = (int)Math.pow(2, N);
		
		int [][] A = new int[n][n];
		int L, l;
		
		for(int r=0;r<n;r++) {
			for(int c=0;c<n;c++)
				A[r][c] = input.nextInt();
		}
		
		int startR, startC;
		
		int ice = 0, answer = 0, count, tempR, tempC;
		int [] temp;
		
		int [][] tmp;
		
		int [] dr = {-1, 1, 0, 0};
		int [] dc = {0, 0, -1, 1};
		
		for(int q=0;q<Q;q++) {
			L = input.nextInt();
			l = (int)Math.pow(2, L);
			
			tmp = new int[n][n]; //복사본
			
			for(int r=0;r<n;r++) {
				for(int c=0;c<n;c++) {
					tmp[r][c] = A[r][c];
				}
			}
			
			//회전
			for(int x=0;x<n/l;x++) {
				startR = x*l;
				for(int y=0;y<n/l;y++) {
					startC = y*l;
					for(int r=0;r<l;r++) {
						for(int c=0;c<l;c++) {
							A[startR+r][startC+c] = tmp[startR+l-c-1][startC+r];
						}
					}
				}
			}
			
			for(int r=0;r<n;r++) {
				for(int c=0;c<n;c++) {
					if(A[r][c]==0) {
						tmp[r][c] = 0;
						continue;
					}
					count = 0;
					for(int i=0;i<4;i++) {
						tempR = r+dr[i];
						tempC = c+dc[i];
						
						if(tempR<0 || tempC<0 || tempR>=n || tempC>=n) continue;
						
						if(A[tempR][tempC]>=1) count++;
					}
					if(count<3)
						tmp[r][c] = A[r][c] - 1;
					else tmp[r][c] = A[r][c];
				}
			}
			
			for(int r=0;r<n;r++) {
				for(int c=0;c<n;c++) {
					A[r][c] = tmp[r][c];
				}
			}
		}
		
		
		
		boolean [][] visited = new boolean[n][n];
		LinkedList<int []> Queue;
		
		
		for(int r=0;r<n;r++) {
			for(int c=0;c<n;c++) {
				ice += A[r][c];
				
				if(visited[r][c] || A[r][c]==0) continue;
				
				Queue = new LinkedList<int []>();
				
				temp = new int[] {r, c};
				Queue.addLast(temp);
				visited[r][c] = true;
				count = 1;
				
				while(!Queue.isEmpty()) {
					temp = Queue.removeFirst();
					
					for(int i=0;i<4;i++) {
						tempR = temp[0]+dr[i];
						tempC = temp[1]+dc[i];
						
						if(tempR<0 || tempC<0 || tempR>=n || tempC>=n) continue;
						if(visited[tempR][tempC]) continue;
						visited[tempR][tempC] = true;
						
						if(A[tempR][tempC]==0) continue; //얼음이 없는 곳이라면
						
						count++;
						Queue.addLast(new int[] {tempR, tempC});
					}
				}
				
				if(count>answer) answer = count;
			}
		}
		
		System.out.println(ice);
		System.out.println(answer);
	}

}
