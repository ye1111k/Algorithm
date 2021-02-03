package 백준문제;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1697 {
	public static LinkedList<int []> queue=new LinkedList<int []>();
	public static int [] temp1;
	public static int [] temp2;
	public static int [] temp3;
	public static int [] a;
	public static boolean [] ck;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
	
		int N=input.nextInt();
		int K=input.nextInt();
		
		a = new int[2];
		a[0] = N;
		a[1] = 0;
		
		queue.addLast(a);
		
		int ans=0;
		ck=new boolean[2000000];//메모리 초과 해결
		
		while(true) {
			a=queue.removeFirst();
			if(a[0]==K) break; //답일 경우
			if(a[0]>100010||a[0]<0) continue; //index 런타임에러 해결
			if(ck[a[0]]) continue;
			ck[a[0]]=true;
			temp1=new int[2];
			temp2=new int[2];
			temp3=new int[2];
			
			temp1[0]=a[0]-1;//한 칸 뒤로
			temp2[0]=a[0]+1;//한 칸 앞으로
			temp3[0]=a[0]*2;//순간이동
			temp1[1]=a[1]+1;
			temp2[1]=temp1[1];
			temp3[1]=temp1[1];
			
			queue.addLast(temp1);
			queue.addLast(temp2);
			queue.addLast(temp3);
		}
		
		System.out.println(a[1]);
	}

}
