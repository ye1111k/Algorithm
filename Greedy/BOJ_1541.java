package 백준문제;

import java.util.*;

public class BOJ_1541 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		String expression = input.nextLine();
		
		int answer = 0, tmp = 0;
		boolean minus = false;
		String tmpS = "";
		
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)=='+') {
				if(minus) tmp += Integer.parseInt(tmpS);
				else answer += Integer.parseInt(tmpS);
				
				tmpS = "";
			}
			else if(expression.charAt(i)=='-') {
				if(minus) { // '-' 기호가 앞에서 나온 적 있는 경우
					tmp += Integer.parseInt(tmpS);
					
					answer -= tmp;
					
					tmp = 0;
					tmpS = "";
				}
				else { //첫번째 '-' 기호
					answer += Integer.parseInt(tmpS);
					
					tmpS = "";
					
					minus = true;
				}
			}
			else
				tmpS += expression.charAt(i);
		}
		
		//마지막 항 처리
		tmp += Integer.parseInt(tmpS);
		
		if(minus) answer -= tmp;
		else answer += tmp;
		
		System.out.println(answer);
	}

}
