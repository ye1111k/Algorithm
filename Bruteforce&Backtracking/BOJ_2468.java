package ���ع���;

import java.util.Scanner;

public class BOJ_2468 {
	static int N;
	static int [][] A=new int[101][101];

	static int max=0;
	
	static void dfs(int x,int y,int a,boolean [][] B) {
		if(x<0||y<0||x>=N||y>=N) return;//���� ��� ���
		if(A[y][x]<=a||B[y][x]) return;//�̹� ������ ĭ�̰ų� ���� ���� ���
		
		B[y][x]=true;//�̹� ������ �������� ���� �ٲٱ�
		
		dfs(x,y+1,a,B);//�Ʒ�ĭ
		dfs(x,y-1,a,B);//��ĭ
		dfs(x-1,y,a,B);//����ĭ
		dfs(x+1,y,a,B);//������ĭ
		
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		N=input.nextInt();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				A[i][j]=input.nextInt();
		}
		
		int max=0;
		
		for(int i=0;i<=100;i++) {//���� ����� �ʴ� ������ �� 100��ŭ ���� ������ üũ
			int temp=0;//���������� �ʱ�ȭ
			boolean [][] B=new boolean[101][101];//���������� �ʱ�ȭ22
			for(int j=0;j<N;j++) {//��� ĭ üũ
				for(int k=0;k<N;k++) {
					if(!B[k][j]&&A[k][j]>i) {//���� �������� ���� ĭ�̰ų� �� ����� ���� ��쿡�� üũ
						dfs(j,k,i,B);//����ִ� ��� �κ� ���� �ٲٱ�(�ڵ� ���� ������ ���⼭ ���� �ٲ� �κ��� �ϳ��� ���� ����)
						temp++;//�������� ���� �߰�
					}
				}
					
			}
			if(max<temp) max=temp;//�ִ� üũ
		}
		
		System.out.println(max);
	}

}
