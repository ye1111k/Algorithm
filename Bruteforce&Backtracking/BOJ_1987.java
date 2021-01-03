package 백준문제;

import java.util.Scanner;

public class BOJ_1987 {
	static int func(int x,int y,boolean [] a,int R,int C,char [][] A,boolean [][] taken,int now) {
		if(x<0||y<0||x>=C||y>=R||a[A[y][x]-'A']) return now;
		
		int max=0;
		int temp,temp1,temp2,temp3;
		if(!taken[y][x]&&!a[A[y][x]-'A']) {
			taken[y][x]=true;
			a[A[y][x]-'A']=true;
			temp=func(x-1,y,a,R,C,A,taken,now+1);
			if(max<temp) max=temp;
			temp1=func(x+1,y,a,R,C,A,taken,now+1);
			if(max<temp1) max=temp1;
			temp2=func(x,y-1,a,R,C,A,taken,now+1);
			if(max<temp2) max=temp2;
			temp3=func(x,y+1,a,R,C,A,taken,now+1);
			if(max<temp3) max=temp3;
			taken[y][x]=false;
			a[A[y][x]-'A']=false;;
		}
		return max;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int R=input.nextInt();
		int C=input.nextInt();
		
		char [][] A=new char[R][C];
		String s;
		
		for(int i=0;i<R;i++) {
			s=input.next();
			for(int j=0;j<C;j++)
				A[i][j]=s.charAt(j);
		}
		
		boolean [] a=new boolean[26];
		boolean [][] taken=new boolean[R][C];
		
		int ans=func(0,0,a,R,C,A,taken,0);
		System.out.println(ans);
	}

}
