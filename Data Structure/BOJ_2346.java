package 백준문제;

import java.util.*;

public class BOJ_2346 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int N=input.nextInt();
		
		int [] arr=new int[N+1];
		int [] ball=new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=input.nextInt();
			ball[i]=1;
		}
		System.out.print("1 ");
		int now=1,ck;
		int temp=arr[1];
		ball[1]=0;
		for(int i=1;i<N;i++) {
			ck=0;
			if(temp<0) {
				while(true) {
					now--;
					if(now==0) now=N;
					if(ball[now]==1) ck++;
					if(ck==0-temp) break;
				}
			}
			else {
				while(true) {
					now++;
					if(now==N+1) now=1;
					if(ball[now]==1) ck++;
					if(ck==temp) break;
				}
			}
			temp=arr[now];
			ball[now]=0;
			System.out.print(now+" ");
		}
	}
}
