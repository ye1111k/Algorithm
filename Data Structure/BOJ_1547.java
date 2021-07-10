package 백준문제;

import java.util.*;

public class BOJ_1547 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int M=input.nextInt();
		
		int ans=1;
		int temp;
		
		int a,b;
		
		for(int i=0;i<M;i++) {
			a=input.nextInt();
			b=input.nextInt();
			
			temp=ans;
			
			if(a==ans) temp=b;
			else if(b==ans) temp=a;
			
			ans=temp;
		}
		
		System.out.println(ans);
		
	}

}
