package 백준문제;

import java.io.*;
import java.util.*;
class node{
	int value;
	int L;
	int R;
}
public class BOJ_5639 {
	static int [][] tree;
	static int [] arr;
	static int now=0;
	static int N;
	
	static void insert(int node, int value, int index) {
		if(tree[node][0]>value) {
			if(tree[node][1]==0) tree[node][1]=index;
			else insert(tree[node][1],value,index);
		}
		else{
			if(tree[node][2]==0) tree[node][2]=index;
			else insert(tree[node][2],value,index);
		}
	}
	static void post(int N) {
		if(tree[N][1]!=0) post(tree[N][1]); //왼쪽
		if(tree[N][2]!=0) post(tree[N][2]); //오른쪽
		System.out.println(tree[N][0]); //루트
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		N=0;
		String s;
		
		arr=new int[10101];
		tree=new int[10101][3];
		
		while(input.hasNextLine()) {
			try {
				s=input.nextLine();
				arr[N]=Integer.parseInt(s);
				tree[N+1][0]=arr[N];
				N++;
			}
			catch (Exception e){
				break;
			}
		}
		
		for(int i=1;i<N;i++)
			insert(1,arr[i],i+1);
		
		post(1);
	}

}
