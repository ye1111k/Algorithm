package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_18258 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		int N=Integer.parseInt(s);
		int a;
		String temp;
		
		LinkedList<Integer> queue=new LinkedList<Integer>();
		
		for(int i=0;i<N;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			temp=st.nextToken();
			if(temp.equals("push")) {
				a=Integer.parseInt(st.nextToken());
				queue.add(a);
			}
			else if(temp.equals("pop")) {
				if(queue.isEmpty()) bw.write(-1+"\n");
				else bw.write(queue.removeFirst()+"\n");
			}
			else if(temp.equals("size")) bw.write(queue.size()+"\n");
			else if(temp.equals("empty")) {
				if(queue.isEmpty()) bw.write(1+"\n");
				else bw.write(0+"\n");
			}
			else if(temp.equals("front")) {
				if(queue.isEmpty()) bw.write(-1+"\n");
				else bw.write(queue.getFirst()+"\n");
			}
			else {
				if(queue.isEmpty()) bw.write(-1+"\n");
				else bw.write(queue.getLast()+"\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
