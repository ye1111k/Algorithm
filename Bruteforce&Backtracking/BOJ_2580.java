package 백준문제;

import java.util.Scanner;

public class BOJ_2580 {
	
	public static int [][] sudoku;
	public static boolean [][] v;//세로
	public static boolean [][][] s;//3x3
	public static boolean [][] h;//가로
	public static int zero;
	public static int [][] empty;
	
	public static void func(int now) {
		if(now==zero) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++)
					System.out.printf("%d ", sudoku[i][j]);
				System.out.println();
			}
			System.exit(0);
		}
		
		int a=empty[now][0];
		int b=empty[now][1];
		
		for(int i=1;i<=9;i++) {
			if(!v[a][i]&&!h[b][i]&&!s[a/3][b/3][i]) {
				sudoku[a][b]=i;
				v[a][i]=true;
				h[b][i]=true;
				s[a/3][b/3][i]=true;
				func(now+1);
				sudoku[a][b]=0;
				v[a][i]=false;
				h[b][i]=false;
				s[a/3][b/3][i]=false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		sudoku=new int[9][9];
		v=new boolean[9][10];
		s=new boolean[3][3][10];
		h=new boolean[9][10];
		
		zero=0;
		
		empty=new int[81][2];
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sudoku[i][j]=input.nextInt();
				if(sudoku[i][j]==0) {
					empty[zero][0]=i;
					empty[zero][1]=j;
					zero++;
				}
				v[i][sudoku[i][j]]=true;
				h[j][sudoku[i][j]]=true;
				s[i/3][j/3][sudoku[i][j]]=true;
			}
		}
		
		func(0);

	}

}
