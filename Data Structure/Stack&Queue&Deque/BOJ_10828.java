package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_10828 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> Stack = new LinkedList<>();
		
		StringTokenizer st;
		String s;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			s=st.nextToken();
			if(s.equals("push")) 
				Stack.addLast(Integer.parseInt(st.nextToken()));
			else if(s.equals("pop")) {
				if(Stack.isEmpty()) bw.write(-1+"\n");
				else bw.write(Stack.removeLast()+"\n");
			}
			else if(s.equals("size"))
				bw.write(Stack.size()+"\n");
			else if(s.equals("empty")) {
				if(Stack.isEmpty()) bw.write(1+"\n");
				else bw.write(0+"\n");
			}
			else {
				if(Stack.isEmpty()) bw.write(-1+"\n");
				else bw.write(Stack.getLast()+"\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

}
