package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_1863 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		LinkedList<Integer> stack=new LinkedList<Integer>();
		
		int x,y;
		
		String s;
		StringTokenizer st;
		
		int count=0,temp=0;
		
		for(int i=0;i<n;i++) {

			s=br.readLine();
			st=new StringTokenizer(s);
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				temp=stack.peekLast();
				if(temp>y) stack.removeLast();
				else break;
			}
			if(temp<y||(stack.isEmpty()&&y>0)) count++;
			stack.addLast(y);
		}
		System.out.println(count);
	}	

}
