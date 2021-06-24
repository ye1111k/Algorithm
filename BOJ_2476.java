package 백준문제;
import java.util.*;
public class BOJ_2476 {
	public static int max(int a, int b, int c) {
		if(a>=b&&a>=c) return a;
		else if(b>=a&&b>=c) return b;
		else return c;
	}
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		int N=input.nextInt();
		int a,b,c;
		int max=0,temp;
		for(int i=0;i<N;i++) {
			a=input.nextInt();
			b=input.nextInt();
			c=input.nextInt();
			
			if(a==b&&b==c) temp=a*1000+10000;
			else if(a==b&&a!=c) temp=a*100+1000;
			else if(b==c&&b!=a) temp=b*100+1000;
			else if(a==c&&a!=b) temp=c*100+1000;
			else temp=max(a,b,c)*100;
			
			if(max<temp) max=temp;
		}
		System.out.println(max);
	}
}
