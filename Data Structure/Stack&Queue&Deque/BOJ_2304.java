package 백준문제;

import java.util.*;
import java.io.*;

public class BOJ_2304 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		String s;
		StringTokenizer st;
		
		LinkedList<int []> xy=new LinkedList<int []>();
		
		int [][] arr=new int[n][2];
		
		for(int i=0;i<n;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int []>() {
			public int compare(int [] o1, int [] o2) {
				return o1[0]-o2[0];
			}
		});
		
		int ans=0,x,y,tmp=0;
		int [] temp;
		int [] temp1;
		
		for(int i=0;i<n;i++) {
			if(xy.size()<2) xy.addLast(arr[i]);
			else {
				while(xy.size()>=2) {
					temp=xy.removeLast();
					temp1=xy.peekLast();
					
					if(temp[1]<temp1[1]&&temp[1]<arr[i][1]) continue;
					
					xy.addLast(temp);
					break;
				}
				xy.addLast(arr[i]);
			}
		}
		
		temp=xy.removeFirst();
		ans+=temp[1];
		
		y=temp[1];
		x=temp[0];
		
		while(!xy.isEmpty()) {
			temp=xy.removeFirst();
			if(temp[1]>y) ans+=y*(temp[0]-x-1)+temp[1];
			else if(temp[1]==y) ans+=y*(temp[0]-x);
			else ans+=temp[1]*(temp[0]-x);
			x=temp[0];
			y=temp[1];
		}
		
		System.out.println(ans);
	}
}
