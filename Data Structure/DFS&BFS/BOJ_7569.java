package 백준문제;

import java.util.*;

public class BOJ_7569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringTokenizer st;
		
		int M, N, H;
		
		st = new StringTokenizer(input.nextLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int [][][] box = new int[H][N][M];
		LinkedList<int []> Queue = new LinkedList<int []>();
		int [] tmp;
		int noT = 0; //익지 않은 토마토의 개수
	
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(input.nextLine());
				
				for(int k=0;k<M;k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					
					if(box[i][j][k] == 1) {
						tmp = new int[4];
						tmp[0] = i; //높이
						tmp[1] = j; //가로
						tmp[2] = k; //세로
						tmp[3] = 0; //언제 익었는지
						
						Queue.addLast(tmp);
					}
					else if(box[i][j][k] == 0) noT++;
				}	
			}
		}
		
		int answer = 0;
		
		int [] dm = {1,-1,0,0,0,0};
		int [] dn = {0,0,1,-1,0,0};
		int [] dh = {0,0,0,0,1,-1};
		
		int tmpM, tmpN, tmpH;
		
		while(!Queue.isEmpty()) {
			tmp = Queue.removeFirst();
			
			for(int i=0;i<6;i++) {
				tmpM = tmp[2] + dm[i];
				tmpN = tmp[1] + dn[i];
				tmpH = tmp[0] + dh[i];
				
				if(tmpM<0 || tmpN<0 || tmpH<0 || tmpM>=M || tmpN>=N || tmpH>=H) //박스 범위 벗어날 경우 continue
					continue;
				
				if(box[tmpH][tmpN][tmpM] == 0) { //새로 방문한 칸에 아직 익지 않은 토마토가 들어있을 경우
					Queue.addLast(new int[] {tmpH, tmpN, tmpM, tmp[3]+1}); //큐에 추가
					
					box[tmpH][tmpN][tmpM] = 1; //박스 안 토마토 익음처리
					noT--;
					
					if(tmp[3] + 1 > answer) answer = tmp[3]+1; //답 업데이트
				}
			}
		}
		
		if(noT != 0) System.out.println(-1);
		else System.out.println(answer);
		
	}

}
