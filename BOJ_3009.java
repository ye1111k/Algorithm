package 백준문제;

import java.util.*;

public class BOJ_3009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int [] x=new int[3];
		int [] y=new int[3];
		
		for(int i=0;i<3;i++) {
			x[i]=input.nextInt();
			y[i]=input.nextInt();
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		
		if(x[0]!=x[1]) System.out.print(x[0]);
		else System.out.print(x[2]);
		
		if(y[0]!=y[1]) System.out.println(" "+y[0]);
		else System.out.println(" "+y[2]);
		
	}

}
