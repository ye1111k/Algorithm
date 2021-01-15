package 백준문제;

import java.util.Scanner;

public class BOJ_1992 {
	
	public static String func(int y, int x, int N, char [][] quad) {
		String s="";
		if(N==0) {
			if(quad[y][x]=='1') return "1";
			else return "0";
		}
		
		if(N==1) {
			if(quad[y][x]==quad[y+1][x]&&quad[y+1][x]==quad[y][x+1]&&quad[y][x+1]==quad[y+1][x+1])
				return Character.toString(quad[y][x]);
			s="(";
			s+=Character.toString(quad[y][x]);
			s+=Character.toString(quad[y][x+1]);
			s+=Character.toString(quad[y+1][x]);
			s+=Character.toString(quad[y+1][x+1]);
			s+=")";
		}
		else {
			String s1=func(y,x,N/2,quad);
			String s2=func(y,x+N,N/2,quad);
			String s3=func(y+N,x,N/2,quad);
			String s4=func(y+N,x+N,N/2,quad);
			
			if(s1.equals(s2)&&s2.equals(s3)&&s3.equals(s4)&&s1.length()==1) return s1;
			else s="("+s1+s2+s3+s4+")";
		}
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		int N=input.nextInt();
		
		char [][] quad=new char[70][70];
		String s;
		
		for(int i=0;i<N;i++) {
			s=input.next();
			for(int j=0;j<N;j++) {
				quad[i][j]=s.charAt(j);
			}
		}
		s=func(0,0,N/2,quad);
		System.out.println(s);
	}

}
