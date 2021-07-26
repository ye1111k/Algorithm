package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_3078 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long [] friends = new long[21]; //friends[i] = 현재 슬라이딩 윈도우 내에서 이름 길이가 i인 학생의 수
		
		long answer = 0;
		LinkedList<String> names = new LinkedList<String>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String name;
		
		for(int i=0;i<N;i++) {
			name = br.readLine();
			
			//입력받은 친구에 대한 정보 추가
			names.addLast(name);
			friends[name.length()]++;
			
			if(names.size() > K + 1) //슬라이딩 윈도우의 크기가 K가 넘어갈 경우
				friends[names.removeFirst().length()]--;
			
			answer += friends[name.length()] - 1; //i번째 등수의 친구부터 앞으로 K명 중에서 이름의 길이가 같은 친구의 수
		}
		
		System.out.println(answer);
	}
		

}
