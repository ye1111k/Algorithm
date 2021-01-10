package 백준문제;

import java.util.Scanner;

public class BOJ_4796 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int L,P,V,i=1;
		int a;
		
		while(true) {
			L=input.nextInt();
			P=input.nextInt();
			V=input.nextInt();
			
			if(L==0&&P==0&&V==0) break;
			
			a=(V/P)*L;
			if(V%P<L) a+=V%P;
			else a+=L;
			
			System.out.println("Case "+i+": "+a);
			i++;
		}
	}

}
