package 백준문제;

import java.util.*;

public class SWEA_2819 {
	private static HashSet<String> set;
	private static int [][] arr;
	private static int [] dr = {-1,1,0,0};
	private static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			arr = new int[4][4];
			set = new HashSet<String>();
			
			for(int r=0;r<4;r++) {
				for(int c=0;c<4;c++) 
					arr[r][c] = sc.nextInt();
			}
			
			for(int r=0;r<4;r++) {
				for(int c=0;c<4;c++) {
					DFS(r, c, String.valueOf(arr[r][c]));
				}
			}
			System.out.printf("#%d %d\n", test_case, set.size());
		}
	}
	public static void DFS(int r, int c, String num) {
		if(num.length()==7) {
			set.add(num);
			return;
		}
		
		int tempR, tempC;
		String tempNum;
		
		for(int i=0;i<4;i++) {
			tempR = r+dr[i];
			tempC = c+dc[i];
			
			if(tempR<0 || tempR==4 || tempC<0 || tempC==4) continue;
			tempNum = num+arr[tempR][tempC];
			DFS(tempR, tempC, tempNum);
		}
	}
}
