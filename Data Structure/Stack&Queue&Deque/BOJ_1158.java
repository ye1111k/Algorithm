package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_1158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		LinkedList<Integer> Queue=new LinkedList<Integer>();
		int N=input.nextInt();
		int K=input.nextInt();
		
		for(int i=1;i<=N;i++)
			Queue.addLast(i);
		
		int temp;
		
		System.out.print("<");
		
		while(Queue.size()>1) {
			for(int i=0;i<K-1;i++) {
				temp=Queue.removeFirst();
				Queue.addLast(temp);
			}
			System.out.print(Queue.removeFirst()+", ");
		}
		
		System.out.println(Queue.removeFirst()+">");
	}

}
