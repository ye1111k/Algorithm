package 백준문제;

import java.util.*;

public class BOJ_14499 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int M = input.nextInt();
		
		int x = input.nextInt();
		int y = input.nextInt();
		
		int K = input.nextInt();
		
		int [][] map = new int[N][M];
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++)
				map[r][c] = input.nextInt();
		}
		
		int order, tmpR, tmpC;
		
		int [] dice = {0,0,0,0,0,0}; //위, 북, 동, 서, 남, 아래 순서대로
		int [] tmpDice;
		
		for(int k=0;k<K;k++) {
			order = input.nextInt();
			
			tmpDice = new int[6];
			
			//동
			if(order==1) {
				tmpR = x;
				tmpC = y+1;
				if(tmpC==M) continue;
				
				tmpDice[0] = dice[3];
				tmpDice[1] = dice[1];
				tmpDice[2] = dice[0];
				tmpDice[3] = dice[5];
				tmpDice[4] = dice[4];
				tmpDice[5] = dice[2];
			}
			//서
			else if(order==2) {
				tmpR = x;
				tmpC = y-1;
				if(tmpC<0) continue;
				
				tmpDice[0] = dice[2];
				tmpDice[1] = dice[1];
				tmpDice[2] = dice[5];
				tmpDice[3] = dice[0];
				tmpDice[4] = dice[4];
				tmpDice[5] = dice[3];
			}
			//남
			else if(order==3) {
				tmpR = x-1;
				tmpC = y;
				if(tmpR<0) continue;
				
				tmpDice[0] = dice[4];
				tmpDice[1] = dice[0];
				tmpDice[2] = dice[2];
				tmpDice[3] = dice[3];
				tmpDice[4] = dice[5];
				tmpDice[5] = dice[1];
			}
			//북
			else {
				tmpR = x+1;
				tmpC = y;
				if(tmpR==N) continue;
				
				tmpDice[0] = dice[1];
				tmpDice[1] = dice[5];
				tmpDice[2] = dice[2];
				tmpDice[3] = dice[3];
				tmpDice[4] = dice[0];
				tmpDice[5] = dice[4];
			}
			
			//주사위 이동
			x = tmpR;
			y = tmpC;
			
			for(int i=0;i<6;i++)
				dice[i] = tmpDice[i];
			
			if(map[x][y] == 0) map[x][y] = dice[5];
			else {
				dice[5] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[0]);
		}
	}

}
