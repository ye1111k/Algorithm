package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_2504 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> Stack = new LinkedList<>();
		
		int temp,temp1,answer=0;
		boolean ck=false;
		
		String s=br.readLine();
		for(int i=0;i<s.length();i++) {
			if(ck) break;
			if(s.charAt(i)=='(') 
				Stack.addLast(0);
			else if (s.charAt(i)=='[')
				Stack.addLast(1);
			else {
				if(Stack.isEmpty()) {
					ck=true;
					break;
				}
				temp1 = 1;
				if(s.charAt(i)==')') {
					while(true) {
						if(Stack.isEmpty()) {
							ck = true;
							break;
						}
						temp = Stack.removeLast();
						if(temp==0) {
							Stack.addLast(temp1*2);
							break;
						}
						else if(temp==1) {
							ck=true;
							break;
						}
						else {
							if(temp1!=1) temp1+=temp;
							else temp1=temp;
						}
					}
				}
				else {
					while(true) {
						if(Stack.isEmpty()) {
							ck = true;
							break;
						}
						temp = Stack.removeLast();
						if(temp == 1) {
							Stack.addLast(temp1 * 3);
							break;
						}
						else if(temp == 0) {
							ck = true;
							break;
						}
						else {
							if(temp1 != 1) temp1 += temp;
							else temp1 = temp;
						}
					}
				}
			}
		}
		
		if(Stack.isEmpty()) ck = true;
		else {
			if(Stack.getFirst()==0||Stack.getFirst()==1) ck = true;
		}
		
		if(!ck) {
			while(!Stack.isEmpty())
				answer+=Stack.removeFirst();
		}
		
		
		System.out.println(answer);
	}

}
