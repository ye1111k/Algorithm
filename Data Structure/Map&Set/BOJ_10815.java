package 백준문제;

import java.io.*;
import java.util.*;

public class BOJ_10815 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<Integer> cards = new HashSet<Integer>();
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		for(int i=0;i<N;i++) 
			cards.add(Integer.parseInt(st.nextToken()));
		
		int M = Integer.parseInt(br.readLine());
		
		str = br.readLine(); 
		st = new StringTokenizer(str);
		
		for(int i=0;i<M;i++) {
			if(cards.contains(Integer.parseInt(st.nextToken()))) System.out.print("1 ");
			else System.out.print("0 ");
		}
	}

}
