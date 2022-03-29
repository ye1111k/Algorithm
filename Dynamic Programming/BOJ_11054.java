package 백준문제;

import java.util.Scanner;

public class BOJ_11054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int A=input.nextInt();
		
		int [] a=new int[A];
		int [] b=new int[A];
		int [] c=new int[A];
		
		int m,n;
		
		for(int i=0;i<A;i++) {
			m=1;
			a[i]=input.nextInt();
			for(int j=0;j<i;j++)
				if(a[j]<a[i]&&m<=b[j]) m=b[j]+1;
			b[i]=m;
		}
		for(int i=A-1;i>=0;i--) {
			n=1;
			for(int j=A-1;j>i;j--)
				if(a[j]<a[i]&&n<=c[j]) n=c[j]+1;
			c[i]=n;
		}
		int max=b[0]+c[0];
		for(int i=1;i<A;i++)
			if(max<b[i]+c[i]) max=b[i]+c[i];
		System.out.println(max-1);
	}

}
