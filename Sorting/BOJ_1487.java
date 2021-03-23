package 백준문제;
import java.util.*;
import java.io.*;

public class BOJ_1487 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s=br.readLine();
		int n=Integer.parseInt(s);
		
		int [][] A=new int[n][2];
		
		for(int i=0;i<n;i++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			
			A[i][0]=Integer.parseInt(st.nextToken());
			A[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A,new Comparator<int []>() {
			public int compare(int [] o1, int [] o2) {
				return o1[0]-o2[0];
			}
		});
		
		int ans=987654321,now,temp,max=0;
		
		for(int i=0;i<n;i++) {
			now=A[i][0];
			temp=0;
			for(int j=0;j<n;j++) {
				if(now<=A[j][0]&&now>A[j][1]) {
					temp+=(now-A[j][1]);
				}
			}
			if(temp>max) {
				max=temp;
				ans=now;
			}
		}
		if(ans!=987654321) System.out.println(ans);
		else System.out.println(0);
	}

}
