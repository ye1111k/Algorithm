package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		LinkedList<Integer> stack=new LinkedList<Integer>();
		
		StringBuilder sb=new StringBuilder();
		
		boolean ck=false;
		boolean [] check=new boolean[n+1];
		
		int temp,last=1;
		
		for(int i=0;i<n;i++) {
			temp=Integer.parseInt(br.readLine());
			if(stack.isEmpty()) {
				for(int j=last;j<temp;j++) {
					if(!check[j]) {
						check[j]=true;
						stack.addLast(j);
						sb.append("+\n");
					}
				}
				sb.append("+\n-\n");
				check[temp]=true;
				last=temp;
			}
			else if(stack.peekLast()<temp) {
				for(int j=last;j<temp;j++) {
					if(!check[j]) {
						check[j]=true;
						stack.addLast(j);
						sb.append("+\n");
					}
				}
				sb.append("+\n-\n");
				check[temp]=true;
				last=temp;
			}
			else if(stack.peekLast()==temp) {
				stack.removeLast();
				sb.append("-\n");
			}
			else {
				ck=true;
				break;
			}
		}
		if(ck) System.out.println("NO");
		else System.out.println(sb);
	}

}
