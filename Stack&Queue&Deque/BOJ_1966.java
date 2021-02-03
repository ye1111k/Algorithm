package 백준문제;

import java.util.*;

public class BOJ_1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int T=input.nextInt();
		
		LinkedList<int []> queue;
		int N,M,cnt;
		int [] a;
		int [] b;
		boolean ck;
		
		for(int i=0;i<T;i++) {
			queue=new LinkedList<int []>();
			N=input.nextInt();
			M=input.nextInt();
			for(int j=0;j<N;j++) {
				a=new int[2];
				a[0]=input.nextInt();
				a[1]=j;
				queue.addLast(a);
			}
			cnt=1;
			while(!queue.isEmpty()) {
				ck=false;
				a=queue.removeFirst();
				
				for(int j=0;j<queue.size();j++) {
					b=queue.get(j);
					if(b[0]>a[0]) ck=true;
				}
				
				if(ck) queue.addLast(a);
				else {
					if(a[1]==M) {
						sb.append(Integer.toString(cnt)+"\n");
						break;
					}
					cnt++;
				}
			}
			
		}
		System.out.println(sb);
	}

}
