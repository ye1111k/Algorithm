package 백준문제;

import java.util.*;
import java.io.*;

class AB {
	int a;
	int b;
	
	public AB(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class BOJ_2180 {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		AB [] ab = new AB[n];
		
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			ab[i] = new AB(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(ab, new Comparator<AB>() {
			public int compare(AB o1, AB o2) {
				if(o1.a==0&&o2.a==0) return o2.b-o1.b;
				else if(o1.a==0&&o2.a!=0)
					return 1;
				else if(o1.a!=0&&o2.a==0) return -1;
				double temp1 = (double)o1.b/(double)o1.a;
				double temp2 = (double)o2.b/(double)o2.a;
				if(temp1<temp2) return -1;
				else return 1;
			}
		});
		
		long ans = 0;
		long temp;
		
		for(int i=0;i<n;i++) {
			temp = (long)ans*ab[i].a + (long)ab[i].b;
			ans += temp;
			ans%=40000;
		}
		
		System.out.println(ans);
		
	}

}
