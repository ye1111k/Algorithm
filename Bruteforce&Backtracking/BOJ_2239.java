package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_2239 {
	static boolean [][] hor;
	static boolean [][] ver;
	static boolean [][][] square;
	static int [][] sudoku;
	static int zero; //비어있는 칸의 수
	static int [][] empty; //비어있는 칸이 어디인지 체크할 배열
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		hor = new boolean[9][10];
		ver = new boolean[9][10];
		square = new boolean[3][3][10];
		sudoku = new int[9][9];
		empty = new int[81][2];
		zero = 0;
		
		String s;
		
		for(int i=0;i<9;i++) {
			s = br.readLine();
			for(int j=0;j<9;j++) {
				sudoku[i][j] = s.charAt(j) - '0';
				if(sudoku[i][j] != 0) {
					hor[i][sudoku[i][j]] = true;
					ver[j][sudoku[i][j]] = true;
					square[i/3][j/3][sudoku[i][j]] = true;
				}
				else {
					empty[zero][0] = i;
					empty[zero][1] = j;
					zero++;	
				}
			}
		}
		
		func(0);
	}
	
	public static void func(int now) {
		if(now == zero) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) 
					System.out.print(sudoku[i][j]);
				System.out.println();
			}
			System.exit(0);
		}
		int n = empty[now][0]; 
		int r = empty[now][1];
		
		for(int i=1;i<=9;i++) {
			if(!hor[n][i] && !ver[r][i] && !square[n/3][r/3][i]) {
				sudoku[n][r] = i;
				hor[n][i] = true;
				ver[r][i] = true;
				square[n/3][r/3][i] = true;
				func(now+1);
				sudoku[n][r] = 0;
				hor[n][i] = false;
				ver[r][i] = false;
				square[n/3][r/3][i] = false;
			}
		}
	}

}
