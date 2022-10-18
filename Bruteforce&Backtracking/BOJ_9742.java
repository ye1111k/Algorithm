package 백준문제;

import java.util.*;

public class BOJ_9742 {
	
	private static boolean [] visited;
	private static char []  answer;
	private static int now;
	
	public static int fac(int n) {
		if(n==1) return 1;
		return fac(n-1)*n;
	}
	
	public static void backtracking(int n, char [] str, int length, int nowLength, char [] nowString) {
		if(length==nowLength) {
			now++; 
			//몇 번째로 만들어진 경우인지 체크
			if(now==n) {
				answer = new char[length];
				for(int i=0;i<length;i++)
					answer[i] = nowString[i];
			}
			return;
		}
		
		for(int i=0;i<length;i++) {
			if(visited[i]) continue;
			visited[i]=true;
			nowString[nowLength]=str[i]; //집합에 새로운 문자 추가
			backtracking(n,str, length, nowLength+1, nowString);
			visited[i]=false;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		StringTokenizer st;
		
		String s,ansStr;
		int n;
		char [] str;
		
		String noPer = "No permutation";
		char [] noPermutation = noPer.toCharArray();
		
		while(input.hasNext()) { //입력이 끝날 때까지
			st = new StringTokenizer(input.nextLine());
			
			s = st.nextToken();
			str = s.toCharArray();
			n = Integer.parseInt(st.nextToken());
			
			//초기화
			visited = new boolean[s.length()];
			now = 0;
			
			if(n>fac(s.length())) answer = noPermutation; //n이 만들어질 수 있는 집합의 수보다 클 경우
			else backtracking(n,str,s.length(),0, new char[s.length()]);
			
			//정답 문자열로 만들기
			ansStr = "";
			for(int i=0;i<answer.length;i++)
				ansStr+=answer[i];
			
			System.out.println(s+" "+n+" = "+ansStr);
		}
	}

}
