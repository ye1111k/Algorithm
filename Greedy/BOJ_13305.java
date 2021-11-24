package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_13305 {
	public static long solution(int N, long [] road, long [] oil) {
		long answer = 0;
		
		long nowOil = oil[0];
		long nowRoad = road[0];
		
		for(int i=1;i<N-1;i++) {
			if(nowOil>oil[i]) {
				answer += nowOil * nowRoad;
				nowOil = oil[i];
				nowRoad = 0;
			}
			nowRoad += road[i];
		}
		
		answer += nowOil * nowRoad;
		
		return answer;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long [] road = new long[N]; //도로의 길이 저장할 배열
		long [] oil = new long[N]; //각 도시별 기름값 저장할 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		for(int i=0;i<N-1;i++)
			road[i] = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			oil[i] = Long.parseLong(st.nextToken());
		
		long ans = solution(N, road, oil);
		
		System.out.println(ans);
	}

}
