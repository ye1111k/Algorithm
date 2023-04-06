package 백준문제;

import java.util.*;

public class BOJ_20057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		int [][] A = new int[N][N];
		boolean [][] visited = new boolean[N][N]; //토네이도가 지나간 적 있는지 체크할 배열
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				A[r][c] = input.nextInt();
			}
		}
		
		int [] tornado = {N/2, N/2, 0}; //토네이도의 현재 위치(r,c)와 방향
		visited[N/2][N/2] = true;
		
		int [] dr = {0,1,0,-1,0};
		int [] dc = {-1,0,1,0,-1};
		
		//왼위, 왼아, 오아, 오위 순
		int [] diagonalR = {-1, 1, 1, -1}; 
		int [] diagonalC = {-1, -1, 1, 1};
		
		int [] percent = {1, 1, 2, 2, 7, 7, 10, 10, 5};
		
		int tempR, tempC, tempD, sand, answer = 0, lostSand;
		
		while(true) {
			if(tornado[0]==0 && tornado[1]==0) break;
			
			//토네이도 이동
			tornado[0] += dr[tornado[2]];
			tornado[1] += dc[tornado[2]];
			
			tempR = tornado[0];
			tempC = tornado[1];
			tempD = tornado[2];
			
			visited[tempR][tempC] = true; //방문 처리
			
			lostSand = 0;
			
			for(int i=0;i<9;i++) {
				//1%칸
				if(i==0) { //오른쪽 뒤
					tempR = tornado[0]+diagonalR[(tornado[2]+3)%4];
					tempC = tornado[1]+diagonalC[(tornado[2]+3)%4];
				}
				else if(i==1) { //왼쪽 뒤
					tempR = tornado[0]+diagonalR[(tornado[2]+2)%4];
					tempC = tornado[1]+diagonalC[(tornado[2]+2)%4];
				}
				//2%칸
				else if(i==2) { //오른쪽 두칸 옆
					tempR = tornado[0]+2*dr[(tornado[2]+3)%4];
					tempC = tornado[1]+2*dc[(tornado[2]+3)%4];
				}
				else if(i==3) { //왼쪽 두 칸 옆
					tempR = tornado[0]+2*dr[(tornado[2]+1)%4];
					tempC = tornado[1]+2*dc[(tornado[2]+1)%4];
				}
				//7%칸
				else if(i==4) { //오른쪽 한 칸 옆
					tempR = tornado[0]+dr[(tornado[2]+3)%4];
					tempC = tornado[1]+dc[(tornado[2]+3)%4];
				}
				else if(i==5) { //왼쪽 한 칸 옆
					tempR = tornado[0]+dr[(tornado[2]+1)%4];
					tempC = tornado[1]+dc[(tornado[2]+1)%4];
				}
				//10%칸
				else if(i==6) { //오른쪽 앞
					tempR = tornado[0]+diagonalR[tornado[2]];
					tempC = tornado[1]+diagonalC[tornado[2]];
				}
				else if(i==7) { //왼쪽 앞
					tempR = tornado[0]+diagonalR[(tornado[2]+1)%4];
					tempC = tornado[1]+diagonalC[(tornado[2]+1)%4];
				}
				//5%칸
				else if(i==8) { //2칸 앞
					tempR = tornado[0]+2*dr[tempD];
					tempC = tornado[1]+2*dc[tempD];
				}
					
				sand = (A[tornado[0]][tornado[1]]*percent[i])/100;
					
				if(tempR<0 || tempC<0 || tempR>=N || tempC>=N)
					answer += sand;
				else A[tempR][tempC] += sand;
				
				
				
				lostSand += sand;
			}
			
			//a칸
			sand = A[tornado[0]][tornado[1]]-lostSand;
			
			tempR = tornado[0]+dr[tempD];
			tempC = tornado[1]+dc[tempD];
			
			if(tempR<0 || tempC<0 || tempR>=N || tempC>=N)
				answer += sand;
			else A[tempR][tempC] += sand;
			
			
			A[tornado[0]][tornado[1]] = 0; //현재 토네이도가 있는 곳의 모래 비우기
			
			//현재 도달한 곳의 왼쪽 칸을 아직 방문하지 않았을 경우 방향 바꾸기
			if(!visited[tornado[0]+dr[tempD+1]][tornado[1]+dc[tempD+1]]) {
				tornado[2] = (tornado[2]+1)%4; 
			}
		}
		
		System.out.println(answer);
	}

}
