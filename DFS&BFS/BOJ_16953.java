package 백준문제;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_16953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		long A=input.nextLong();
		long B=input.nextLong();
		
		LinkedList<long []> queue=new LinkedList<long []>();
		
		long [] a= {A,0};
		boolean ck=false;
		queue.addLast(a);
		
		long [] temp = {0,0};
		long [] temp1;
		long [] temp2;
		
		while(!queue.isEmpty()) {
			temp=queue.removeFirst();
			if(temp[0]==B) {
				ck=true;
				break;
			}
			if(temp[0]>B/2+1) continue;
			temp1= new long[2];
			temp2= new long[2];
			temp1[0]=temp[0]*2;
			temp1[1]=temp[1]+1;
			queue.addLast(temp1);
			temp2[0]=temp[0]*10+1;
			temp2[1]=temp1[1];
			queue.addLast(temp2);
		}
		
		if(ck) System.out.println(temp[1]+1);
		else System.out.println(-1);
		
	}

}
