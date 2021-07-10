package 백준문제;

import java.util.*;

public class BOJ_10804 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int [] arr=new int[21];
		for(int i=1;i<=20;i++)
			arr[i]=i;
		
		int a,b,temp;
		
		for(int i=0;i<10;i++) {
			a=input.nextInt();
			b=input.nextInt();
			
			for(int j=0;j<=(b-a)/2;j++) {
				temp=arr[a+j];
				arr[a+j]=arr[b-j];
				arr[b-j]=temp;
			}
		}
		
		for(int i=1;i<=20;i++)
			System.out.print(arr[i]+" ");
	}

}
