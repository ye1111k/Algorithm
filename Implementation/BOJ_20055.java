package 백준문제;

import java.util.*;

public class BOJ_20055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(input.nextLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [] Ai = new int[2*N];
		
		st = new StringTokenizer(input.nextLine());
		
		for(int i=0;i<2*N;i++)
			Ai[i] = Integer.parseInt(st.nextToken());
			
		int count = 0;
		int answer = 0;
		int temp;
		
		boolean [] robot = new boolean[N]; //i번째 칸에 로봇이 있는지 체크할 배열
		
		while(K>count) {
			answer++;
			
			//(1번 과정)
			for(int i=N-2;i>0;i--)
				robot[i] = robot[i-1]; //로봇 한 칸씩 이동
			robot[0] = false; //첫번째 칸에는 로봇 없어야 함
			robot[N-1] = false; //내리는 위치로 가면 내리기
			
			temp = Ai[2*N-1]; //컨베이어 벨트의 마지막 칸 내구도
			for(int i=2*N-1;i>0;i--)//컨베이어 벨트 한 칸씩 이동
				Ai[i] = Ai[i-1];
			Ai[0] = temp;
				
			
			
			//(2번 과정)
			for(int i=N-2;i>0;i--) {
				if(robot[i] && !robot[i+1] && Ai[i+1]>0){ //현재 칸에 로봇이 있고, 다음 칸은 비어있고, 다음 칸의 내구도가 1 이상
					robot[i] = false;
					robot[i+1] = true;
					Ai[i+1]--; //내구도 깎기
					
					if(Ai[i+1]==0) count++; //내구도가 0이 되는 칸 수 count
				}
			}
			
			//(3번 과정)
			if(Ai[0] != 0) {
				robot[0] = true;
				Ai[0]--;
				
				if(Ai[0]==0) count++;
			}
			
		}
		
		System.out.println(answer);
	}

}
