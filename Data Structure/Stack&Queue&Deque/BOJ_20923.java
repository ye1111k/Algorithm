package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_20923 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		LinkedList<Integer> Do = new LinkedList<>();
		LinkedList<Integer> Su = new LinkedList<>();
		LinkedList<Integer> tempDo = new LinkedList<>();
		LinkedList<Integer> tempSu = new LinkedList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			Do.addLast(Integer.parseInt(st.nextToken()));
			Su.addLast(Integer.parseInt(st.nextToken()));
		}
		
		int s = 0,d = 0; //s는 수연이, d는 도도의 그라운드 맨 위에 있는 카드
		
		for(int i=0;i<M;i++) {
			if(i%2 == 0) { //도도 차례 - 맨 위에 있는 카드를 뒤집는다(tempDo의 앞에 집어넣는다고 생각하기)
				d = Do.removeLast();
				tempDo.addFirst(d);
			}
			else { //수연 차례
				s = Su.removeLast();
				tempSu.addFirst(s); 
			}
			
			if(Do.isEmpty()) { //도도 카드 없을 경우
				while(!tempDo.isEmpty())
					Su.addFirst(tempDo.removeLast()); //상대 카드 뒤집어서 합치기
				while(!tempSu.isEmpty()) 
					Su.addFirst(tempSu.removeLast()); //내 카드 뒤집어서 합치기
				
				break; //카드 없으면 끝~!
			}
			else if(Su.isEmpty()) { //수연이 카드 없을 경우
				while(!tempSu.isEmpty())
					Do.addFirst(tempSu.removeLast()); //상대 카드 뒤집어서 합치기
				while(!tempDo.isEmpty())
					Do.addFirst(tempDo.removeLast()); //내 카드 뒤집어서 합치기
				
				break; //카드 없으면 끝~!
			}
			
			else if(d == 5 || s == 5) { //도도가 종 친 경우
				while(!tempSu.isEmpty())
					Do.addFirst(tempSu.removeLast()); //상대 카드 뒤집어서 합치기
				while(!tempDo.isEmpty())
					Do.addFirst(tempDo.removeLast()); //내 카드 뒤집어서 합치기
				
				//나머지 초기화
				s = 0;
				d = 0;
			}
			else if(d + s == 5) { //수연이가 종 친 경우
				while(!tempDo.isEmpty())
					Su.addFirst(tempDo.removeLast()); //상대 카드 뒤집어서 합치기
				while(!tempSu.isEmpty()) 
					Su.addFirst(tempSu.removeLast()); //내 카드 뒤집어서 합치기
				
				//나머지 초기화
				s = 0;
				d = 0;
			}
		}
		
		if(Do.size()>Su.size()) System.out.println("do");
		else if(Do.size()<Su.size()) System.out.println("su");
		else System.out.println("dosu");
	}

}
