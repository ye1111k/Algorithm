package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_20301 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<Integer> deque=new LinkedList<Integer>();
		
		boolean ck=false;
		
		int N=input.nextInt();
		int K=input.nextInt();
		int M=input.nextInt();
		
		for(int i=1;i<=N;i++)
			deque.addLast(i);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<K-1;j++) {
				if(!ck)
					deque.addLast(deque.removeFirst());
				else deque.addFirst(deque.removeLast());
			}
			if(!ck) bw.write(deque.removeFirst()+"\n");
			else bw.write(deque.removeLast()+"\n");
			if((i+1)%M==0) ck=!ck;
		}
		bw.flush();
		bw.close();
	}

}
