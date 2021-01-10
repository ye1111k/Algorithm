package 백준문제;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		int M=input.nextInt();
		
		int [] rc=new int[1010];
		int [] drc=new int[1010];
		
		int x=0,y=0,temp;
		int i=0,j=0,ans=0;
		
		for(int a=0;a<N;a++) {
			temp=input.nextInt();
			if(temp==10) ans++;
			else if(temp%10==0) drc[y++]=temp;
			else rc[x++]=temp;
		}
		
		Arrays.parallelSort(drc, 0, y-1);
		
		while(true) {
			if(i>=M||j>=N) break;
			if(j<y) {
				if(drc[j]/10-1<=M-i) {
					ans+=(drc[j]/10);
					i+=(drc[j]/10-1);
					j++;
				}
				else {
					ans+=M-i;
					break;
				}
			}
			else {
				if(rc[j-y]<10) {
					j++;
					continue;
				}
				else if(rc[j-y]/10<=M-i){
					ans+=(rc[j-y]/10);
					i+=(rc[j-y]/10);
					j++;
				}
				else {
					ans+=M-i;
					break;
				}
			}			
		}
		
		System.out.println(ans);
	}

}
