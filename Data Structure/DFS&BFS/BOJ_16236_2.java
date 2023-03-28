package 백준문제;
import java.util.*;
public class BOJ_16236_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int N = Integer.parseInt(input.nextLine());
		int [][] arr = new int[N][N];
		
		StringTokenizer st;
		int r = 0, c = 0, answer = 0, now = 2;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(input.nextLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					r = i;
					c = j;
					arr[i][j] = 0;
				}
			}
		}
		
		int [][] dis;
		
		int tmpR = r, tmpC = c, tmpMin, ate = 0;
		
		while(true) {
			dis = BFS(arr, r, c, now);
			tmpMin = 1000;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(tmpMin>dis[i][j]) {
						tmpR = i;
						tmpC = j;
						tmpMin = dis[i][j];
					}
					//System.out.print(dis[i][j]+" ");
				}
				//System.out.println();
			}
			if(tmpMin == 1000) break;
			
			arr[tmpR][tmpC] = 0;
			r = tmpR;
			c = tmpC;
			answer += tmpMin;
			
			ate++;
			if(ate==now) {
				now++;
				ate = 0;
			}
		}
		
		System.out.println(answer);
	}
	
	public static int[][] BFS(int [][] arr, int r, int c, int now) {
		int N = arr.length;
		
		int [][] answer = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				answer[i][j] = 100000;
			}
		}
		
		LinkedList<int []> Queue = new LinkedList<int []>();
		boolean [][] visited = new boolean[N][N];
		
		int [] temp = {r, c, 0};
		
		int [] dr = {-1, 1, 0, 0};
		int [] dc = {0, 0, -1, 1};
		
		int tmpR, tmpC;
		
		Queue.addLast(temp);
		visited[r][c] = true;
		
		while(!Queue.isEmpty()) {
			temp = Queue.removeFirst();
			
			for(int i=0;i<4;i++) {
				tmpR = temp[0] + dr[i];
				tmpC = temp[1] + dc[i];
				
				if(tmpR<0 || tmpR>=N || tmpC<0 || tmpC>=N) continue; //범위 벗어나는 곳일 경우
				if(visited[tmpR][tmpC]) continue; //이미 방문한 곳인 경우
				
				if(now<arr[tmpR][tmpC]) continue; //못 지나가는 칸일 경우
				
				visited[tmpR][tmpC] = true;
				Queue.addLast(new int[] {tmpR, tmpC, temp[2]+1});
				
				if(arr[tmpR][tmpC]!=0 && now>arr[tmpR][tmpC]) answer[tmpR][tmpC] = temp[2]+1; //먹을 수 있는 물고기가 있는 칸인 경우
			}
		}
		
		return answer;
	}

}
