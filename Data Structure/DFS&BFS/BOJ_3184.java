package 백준문제;

import java.util.*;
import java.io.*;

class Node_3184{
	int r,c;
	
	public Node_3184(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class BOJ_3184 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int [][] yard = new int[R][C];
		
		String s;
		int sheep = 0, wolf = 0;
		
		for(int r=0;r<R;r++) {
			s = br.readLine();
			for(int c=0;c<C;c++) {
				switch(s.charAt(c)) {
					case 'o': //양
						yard[r][c] = 1; 
						sheep++;
						break;
					case 'v': //늑대
						yard[r][c] = 2;
						wolf++;
						break;
					case '#': //울타리
						yard[r][c] = 5;
						break;
				}
			}
		}
		
		boolean [][] visited = new boolean[R][C]; //이미 방문한 곳인지 체크할 배열
		
		int [] dx = {-1,1,0,0};
		int [] dy = {0,0,-1,1};
		
		LinkedList<Node_3184> Queue = new LinkedList<Node_3184>();
		
		Node_3184 temp;
		int tempS, tempW; //한 구역 안에 있는 양과 늑대의 수 저장할 변수
		int tempr, tempc;
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(visited[r][c]) continue;
				if(yard[r][c]==0||yard[r][c]==5) continue; //빈 공간이거나 울타리면 넘어가기
				
				tempW = 0;
				tempS = 0;
				
				if(yard[r][c]==1) tempS++;
				else tempW++;
				
				visited[r][c] = true;
				
				Queue.add(new Node_3184(r,c));
				while(!Queue.isEmpty()) {
					temp = Queue.removeFirst();
					for(int i=0;i<4;i++) {
						tempr = temp.r + dx[i];
						tempc = temp.c + dy[i];
						
						if(tempr>=R||tempc>=C||tempr<0||tempc<0) continue; //범위 벗어날 경우
						
						if(visited[tempr][tempc]) continue;
						visited[tempr][tempc] = true;
						
						if(yard[tempr][tempc]==5) continue;  //울타리인 경우 더 나아가지 않음
						if(yard[tempr][tempc]==1) tempS++;
						if(yard[tempr][tempc]==2) tempW++;
						
						Queue.addLast(new Node_3184(tempr, tempc));
					}
				}
				
				if(tempS>tempW) wolf -= tempW; //양이 많은 경우
				else sheep -= tempS; //늑대가 많은 경우
			}
		}
		
		System.out.println(sheep+" "+wolf);
	}

}
