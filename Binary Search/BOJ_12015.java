package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_12015 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s=br.readLine();
		int N=Integer.parseInt(s);
		int a,start,end,mid,temp;
		
		s=br.readLine();
		st=new StringTokenizer(s);
		
		ArrayList<Integer> ans=new ArrayList<Integer>();
		ans.add(0);
		
		for(int i=0;i<N;i++) {
			a=Integer.parseInt(st.nextToken());
			if(a>ans.get(ans.size()-1)) {
				ans.add(a);
			}
			else {
				start=1;
				end=ans.size()-1;
				mid=(start+end)/2;
				
				while(start<end) {
					mid=(start+end)/2;
					temp=ans.get(mid);
					if(temp==a) {
						end=mid;
						break;
					}
					else if(temp>a) end=mid;
					else start=mid+1;
				}
				ans.set(end, a);
			}
			
		}
		System.out.println(ans.size()-1);
		
	}

}
