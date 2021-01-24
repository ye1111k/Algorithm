package 백준문제;

import java.util.Scanner;

public class BOJ_10775 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int G=input.nextInt();
		int P=input.nextInt();
		
		boolean [] d=new boolean[101001];
		int [] ds=new int[101001];
		
		int temp,ans=0,temp1;
		boolean ck=false;
		
		for(int i=1;i<=100000;i++)
			ds[i]=i;
		
		for(int i=1;i<=P;i++) {
			if(ck) {
				for(int j=i;j<=P;j++)
					temp=input.nextInt();
				break;
			}
			temp=input.nextInt();
			while(true) {
				if(ds[temp]<=0) {
					ck=true;
					break;
				}
				if(!d[ds[temp]]) {
					d[ds[temp]]=true;
					ds[temp]--;
					ans++;
					break;
				}
				if(ds[temp]==temp) {
					ds[temp]--;
					temp--;
				}
				else {
					temp1=ds[temp];
					ds[temp]=ds[temp1];
					temp=temp1;
				}
			}
		}
		
		System.out.println(ans);
	}

}
