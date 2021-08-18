package 백준문제;

import java.util.*;

public class BOJ_21557 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int N = Integer.parseInt(input.nextLine());
		
		StringTokenizer st = new StringTokenizer(input.nextLine());
		
		int [] arr = new int[N];
		
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N-3;i++) {
			if(arr[0]>=arr[N-1]) arr[0]--;
			else arr[N-1]--;
		}
		
		if(arr[0]>=arr[N-1]) System.out.println(arr[0]-1);
		else System.out.println(arr[N-1]-1);
	}

}
