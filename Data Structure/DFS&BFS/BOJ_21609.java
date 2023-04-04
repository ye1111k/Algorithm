package 백준문제;

import java.util.*;

public class BOJ_21609 {
	private static boolean [][] visited;
	private static int [][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(input.nextLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(input.nextLine());
			for(int c=0;c<N;c++)
				arr[r][c] = Integer.parseInt(st.nextToken());
		}
		
		int [] best;
		int [] temp = new int[4];
		int score = 0;
		
		int [][] anti;
		
		while(true) {
			visited = new boolean[N][N];
			best = new int[] {-1,-1,0,0}; //행, 열, 블록 그룹 크기, 무지개 블록 수
			
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(visited[r][c] || arr[r][c]<=0) continue; //이미 방문한 적 있고, 일반 블록이 아닐 경우
					
					temp = BFS(r, c, true); //temp[0] = 블록 그룹의 크기, temp[1] = 무지개 블록의 개수
					if(temp[0]>=2) { //블록 그룹의 크기가 2보다 크거나 같을 경우 비교
						if((best[0]==-1) || (temp[0]>best[2]) || (temp[0]==best[2]&&temp[1]>=best[3])) { //best에 아직 아무것도 없거나, 블록 그룹의 크기가 더 크거나, 무지개 블록의 개수가 더 많거나 같은 경우
							best[0] = r;
							best[1] = c;
							best[2] = temp[0];
							best[3] = temp[1];
						}
					}
				}
			}
			
			if(best[0]==-1) break; //기준을 만족하는 블록 그룹이 없는 경우
			
			score += best[2]*best[2];
			visited = new boolean[N][N];
			BFS(best[0], best[1], false);
			
			Gravity();
			arr = AntiClockwise();
			Gravity();
		}
		
		System.out.println(score);
	}
	public static int[] BFS(int startR, int startC, boolean ck) { //boolean이 true일 경우 블록 그룹 찾기, false일 경우 해당 그룹 지우기
		int [] answer = new int[2]; //answer[0] = 블록 그룹의 크기, answer[1] = 무지개 블록의 개수
		
		int N = arr.length;
		
		LinkedList<int []> Queue = new LinkedList<int []>();
		int tempR, tempC, Num = arr[startR][startC];
		
		int [] dr = {-1,1,0,0};
		int [] dc = {0,0,-1,1};
		
		int [] temp = new int[] {startR, startC};
		Queue.addLast(temp);
		visited[startR][startC] = true;
		answer[0]++;
		if(!ck) arr[startR][startC] = -2;
		
		while(!Queue.isEmpty()) {
			temp = Queue.removeFirst();
			
			for(int i=0;i<4;i++) {
				tempR = temp[0]+dr[i];
				tempC = temp[1]+dc[i];
				
				if(tempR<0 || tempR>=N || tempC<0 || tempC>=N) continue;
				if(visited[tempR][tempC]) continue;
				
				if(arr[tempR][tempC]!=0 && arr[tempR][tempC]!=Num) continue; //무지개 블록도 아니고 기준 블록이랑 다른 색 블록일 경우 넘어가기
				
				Queue.addLast(new int[] {tempR, tempC});
				visited[tempR][tempC] = true;
			 	answer[0]++; //블록 그룹의 크기 카운트
				
				if(!ck) arr[tempR][tempC] = -2;
				
				if(arr[tempR][tempC]==0)
					answer[1]++; //무지개 블록 수 카운트
			}
		}
		
		for(int r=0;r<N;r++)
			for(int c=0;c<N;c++)
				if(arr[r][c]==0) visited[r][c] = false; //무지개 블록은 또 쓸 수 있음
		
		return answer;
	}
	
	public static void Gravity() {
		int N = arr.length;
		//int [][] answer = new int[N][N];
		
		int now;
		
		for(int c=0;c<N;c++) { //첫번째 열부터	
			for(int r=N-1;r>0;r--) {
				if(arr[r][c]>=-1) continue; //채워져있는 칸일 경우
				
				for(now=r-1;now>=0;now--) {
					if(arr[now][c]==-1) break; //검은 블록일 경우 넘어가기
					else if(arr[now][c]>=0) { //일반 블록 or 무지개 블록일 경우 아래로 가져오기
						arr[r][c] = arr[now][c];
						arr[now][c] = -2;
						break;
					}
				}
			}
		}
	}
	
	public static int[][] AntiClockwise(){
		int N = arr.length;
		
		int [][] answer = new int[N][N];
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				answer[r][c] = arr[c][N-r-1];
			}
		}
		
		return answer;
	}
	

}
