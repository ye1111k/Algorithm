package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4949 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Character> stack=new LinkedList<Character>();
		
		String s;
		char temp;
		
		while(true) {
			s=br.readLine();
			if(s.equals(".")) break;
			
			stack.clear();
			
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='('||s.charAt(i)=='[') stack.addLast(s.charAt(i));
				else if(s.charAt(i)==')') {
					if(stack.isEmpty()) {
						stack.addLast(')');
						break;
					}
					temp=stack.peekLast();
					if(temp=='(') stack.removeLast();
					else stack.addLast(s.charAt(i));
				}
				else if(s.charAt(i)==']') {
					if(stack.isEmpty()) {
						stack.addLast(')');
						break;
					}
					temp=stack.peekLast();
					if(temp=='[') stack.removeLast();
					else stack.addLast(s.charAt(i));
				}
			}
			if(stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
