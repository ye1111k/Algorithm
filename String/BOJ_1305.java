package 백준문제;

import java.util.Scanner;

public class BOJ_1305 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int L=input.nextInt();
		String s=input.next();
		
		int [] f=new int[L];
		
		int j=0;
		
		for(int i=1;i<L;i++) {
			while(j>0&&s.charAt(i)!=s.charAt(j))
				j=f[j-1];
			if(s.charAt(i)==s.charAt(j))
				f[i]=++j;
		}
		
		System.out.println(L-f[L-1]);
		
	}

}
