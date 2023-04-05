package 백준문제;

import java.util.*;

public class BOJ_19236 {
	
	private static int [] dr = {-50,-1,-1,0,1,1,1,0,-1};
	private static int [] dc = {-50,0,-1,-1,-1,0,1,1,1};
	
	private static int [] shark; //상어의 행번호, 열번호, 방향
	
	private static int answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		shark = new int[3];
		
		int [][] arr = new int[4][4]; //-1이면 상어, 0이면 빈칸
		int [][] fish = new int[17][3]; //i번 물고기의 위치(행, 열), 방향
		
		answer = 0;
		
		for(int r=0;r<4;r++) {
			for(int c=0;c<4;c++) {
				arr[r][c] = input.nextInt();
				
				fish[arr[r][c]][0] = r;
				fish[arr[r][c]][1] = c;
				fish[arr[r][c]][2] = input.nextInt();
			}
		}
		
		shark[0] = 0;
		shark[1] = 0;
		shark[2] = fish[arr[0][0]][2];
		
		int ate = arr[0][0];
		
		fish[arr[0][0]][0] = -1; //i번 물고기의 0번째 원소가 -1이면 먹힌 경우
		arr[0][0] = -1;
		
		sharkMove(ate, arr, fish);
		
		System.out.println(answer);
	}
	public static void sharkMove(int now, int [][] arr, int [][] fish) {
		int tempR, tempC, oriR = shark[0], oriC = shark[1], oriDir = shark[2];
		int f1;
		
		int [][] newArr = new int[4][4];
		int [][] newFish = new int[17][3];
		
		for(int r=0;r<4;r++) {
			for(int c=0;c<4;c++)
				newArr[r][c] = arr[r][c];	
		}
		
		for(int i=0;i<=16;i++) {
			for(int j=0;j<3;j++)
				newFish[i][j] = fish[i][j];
		}
		
		//일단 물고기 이동
		for(int i=1;i<=16;i++) {
			if(newFish[i][0]==-1) continue; //이미 먹힌 물고기일 경우 continue;
			
			for(int j=0;j<8;j++) {
				tempR = newFish[i][0] + dr[newFish[i][2]];
				tempC = newFish[i][1] + dc[newFish[i][2]];
				
				if(tempR>=0 && tempC>=0 && tempR<4 && tempC<4) {//경계를 벗어나지 않아야 함
					if(newArr[tempR][tempC] >= 0) {//빈칸이거나 물고기가 있는 경우
						f1 = newArr[tempR][tempC];
						
						//자리 바꿔주기
						newArr[newFish[i][0]][newFish[i][1]] = newArr[tempR][tempC];
						newArr[tempR][tempC] = i;
						
						if(newArr[tempR][tempC]>0) { //물고기가 있는 자리로 이동할 경우
							newFish[f1][0] = newFish[i][0];
							newFish[f1][1] = newFish[i][1];
						}
						
						newFish[i][0] = tempR;
						newFish[i][1] = tempC;
						
						break;
					}	
				}
				
				//방향 반시계로 45도 회전
				if(newFish[i][2]==8) newFish[i][2] = 1;
				else newFish[i][2]++;
			}
		}
		
		for(int i=1;i<=4;i++) { //상어 이동
			tempR = oriR + i*dr[oriDir];
			tempC = oriC + i*dc[oriDir];
			
			if(tempR<0 || tempC<0 || tempR==4 || tempC==4) { //더 이상 갈 곳이 없을 떄
				if(now>answer) answer = now;
				
				return;
			}
			
			if(newArr[tempR][tempC] == 0) continue; //물고기가 없는 칸
			
			f1 = newArr[tempR][tempC]; //먹을 물고기
			
			//물고기 먹기
			newArr[tempR][tempC] = -1;
			newArr[oriR][oriC] = 0;
			
			shark[0] = tempR;
			shark[1] = tempC;
			shark[2] = newFish[f1][2];
			
			newFish[f1][0] = -1;
			
			//상어 이동
			sharkMove(now+f1, newArr, newFish);
			
			//물고기 뱉기
			shark[0] = oriR;
			shark[1] = oriC;
			shark[2] = oriDir;
			
			newArr[oriR][oriC] = -1;
			newArr[tempR][tempC] = f1;
			
			newFish[f1][0] = tempR;
		}
	}
	public static int[][] fishMove(int [][] arr, int [][] fish) {
		int tempR, tempC;
		int f1;
		
		for(int i=1;i<=16;i++) {
			if(fish[i][0]==-1) continue; //이미 먹힌 물고기일 경우 continue;
			
			for(int j=0;j<8;j++) {
				tempR = fish[i][0] + dr[fish[i][2]];
				tempC = fish[i][1] + dc[fish[i][2]];
				
				if(tempR>=0 && tempC>=0 && tempR<4 && tempC<4) {//경계를 벗어나지 않아야 함
					if(arr[tempR][tempC] >= 0) {//빈칸이거나 물고기가 있는 경우
						f1 = arr[tempR][tempC];
						
						//자리 바꿔주기
						arr[fish[i][0]][fish[i][1]] = arr[tempR][tempC];
						arr[tempR][tempC] = i;
						
						if(arr[tempR][tempC]>0) { //물고기가 있는 자리로 이동할 경우
							fish[f1][0] = fish[i][0];
							fish[f1][1] = fish[i][1];
						}
						
						fish[i][0] = tempR;
						fish[i][1] = tempC;
						
						break;
					}	
				}
				
				//방향 반시계로 45도 회전
				if(fish[i][2]==8) fish[i][2] = 1;
				else fish[i][2]++;
			}
		}
		return arr;
	}
	public static int[][] fishMove2(int [][] arr, int [][] fish) {
		int tempR, tempC;
		int f1;
		
		for(int i=1;i<=16;i++) {
			if(fish[i][0]==-1) continue; //이미 먹힌 물고기일 경우 continue;
			
			for(int j=0;j<8;j++) {
				tempR = fish[i][0] + dr[fish[i][2]];
				tempC = fish[i][1] + dc[fish[i][2]];
				
				if(tempR>=0 && tempC>=0 && tempR<4 && tempC<4) {//경계를 벗어나지 않아야 함
					if(arr[tempR][tempC] >= 0) {//빈칸이거나 물고기가 있는 경우
						f1 = arr[tempR][tempC];
						
						//자리 바꿔주기
						arr[fish[i][0]][fish[i][1]] = arr[tempR][tempC];
						arr[tempR][tempC] = i;
						
						if(arr[tempR][tempC]>0) { //물고기가 있는 자리로 이동할 경우
							fish[f1][0] = fish[i][0];
							fish[f1][1] = fish[i][1];
						}
						
						fish[i][0] = tempR;
						fish[i][1] = tempC;
						
						break;
					}	
				}
				
				//방향 반시계로 45도 회전
				if(fish[i][2]==8) fish[i][2] = 1;
				else fish[i][2]++;
			}
		}
		return fish;
	}
}
