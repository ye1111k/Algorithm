package 백준문제;

import java.util.*;

public class BOJ_11582 {
	static int [] arr;
	static int [] temp;
	
	public static void mergeSort(int start, int end) {
		int mid=(start+end)/2;
		int p=start;
		int q=mid+1;
		int i=p;
		
		while(p<=mid||q<=end) {
			if(q>end || (p<=mid && arr[p]<arr[q])) temp[i++]=arr[p++];
			else temp[i++]=arr[q++];
		}
		
		for(i=start;i<=end;i++)
			arr[i]=temp[i];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		StringTokenizer st;
		
		int N=Integer.parseInt(input.nextLine());
		st=new StringTokenizer(input.nextLine());
		int k=Integer.parseInt(input.nextLine());
		
		arr=new int[N];
		temp=new int[N];
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		int a=N/2; //현재 몇 조각으로 나눴는지 저장할 변수 
		int b=2; //현재 한 단위의 크기가 몇인지 저장할 변수
		
		while(true) {
			for(int i=0;i<N;i+=b)
				mergeSort(i,i+b-1);
			
			if(a==k) break;
			
			b*=2;
			a/=2;
		}
		
		for(int i=0;i<N;i++)
			System.out.print(arr[i]+" ");
	}

}
