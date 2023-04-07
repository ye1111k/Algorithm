package 백준문제;

import java.io.*;
import java.util.*;

class Shark{
	private int r;
	private int c;
	
	private int[][] dirPri;
	private int dir;
	
	public Shark(int r, int c) {
		this.r = r;
		this.c = c;
	
		this.dir = 1;
		this.dirPri = new int[5][5];
	}
	
	public int getR() {
		return this.r;
	}
	public int getC() {
		return this.c;
	}
	public int getDir() {
		return this.dir;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	public void setC(int c) {
		this.c = c;
	}
	
	public void setDir(int dir) {
		this.dir = dir;
	}
	
	public int[][] getDirPri(){
		return this.dirPri;
	}
	public void setDirPri(int [][] arr) {
		for(int i=1;i<5;i++) {
			for(int j=1;j<5;j++)
				this.dirPri[i][j] = arr[i][j];
		}
	}
}

public class BOJ_19237 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		int [][][] square = new int[N][N][3]; //이 칸에 남아있는 상어 냄새, 남은 시간, 이 칸이 원래 비어있었는지 체크(0이면 비어있었음, 1이면 아님)
		Shark[] sharks = new Shark[M+1];
		sharks[0] = new Shark(-1,-1);
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			
			for(int c=0;c<N;c++) {
				square[r][c][0] = Integer.parseInt(st.nextToken());
				if(square[r][c][0] != 0) {
					sharks[square[r][c][0]] = new Shark(r,c);
					square[r][c][1] = K;
					square[r][c][2] = 1;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=M;i++)
			sharks[i].setDir(Integer.parseInt(st.nextToken()));
		
		
		int [][] tempDirPri;
		for(int i=1;i<=M;i++) {
			tempDirPri = new int[5][5];
			for(int j=1;j<=4;j++) {
				st = new StringTokenizer(br.readLine());	
			
				for(int h=1;h<=4;h++)
					tempDirPri[j][h] = Integer.parseInt(st.nextToken());
			}
			
			sharks[i].setDirPri(tempDirPri);
		}
		
		int [] dr = {-50, -1, 1, 0, 0};
		int [] dc = {-50, 0, 0, -1, 1};
	
		int answer = 0, count = M, nowDir, nowR, nowC, tempDir, tempR, tempC;
		int [][] dirPri;
		
		boolean ck; //상어가 이동했는지 체크할 변수
		
		while(count>1) {
			if(answer==1000) break;
			
			for(int m=1;m<=M;m++) { //센 상어부터 이동
				nowR = sharks[m].getR();
				if(nowR<0) continue; //이미 나가리된 상어일 경우
				
				nowC = sharks[m].getC();
				nowDir = sharks[m].getDir();
				dirPri = sharks[m].getDirPri();
				
				ck = false;
				
				for(int i=1;i<=4;i++) {
					tempR = nowR+dr[dirPri[nowDir][i]];
					tempC = nowC+dc[dirPri[nowDir][i]];
					
					if(tempR<0 || tempC<0 || tempR==N || tempC==N) continue; //범위 밖으로 벗어날 경우
					
					if(square[tempR][tempC][0]==0) {//냄새가 없는 칸(빈칸)일 경우 상어 이동
						ck = true;
						
						square[tempR][tempC][0] = m;
						square[tempR][tempC][1] = K;
						
						sharks[m].setR(tempR);
						sharks[m].setC(tempC);
						sharks[m].setDir(dirPri[nowDir][i]);
						
						break;
					}
					if(square[tempR][tempC][2]==0 && square[tempR][tempC][0]!=0) { //원래 비어있었는데 나보다 센 상어도 여기로 이동할 경우
						ck = true;
						
						//상어 나가리
						sharks[m].setR(-1); 
						count--;
						
						break;
					}
				}
				
				//주변에 빈칸이 없었을 경우 자기 냄새가 있는 곳으로 이동
				if(!ck) {
					for(int i=1;i<=4;i++) {
						tempR = nowR+dr[dirPri[nowDir][i]];
						tempC = nowC+dc[dirPri[nowDir][i]];
						
						if(tempR<0 || tempC<0 || tempR==N || tempC==N) continue; //범위 밖으로 벗어날 경우
						
						if(square[tempR][tempC][0]==m) {//자기 냄새가 있는 칸일 경우 이동
							square[tempR][tempC][1] = K; //냄새 갱신
							
							sharks[m].setR(tempR);
							sharks[m].setC(tempC);
							sharks[m].setDir(dirPri[nowDir][i]);
							
							break;
						}
					}
				}
			}
			
			//냄새 남아있는 시간 카운트
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					tempR = sharks[square[r][c][0]].getR();
					tempC = sharks[square[r][c][0]].getC();
					
					if(tempR==r && tempC==c) { //상어가 있는 칸
						square[r][c][2] = 1;
					}
					else {//상어가 없는 칸
						if(square[r][c][1]>0) square[r][c][1]--; //냄새가 남아있는 칸일 경우
						if(square[r][c][1]==0) {
							square[r][c][0] = 0; //K만큼 시간 지난 경우 냄새 사라짐
							square[r][c][2] = 0;
						}
					}
					
				}
			}
			
			answer++;
		} 
		
		if(count==1) System.out.println(answer);
		else System.out.println(-1);
	}

}
