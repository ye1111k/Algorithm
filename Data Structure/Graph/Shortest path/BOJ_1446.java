package 백준문제;

import java.io.*;
import java.util.*;
class Shortcut_1446{
	int start;
	int end;
	int dis;
	
	public Shortcut_1446(int start, int end, int dis) {
		this.start = start;
		this.end = end;
		this.dis = dis;
	}
}
public class BOJ_1446 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		ArrayList<Shortcut_1446> [] sc = new ArrayList[D+1]; //도착점이 i인 지름길 저장할 arraylist
		int [] dp = new int[D+1];
		
		for(int i=0;i<=D;i++) {
			dp[i] = i;
			sc[i] = new ArrayList<Shortcut_1446>();
		}
		
		int start, end, dis;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			dis = Integer.parseInt(st.nextToken());
			
			sc[end].add(new Shortcut_1446(start, end, dis));
		}
		
		for(int i=1;i<=D;i++) {
			if(sc[i].isEmpty()) dp[i] = dp[i-1]+1;
			else {
				for(Shortcut_1446 temp: sc[i]) {
					dp[i] = Math.min(dp[i], Math.min(dp[i-1]+1, dp[temp.start]+temp.dis));
				}
			}
		}
			
		System.out.println(dp[D]);
		
		
	}

}
