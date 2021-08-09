package 백준문제;

import java.util.*;

public class BOJ_2343 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(input.nextLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] blueray = new int[N];
		
		st = new StringTokenizer(input.nextLine());
		
		int start = 1, end = 1000000000, mid, ans = end;
		int temp, temp1;
		
		for(int i=0;i<N;i++) {
			blueray[i] = Integer.parseInt(st.nextToken());
			if(blueray[i] > start) start = blueray[i];
		}
		
		while(start<=end) {
			mid = (start+end)/2;
			temp = M-1;
			temp1 = mid;
			for(int i=0;i<N;i++) {
				if(blueray[i]>temp1) {
					temp--;
					temp1 = mid;
				}
				temp1 -= blueray[i];
			}
			if(temp>=0) {
				end = mid-1;
				ans = mid;
			}
			else start = mid+1;
		}
		
		System.out.println(ans);
	}

}
