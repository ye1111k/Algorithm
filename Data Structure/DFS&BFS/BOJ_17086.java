package 백준문제;

import java.io.*;
import java.util.*;

class Node_17086 {
	int r;
	int c;
	int dis;
	
	public Node_17086(int r, int c, int dis) {
		this.r = r;
		this.c = c;
		this.dis = dis;
	}
}

public class BOJ_17086 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean [][] arr= new boolean[N][M]; //아기 상어가 있는지 빈칸인지 저장할 배열
		int [][] dis_shark = new int[N][M]; //가장 가까운 아기 상어와의 거리 저장할 배열
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				if(st.nextToken().equals("1")) //아기 상어 있을 경우
					arr[i][j] = true;
				else dis_shark[i][j] = 1000; //빈칸일 경우
			}
		}
		
		LinkedList<Node_17086> Queue;
		Node_17068 temp;
		boolean [][] visited;
		
		//다음에 방문할 노드 계산할 때 필요
		int [] dx = {0, 1, -1};
		int [] dy = {0, 1, -1};
		
		int r,c;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]) continue; //아기 상어가 있는 칸일 경우 continue
				visited = new boolean[N][M]; //방문 배열 생성
				Queue = new LinkedList<Node_17086>(); //큐 생성
				Queue.addLast(new Node_17086(i,j,0)); //현재 있는 곳에 대한 노드 큐에 넣기
				while(!Queue.isEmpty()) {
					temp = Queue.removeFirst(); //제일 앞 노드 꺼내기
					for(int k=0;k<3;k++) {
						for(int h=0;h<3;h++) {
							if(k==0&&h==0) continue; //위아래 0칸 이동 == 현재 있는 칸이므로 continue
							r = temp.r + dx[k];
							c = temp.c + dy[h];
							
							if(r<0||c<0||r>=N||c>=M) continue; //범위 넘어갈 경우
							if(visited[r][c]) continue; //이미 방문한 칸일 경우
							if(arr[r][c]) { //아기 상어가 있는 칸인 경우
								dis_shark[i][j] = temp.dis+1;
								break;
							}
							
							Queue.addLast(new Node_17086(r,c,temp.dis+1));
							visited[r][c] = true;//방문 처리
						}
						if(dis_shark[i][j]<1000) break;
					}
					if(dis_shark[i][j]<1000) break;
				}
			}
		}
		
		//가장 큰 안전 거리
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				max = (dis_shark[i][j]>max)?dis_shark[i][j]:max;
		}
		
		System.out.println(max);
		
		
	}

}
