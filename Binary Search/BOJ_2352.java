package 백준문제;

import java.util.*;

public class BOJ_2352 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		int [] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(input.nextLine());
		
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> semicon = new ArrayList<Integer>();
			
		int start, end, middle, temp;
		
		semicon.add(arr[0]);
		
		for(int i=1;i<n;i++) {
			start = 0;
			end = semicon.size()-1;
			if(arr[i]>semicon.get(end)) {
				semicon.add(arr[i]);
				continue;
			}
			while(start<end) {
				middle = (start+end)/2;
				temp = semicon.get(middle);
				
				if(temp>arr[i]) end = middle;
				else start = middle+1;
			}
			semicon.set(end, arr[i]);
		}
		
		System.out.println(semicon.size());
		for(int i=0;i<semicon.size();i++)
			System.out.println(semicon.get(i));
	}

}
