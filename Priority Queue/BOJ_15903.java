package 백준문제;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_15903 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int n=input.nextInt();
		int m=input.nextInt();
		
		PriorityQueue<Long> pq=new PriorityQueue<Long>();
		
		long temp,temp1,temp2,sum=0;
		for(int i=0;i<n;i++) {
			temp=input.nextLong();
			pq.add(temp);
		}
		
		for(int i=0;i<m;i++) {
			temp=pq.remove();
			temp1=pq.remove();
			temp2=temp+temp1;
			pq.add(temp2);
			pq.add(temp2);
		}
		for(int i=0;i<n;i++) {
			sum+=pq.remove();
		}
		System.out.println(sum);
		
	}

}
